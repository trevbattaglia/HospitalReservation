package com.trevbattaglia.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private EditText pass;
    private String password;
    private String db_password = "test";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Monte's Restaurant");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void loginAction(View v)
    {
        String username = ((EditText)findViewById(R.id.enterEmail)).getText().toString();
        String pass = ((EditText)findViewById(R.id.enterPassword)).getText().toString();
        String test = "test";

        if(username.equals(test) && pass.equals(test))
        {
            // Comment the following two for a while.
            Intent k = new Intent(MainActivity.this,
                    Reserve.class);
            startActivity(k);
        }
        else
        {
            Toast.makeText(getApplicationContext(),
                    "Wrong Username or Password", Toast.LENGTH_LONG).show();
        }
    }

    public void signUpAction(View v)
    {
        try{

            Intent k = new Intent(MainActivity.this, SignUp.class);
            k.putExtra("email","username"); //password to next acitivity
            startActivity(k);
        }catch(Exception e){
        }
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
