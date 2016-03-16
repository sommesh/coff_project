package com.example.som.justjava;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by som on 24-02-2016.
 */

public class login extends AppCompatActivity {
    TextView tv1,tv2;
    SQLiteOpenHelper helper;

    private EditText edt_count, edt_pass;
    private Button btn_signup, btn_signin;

    private String mycount, mypass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv1=(TextView)findViewById(R.id.tu);
        tv2=(TextView)findViewById(R.id.tp);

        Typeface face= Typeface.createFromAsset(getAssets(), "Adventures & Overlanders.ttf");
        tv1.setTypeface(face);
        Typeface face1= Typeface.createFromAsset(getAssets(), "Adventures & Overlanders.ttf");
        tv2.setTypeface(face1);

        helper = new DatabaseHelper(this);
        helper.getWritableDatabase();

        edt_count = (EditText)findViewById(R.id.count);
        edt_pass = (EditText)findViewById(R.id.password);
        btn_signup = (Button)findViewById(R.id.Signin);
        btn_signin = (Button)findViewById(R.id.Login);

        btn_signup.setOnClickListener(new upListener());
        btn_signin.setOnClickListener(new inListener());
    }

    class upListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(login.this, register.class);
            startActivity(intent);
            finish();
        }
    }

    class inListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            mycount = edt_count.getText().toString();
            mypass = edt_pass.getText().toString();

            if(mycount.equals("") || mypass.equals("")){
                Toast.makeText(getApplicationContext(), "Enter the username and password！", Toast.LENGTH_SHORT).show();
            }else {
                find(mycount, mypass);
            }
        }
    }

    private void find(String count, String pass){
        SQLiteDatabase sdb = helper.getReadableDatabase();
        try {
            String sql = "select count,password from data where count=? and password=?";
            Cursor cursor = sdb.rawQuery(sql, new String[]{count, pass});
            if (cursor.getCount() > 0){
                Intent intent = new Intent(login.this, MainActivity.class);
                Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(getApplicationContext(), "Wrong username and password", Toast.LENGTH_SHORT).show();
            }
            cursor.close();
            sdb.close();
        }catch (SQLiteException e){
            Toast.makeText(getApplicationContext(), "exceptional error", Toast.LENGTH_SHORT).show();
        }
    }
}

