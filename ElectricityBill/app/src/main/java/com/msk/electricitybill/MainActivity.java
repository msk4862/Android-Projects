package com.msk.electricitybill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText e1, e2, e3, units;

    Button gen;

    float unit, bill = 0;

    String billDis;

    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText1);
        e3 = (EditText) findViewById(R.id.editText2);
        units = (EditText) findViewById(R.id.editText3);

        gen = (Button) findViewById(R.id.button);
        gen.setOnClickListener(this);

        total = (TextView) findViewById(R.id.textView4);
        total.setVisibility(View.INVISIBLE);


    }

    @Override
    public void onClick(View v) {

        if (e1.getText().toString().length() > 0 && e2.getText().toString().length() > 0 && e3.getText().toString().length() > 0  &&  units.getText().toString().length() >0) {
            bill = 0;
            billDis = "";

            unit = Float.parseFloat(units.getText().toString());

            if (unit > 1000) {
                bill += (unit-1000)*2;

                billDis += "(100)*0.5 + (400)*1 + (500)*1.5 + ("+bill/2 +")*2";

                bill += 100*0.5;
                bill += 400;
                bill += 500*1.5;


            }

           else if (unit > 500) {
                bill += (unit - 500)*1.5;

                billDis += "(100)*0.5 + (400)*1 + ("+bill/1.5 +")*1.5";

                bill += 100*0.5;
                bill += 400;

            }

            else if (unit > 100) {
                bill += (unit - 100);

                billDis += "(100)*0.5 + ("+bill +")*1";

                bill += 100*0.5;

            }

            else {


                bill += unit*0.5;
                billDis += "("+bill/0.5 +")*0.5";


            }


            total.setVisibility(View.VISIBLE);
            total.setText("Name: "+e1.getText().toString()+"\nCity: "+e2.getText().toString()+"\nHouse No.: "+e3.getText().toString() + "\n\nYour Bill Description:\n"+ billDis +"\n\nYour Bill amount is: " + bill+" /-");


//            Toast.makeText(this, "Name: "+e1.getText().toString()+"\nCity: "+e2.getText().toString()+"\nHouse No.: "+e3.getText().toString(), Toast.LENGTH_SHORT).show();



        }

        else {
            Toast.makeText(this, "Please Fill Your Details", Toast.LENGTH_SHORT).show();

        }


    }
}
