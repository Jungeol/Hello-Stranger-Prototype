package com.prototype.hellostranger.hellostrangerprototype01;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;


public class LinkedPersonActivity extends ActionBarActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linked_person);

        // 액션바 숨김
        ActionBar actionBar = getActionBar();
        actionBar.hide();

        ImageButton reject_btn = (ImageButton) findViewById(R.id.reject_btn);
        reject_btn.setOnClickListener(this);
        ImageButton get_safe_num_btn = (ImageButton) findViewById(R.id.get_safe_number_btn);
        get_safe_num_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.reject_btn:
                Intent rb_it = new Intent(this,PopupRejectActivity.class);
                startActivity(rb_it);
                break;
            case R.id.get_safe_number_btn:
                Intent gs_it = new Intent(this,GetSafeNumActivity.class);
                startActivity(gs_it);
                break;
        }
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_linked_person, menu);
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
