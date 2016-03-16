package com.example.som.justjava;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by som on 23-02-2016.
 */
public class register extends Activity {
    TextView tv1,tv2;
    private EditText edt_scount, edt_spass;
    private Button btn_cancel, btn_ok;

    SQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tv1=(TextView)findViewById(R.id.ru);
        tv2=(TextView)findViewById(R.id.rp);

        Typeface face= Typeface.createFromAsset(getAssets(), "Adventures & Overlanders.ttf");
        tv1.setTypeface(face);
        Typeface face1= Typeface.createFromAsset(getAssets(), "Adventures & Overlanders.ttf");
        tv2.setTypeface(face1);

        helper = new DatabaseHelper(this);
        helper.getWritableDatabase();

        edt_scount = (EditText)findViewById(R.id.scount);
        edt_spass = (EditText)findViewById(R.id.spassword);
        btn_cancel = (Button)findViewById(R.id.cancel);
        btn_ok = (Button)findViewById(R.id.ok);

        btn_cancel.setOnClickListener(new cListener());
        btn_ok.setOnClickListener(new okListener());
    }

    class cListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(register.this, login.class);
            startActivity(intent);
            finish();
        }
    }

    class okListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            try {
                SQLiteDatabase sdb = helper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("count",edt_scount.getText().toString());
                values.put("password",edt_spass.getText().toString());
                sdb.insert("data", null, values);
                if (edt_scount.getText().toString().equals("") || edt_spass.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please fill the details", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(register.this, login.class);
                startActivity(intent);
                    finish();
                }

            }
            catch (SQLiteException e)
            {
                Toast.makeText(getApplicationContext(), "Not Registered！", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
