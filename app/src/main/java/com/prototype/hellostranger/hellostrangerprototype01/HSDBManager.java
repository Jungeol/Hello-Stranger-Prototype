package com.prototype.hellostranger.hellostrangerprototype01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by es-mac on 15. 4. 5..
 */
public class HSDBManager {
    // DB 명, 테이블 명, DB 버전 정보를 정의한다.
    // ========================================================================
    static final String DB_STUDENTS     = "HSUsers.db";
    static final String TABLE_HS_USER_TAGS  = "User_Tags";
    static final int        DB_VERSION      = 1;
    // ========================================================================


    Context mContext    = null;

    public static HSDBManager mDbManager = null;
    private SQLiteDatabase mDatabase = null;

    public static HSDBManager getInstance( Context context )
    {
        if ( mDbManager == null )
        {
            mDbManager = new HSDBManager( context );
        }

        return mDbManager;
    }

    private HSDBManager( Context context )
    {
        mContext    = context;

        // 1. DB Manager를 생성할 때 DB 생성 및 열어 둔다.
        // ====================================================================
        mDatabase   = context.openOrCreateDatabase( DB_STUDENTS,
                Context.MODE_PRIVATE,
                null );
        // ====================================================================

        // 2. 만일 DB에 테이블이 존재하지 않으면 생성한다.
        // ====================================================================
        mDatabase.execSQL( "CREATE TABLE IF NOT EXISTS  " + TABLE_HS_USER_TAGS +
                "(" + "_id  INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "tag        TEXT); ");
        // ====================================================================
    }

    public long insert( ContentValues addRowValue )
    {
        // 아래와 같이 execSQL 함수를 이용해 직접 SQL 문으로
        // 레코드를 추가할 수도 있다.
        /* --------------------------------------------------------------------
        mDatabase.execSQL( "INSERT INTO " + TABLE_STUDENTS +
                             " VALUES(" +
                                     "null, " +
                                     "'200106054'," +
                                     "'홍길동'," +
                                     "'컴퓨터'," +
                                     "3);" );
        -------------------------------------------------------------------- */

        return mDatabase.insert( TABLE_HS_USER_TAGS, null, addRowValue );
    }

    public Cursor query( String[] columns,
                         String selection,
                         String[] selectionArgs,
                         String groupBy,
                         String having,
                         String orderBy )
    {
        // 아래와 같이 rawQuery 함수를 이용해 직접 SELECT 문으로
        // 추가된 레코드 정보를 얻어올 수도 있다.
        /* --------------------------------------------------------------------
        Cursor   c = null;
        c = mDatabase.rawQuery( "SELECT * FROM " + TABLE_STUDENTS, null );
        -------------------------------------------------------------------- */

        return mDatabase.query( TABLE_HS_USER_TAGS,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy);
    }

    public int update( ContentValues updateRowValue,
                       String whereClause,
                       String[] whereArgs )
    {
        // 아래와 같이 execSQL 함수를 이용해 직접 SQL 문으로
        // 레코드를 갱신할 수도 있다.
        /* --------------------------------------------------------------------
        mStudentsDB.execSQL( "UPDATE " + TABLE_STUDENTS +
                             " SET name = '고길동'" +
                             " WHERE number = '200106054';" );
        -------------------------------------------------------------------- */

        return mDatabase.update( TABLE_HS_USER_TAGS,
                updateRowValue,
                whereClause,
                whereArgs );
    }

    public int delete( String whereClause,
                       String[] whereArgs )
    {
        // 아래와 같이 execSQL 함수를 이용해 직접 SQL 문으로
        // 레코드를 삭제할 수도 있다.
        /* --------------------------------------------------------------------
        mStudentsDB.execSQL( "DELETE FROM " + TABLE_STUDENTS );
        -------------------------------------------------------------------- */

        return mDatabase.delete( TABLE_HS_USER_TAGS, whereClause, whereArgs );
    }


}
