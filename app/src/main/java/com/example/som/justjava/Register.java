package com.example.som.justjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {

    String TAG = "Register";
    DatabaseHelper helper=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onSignUp(View v)
    {

        if (v.getId() == R.id.bregister)
        {
            EditText name = (EditText) findViewById(R.id.etname);
            String namestr = name.getText().toString();

            EditText email = (EditText) findViewById(R.id.etemail);
            String emailstr = email.getText().toString();

            EditText username = (EditText) findViewById(R.id.etusername);
            String unamestr = username.getText().toString();

            EditText password = (EditText) findViewById(R.id.etpassword);
            String passwordstr = password.getText().toString();

            EditText cpassword = (EditText) findViewById(R.id.etcpassword);
            String password1str = cpassword.getText().toString();


            if (!passwordstr.equals(password1str))
                //check whether password are same !
            {
               Toast pass= Toast.makeText(Register.this, "password dont match!", Toast.LENGTH_LONG);
                pass.show();
            }

            else

            {
                //insert the detailes in database
                contact c = new contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(password1str);

                helper.insertContact(c);
                Toast pass= Toast.makeText(Register.this, "Registered successfully", Toast.LENGTH_LONG);
                pass.show();
                Log.v(TAG, "wowwwwwwwwwwwwwwwwwwwwwwie you have now registered");
            }
        }
    }
}
