package com.msk.activitylifecycle2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static int count1=0, count2=0, count3=0, count4=0, count5=0, count6=0;

    TextView t1, t2, t3, t4, t5, t6, t7;



    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        if (b!=null) {
            count1=b.getInt("onC");
            count2=b.getInt("onS");
            count3=b.getInt("onR");
            count4=b.getInt("onP");
            count5=b.getInt("onSt");
            count6=b.getInt("onRe");
        }


        count1++;


        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);
        t5 = (TextView) findViewById(R.id.textView5);
        t6 = (TextView) findViewById(R.id.textView6);


        //t1.setText("onCreate: " +count1);

        Display();


    }

   protected void onSaveInstanceState(Bundle b) {
        super.onSaveInstanceState(b);

        b.putInt("onC", count1);
        b.putInt("onS", count2);
        b.putInt("onR", count3);
        b.putInt("onP", count4);
        b.putInt("onSt", count5);
        b.putInt("onRe", count6);

        //Dispaly();


    }


    protected void onStart() {
        super.onStart();
        count2++;

        Display();

    }

    protected void onResume() {
        super.onResume();

        count3++;
        Display();

    }

    protected void onPause() {
        super.onPause();

        count4++;
        Display();

    }

    protected void onStop() {
        super.onStop();

        count5++;
        Display();

    }

    protected void onRestart() {
        super.onRestart();

        count6++;
        Display();

    }

    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();

    }

    public void Display() {

        t1.setText("onCreate: " +count1);
        t2.setText("onStart: " +count2);
        t3.setText("onResume: " +count3);
        t4.setText("onPause: " +count4);
        t5.setText("onStop: " +count5);
        t6.setText("onRestart: " +count6);


    }


}
