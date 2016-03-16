package com.example.som.justjava;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=(TextView)findViewById(R.id.text1);
        tv2=(TextView)findViewById(R.id.text2);
        tv3=(TextView)findViewById(R.id.text3);
        tv4=(TextView)findViewById(R.id.text4);
        tv5=(TextView)findViewById(R.id.text5);
        tv6=(TextView)findViewById(R.id.text6);
        tv7=(TextView)findViewById(R.id.text7);
        tv8=(TextView)findViewById(R.id.text8);

        Typeface face= Typeface.createFromAsset(getAssets(), "Chocolate Bar Demo.otf");
        tv1.setTypeface(face);
        Typeface face1= Typeface.createFromAsset(getAssets(), "Chocolate Bar Demo.otf");
        tv2.setTypeface(face1);
        Typeface face2= Typeface.createFromAsset(getAssets(), "Chocolate Bar Demo.otf");
        tv3.setTypeface(face2);
        Typeface face3= Typeface.createFromAsset(getAssets(), "Chocolate Bar Demo.otf");
        tv4.setTypeface(face3);
        Typeface face4= Typeface.createFromAsset(getAssets(), "Chocolate Bar Demo.otf");
        tv5.setTypeface(face4);
        Typeface face5= Typeface.createFromAsset(getAssets(), "Chocolate Bar Demo.otf");
        tv6.setTypeface(face5);
        Typeface face6= Typeface.createFromAsset(getAssets(), "Chocolate Bar Demo.otf");
        tv7.setTypeface(face6);
        Typeface face7= Typeface.createFromAsset(getAssets(), "waltographUI.ttf");
        tv8.setTypeface(face7);


    }
    public void cap(View view) {
        Intent intent = new Intent(this, cappuccino.class);
        startActivity(intent);
    }
    public void esp(View view) {
        Intent intent = new Intent(this, espreso.class);
        startActivity(intent);
    }
    public void a(View view) {
        Intent intent = new Intent(this,Americano.class);
        startActivity(intent);
    }
    public void caf(View view) {
        Intent intent = new Intent(this, caffelat.class);
        startActivity(intent);
    }
    public void cafe(View view) {
        Intent intent = new Intent(this, lait.class);
        startActivity(intent);
    }
    public void moc(View view) {
        Intent intent = new Intent(this, mocaha.class);
        startActivity(intent);
    }
    public void car(View view) {
        Intent intent = new Intent(this, macho.class);
        startActivity(intent);
    }
    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;

    @Override
    public void onBackPressed()
    {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            super.onBackPressed();
            return;
        }
        else { Toast.makeText(getBaseContext(), "Please click BACK again to exit", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();
    }
}






