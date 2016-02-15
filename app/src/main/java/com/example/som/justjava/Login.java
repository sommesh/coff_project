package com.example.som.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void onButtonClick(View v) {
        if (v.getId() == R.id.blogin) {
            EditText a = (EditText) findViewById(R.id.etusername);
            String str = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.etpassword);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if (pass.equals(password)) {
                Intent i = new Intent(Login.this,MainActivity.class);
                startActivity(i);
            } else {
                Toast temp = Toast.makeText(Login.this, "Username and password dont match!", Toast.LENGTH_LONG);
                temp.show();
            }
        }
        if (v.getId() == R.id.tvregisterlink) {
            Intent i = new Intent(Login.this, Register.class);
            startActivity(i);
        }
    }
}

