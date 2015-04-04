package com.prototype.hellostranger.hellostrangerprototype01;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    int imgCount;
    int[] hearts = {R.drawable.main_off_heart, R.drawable.main_normal_heart, R.drawable.main_finding_heart, R.drawable.main_broken_heart};
    int[] texts = {R.drawable.main_off_text, R.drawable.main_normal_text, R.drawable.main_finding_text, R.drawable.main_broken_text};
    ImageView heartImgView;
    ImageView textImgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgCount = 1;


        heartImgView = (ImageView)findViewById(R.id.haert_img_view);
        textImgView = (ImageView)findViewById(R.id.text_img_view);
    }

    public void changeHeart(View v) {
        imgCount = (++imgCount) % 4;
        //int id = v.getId();

        heartImgView.setImageResource(hearts[imgCount]);
        textImgView.setImageResource(texts[imgCount]);

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
