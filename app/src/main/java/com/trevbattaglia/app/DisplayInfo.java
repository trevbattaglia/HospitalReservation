package com.trevbattaglia.app;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class DisplayInfo extends ActionBarActivity {
    private String booth;
    private String time;
    private String drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayinfo);
        setTitle("Monte's Restaurant");
        Bundle extras = getIntent().getExtras();

        if(extras != null)
        {
            booth = extras.getString("booth");
            time= extras.getString("times");
            drink= extras.getString("drinks");
        }
        TextView timeInfo = (TextView)findViewById(R.id.timeInfo);
        timeInfo.setText("Table or Booth: " + booth);
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setText("Time: " + time);
        TextView drink_view = (TextView)findViewById(R.id.drink_info);
        drink_view.setText("Food or Drink: " + drink);

    }
    public void confirmation(View v)
    {
        try
        {

            Intent k = new Intent(DisplayInfo.this, Receipt.class);
            Bundle extraInfo = new Bundle();
            extraInfo.putString("times", time);
            extraInfo.putString("booth", booth);
            extraInfo.putString("drinks", drink);
            k.putExtras(extraInfo);

            startActivity(k);

        }catch(Exception e){

        }
    }

    public void backAction(View v)
    {
        try
        {
            Intent k = new Intent(DisplayInfo.this, Reserve.class);
            startActivity(k);
        }catch(Exception e){

        }
    }

    public void onClick(View v)
    {
        try
        {
            TextView textView1 = (TextView)findViewById(R.id.textView1);
            TextView timeInfo = (TextView)findViewById(R.id.timeInfo);
            TextView drink_view = (TextView)findViewById(R.id.drink_info);
            timeInfo.setText("Deleted");
            textView1.setText("Deleted");
            drink_view.setText("Deleted");

        }catch(Exception e){

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.displayinfo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
