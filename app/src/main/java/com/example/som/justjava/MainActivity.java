package com.example.som.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}






