package com.prototype.hellostranger.hellostrangerprototype01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;



/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final String fixedId = "hs";
        final String fixedPw = "hs";

        ImageButton ibSignIn = (ImageButton) findViewById(R.id.singinbtn);
        ibSignIn.setOnClickListener(new OnClickListener() {
            EditText etId = (EditText) findViewById(R.id.uemail);
            EditText etPw = (EditText) findViewById(R.id.upass);


            @Override
            public void onClick(View v) {


                String mUserId = etId.getText().toString();
                String mUserPw = etPw.getText().toString();

                Log.i("아이디", mUserId);
                Log.i("비밀번호", mUserPw);

                Toast.makeText(LoginActivity.this, "아이디: " + mUserId, Toast.LENGTH_SHORT).show();
                Toast.makeText(LoginActivity.this, "비밀번호: " + mUserPw, Toast.LENGTH_SHORT).show();
                if ((mUserId != "") && (mUserPw != "")) {
                    if ((mUserId != fixedId) || (mUserPw != fixedPw)) {
                        Toast.makeText(LoginActivity.this, "아이디 혹은 비밀번호를 잘못 입력하셧습니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "아이디 혹은 비밀번호를 제대로 입력해주세요", Toast.LENGTH_SHORT).show();
                }
            }


        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    }
}



