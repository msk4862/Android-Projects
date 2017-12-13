package com.msk.imail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();

        Toast.makeText(this, i.getStringExtra(Intent.EXTRA_TEXT)+"", Toast.LENGTH_SHORT).show();

        if (i != null) {
            String mes = i.getStringExtra(Intent.EXTRA_TEXT);

            t = (TextView) findViewById(R.id.text);

            t.setText(mes);
        }



    }
}
