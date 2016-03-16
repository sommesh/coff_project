package com.example.som.justjava;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by som on 22-02-2016.
 */
public class lait  extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lait);
        TextView tv1,tv2,tv3;
    tv1=(TextView)findViewById(R.id.laid);
    tv2=(TextView)findViewById(R.id.laii);
    tv3=(TextView)findViewById(R.id.laip);

    Typeface face=Typeface.createFromAsset(getAssets(),"flashrogerschrome.ttf");
    tv1.setTypeface(face);
    Typeface face1=Typeface.createFromAsset(getAssets(),"flashrogerschrome.ttf");
    tv2.setTypeface(face1);
    Typeface face2=Typeface.createFromAsset(getAssets(),"flashrogerschrome.ttf");
    tv3.setTypeface(face2);
}
}

