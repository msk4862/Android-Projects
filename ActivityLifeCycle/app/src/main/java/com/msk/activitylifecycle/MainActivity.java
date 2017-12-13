package com.msk.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("onCreate");

    }

    protected void onStart() {
        super.onStart();

        System.out.println("onStart");
    }

    protected void onResume() {
        super.onResume();

        System.out.println("onResume");

    }

    protected void onPause() {
        super.onPause();

        System.out.println("onPause");

    }

    protected void onStop() {
        super.onStop();

        System.out.println("onStop");

    }

    protected void onDestroy() {
        super.onDestroy();

        System.out.println("onDestroy");

    }

    protected void onRestart() {
        super.onRestart();

        System.out.println("onRestart");

    }
}
