package com.prototype.hellostranger.hellostrangerprototype01;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class TagActivity extends ActionBarActivity {

    EditText mDisplayDbEt = null;
    EditText mInsertTag = null;

    public HSDBManager mDbManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag);

        mDisplayDbEt = (EditText) findViewById(R.id.tagoutput);
        mInsertTag = (EditText) findViewById(R.id.tag);
        mDbManager = HSDBManager.getInstance(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insert: {
                ContentValues addRowValue = new ContentValues();

                //사용자로부터 입력 받은 태그
                String mTag = mInsertTag.getText().toString();

                addRowValue.put("tag", mTag);


                long insertRecordId = mDbManager.insert(addRowValue);
                mDisplayDbEt.setText("레코드 추가 : " + insertRecordId);

                Toast.makeText(getApplicationContext(), mTag + " 태그 추가", Toast.LENGTH_LONG).show();


                break;

            }

            // 2. 레코드 쿼리
            // ================================================================
            case R.id.query: {
                String[] columns = new String[]{"_id", "tag"};

                Cursor c = mDbManager.query(columns,
                        null, null, null, null, null);

                if (c != null) {
                    mDisplayDbEt.setText("태그 목록: \n");


                    while (c.moveToNext()) {
                        int id = c.getInt(0);
                        String tag = c.getString(1);


                        mDisplayDbEt.append(
                                "id : " + id + "\n" +
                                        "tag : " + tag + "\n" +
                                        "----------------------------------\n");
                    }

                    mDisplayDbEt.append("\n 총 태그수 : " + c.getCount());

                    c.close();
                }

                break;
            }
            // ================================================================

            // 4. 특정 레코드 삭제하기
            // ================================================================
            case R.id.delete :
            {
                int deleteRecordCnt = mDbManager.delete( null, null );
                mDisplayDbEt.setText( "삭제된 레코드 수 : " + deleteRecordCnt );

                break;
            }
            // ================================================================

        }


    }


/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tag, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
