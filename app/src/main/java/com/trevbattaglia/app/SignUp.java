package com.trevbattaglia.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SignUp extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Monte's Restaurant");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sign_up, menu);
        return true;
    }

    public void returnAction(View v)
    {
        try{
            String email = ((EditText)findViewById(R.id.enterEmail1)).getText().toString();

            String test = "test";

            int flag=0;
            String validdomain="com";
            String validdomain1="gov";
            String validdomain2="edu";
            for(int i=0; i<email.length(); i++)
            {
                //checks each char to see if it is an int
                char x = email.charAt(i);

                if(Character.isDigit(x)==true)
                {
                    System.out.println("Email is invalid.");
                    flag=1;
                    break;
                }
                if(x=='.')
                {

                    //check to see if chars after '.' are longer than 3

                        if(email.substring(i+1, i+4).equals(validdomain) || email.substring(i+1, i+4).equals(validdomain1) || email.substring(i+1, i+4).equals(validdomain2))
                        {
                            Intent k = new Intent(SignUp.this,
                                Reserve.class);
                            Toast.makeText(getApplicationContext(),
                                    "Email is valid", Toast.LENGTH_LONG).show();
                            startActivity(k);

                        }

                    //check if next three are .com .gov .edu
                    else
                    {
                        Toast.makeText(getApplicationContext(),
                            "Email is Invalid", Toast.LENGTH_LONG).show();

                    }
                }

            }
            Toast.makeText(getApplicationContext(),
                    "Email is invalid", Toast.LENGTH_LONG).show();


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
