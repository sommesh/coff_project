package com.example.som.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener{

    Button bregister;
    EditText etusername,etpassword,etname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bregister= (Button) findViewById(R.id.bregister);
        etusername= (EditText) findViewById(R.id.etusername);
        etpassword= (EditText) findViewById(R.id.etpassword);
        etname= (EditText) findViewById(R.id.etname);

        bregister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.bregister):
                break;
        }
    }
}
