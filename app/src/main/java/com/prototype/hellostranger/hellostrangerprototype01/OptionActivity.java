package com.prototype.hellostranger.hellostrangerprototype01;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

public class OptionActivity extends ActionBarActivity implements View.OnClickListener {

    static final int[] BUTTONS = {
            R.id.linked_person_btn,
            R.id.my_profile_btn,
            R.id.system_preference_btn
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        for (int btnId : BUTTONS) {
            ImageButton img_btn = (ImageButton) findViewById(btnId);
            img_btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linked_person_btn:
                Intent lp_it = new Intent(getApplicationContext(), LinkedPersonActivity.class);
                startActivity(lp_it);
                break;
            case R.id.my_profile_btn:
                Intent my_it = new Intent(this, MyPfofileActivity.class);
                startActivity(my_it);
                break;
            case R.id.system_preference_btn:
                /*Intent sp_it = new Intent(this,OptionActivity.class);
                startActivity(sp_it);*/
                break;
        }
    }


/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_option, menu);
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
