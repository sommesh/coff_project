package com.example.som.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {
 Button blogin;
    EditText etusername,etpassword;
    TextView tvregisterlink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        blogin= (Button) findViewById(R.id.blogin);
        etusername= (EditText) findViewById(R.id.etusername);
        etpassword= (EditText) findViewById(R.id.etpassword);
        tvregisterlink= (TextView) findViewById(R.id.tvregisterlink);

        blogin.setOnClickListener(this);
        tvregisterlink.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.blogin:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.tvregisterlink:

                startActivity(new Intent(this,Register.class));

                break;
        }
    }
}
