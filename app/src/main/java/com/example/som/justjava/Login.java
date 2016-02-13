package com.example.som.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity implements View.OnClickListener {
 Button blogin;
    EditText etusername,etpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        blogin= (Button) findViewById(R.id.blogin);
        etusername= (EditText) findViewById(R.id.etusername);
        etpassword= (EditText) findViewById(R.id.etpassword);

        blogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.blogin:
                break;
        }
    }
}
