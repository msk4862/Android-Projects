package com.msk.cv;

import android.graphics.Typeface;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Typeface t;

    TextView text1, text2, text3, text4, text5, text6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = Typeface.createFromAsset(getAssets(), "garreg.ttf");

        text1 = (TextView) findViewById(R.id.textView);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        text4 = (TextView) findViewById(R.id.textView4);
        text5 = (TextView) findViewById(R.id.textView5);

        text1.setTypeface(t);
        text2.setTypeface(t);
        text3.setTypeface(t);
        text4.setTypeface(t);
        text5.setTypeface(t);



    }


}
