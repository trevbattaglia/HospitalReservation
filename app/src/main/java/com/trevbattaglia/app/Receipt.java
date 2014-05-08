package com.trevbattaglia.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TextView;


public class Receipt extends ActionBarActivity {
    private String booth;
    private String time;
    private String drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.receipt, menu);
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
