package com.msk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.msk.loginpage.MainActivity;
import com.msk.loginpage.R;


public class Main2Activity extends AppCompatActivity {

    TextView name, email, mob,country, gender;
    Intent i1;

    MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        i1 = getIntent();

        name = (TextView) findViewById(R.id.nameO);
        email = (TextView) findViewById(R.id.emailO);
        mob = (TextView) findViewById(R.id.mobO);
        country = (TextView) findViewById(R.id.countryO);
        gender = (TextView) findViewById(R.id.genderO);


        Bundle b1 = i1.getExtras();

        name.setText("NAME: " + b1.getString(MainActivity.NAME));
        email.setText("E-MAIL: "+b1.getString(MainActivity.EMAIL));
        mob.setText("MOBILE NO. :"+b1.getString(MainActivity.MOB));
        gender.setText("GENDER: "+b1.getString(MainActivity.GENDER));
        country.setText("COUNTRY: "+b1.getString(MainActivity.COUNTRY));



    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
