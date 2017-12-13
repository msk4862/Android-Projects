package com.msk.loginpage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.msk.Main2Activity;

public class MainActivity extends AppCompatActivity {

    EditText name, email, pass, mob;

    RadioGroup gender;

    Spinner country;

    ArrayAdapter<CharSequence> adapt;

    Button login;

    Intent i;

    boolean filled = true;
    int countryPos;

    public final static String NAME="name", EMAIL="email", MOB="mob", COUNTRY="country", GENDER ="gender";
    Bundle b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.nameE);
        email = (EditText) findViewById(R.id.emailE);
        pass = (EditText) findViewById(R.id.passE);
        mob = (EditText) findViewById(R.id.mobE);
        login = (Button) findViewById(R.id.login);

        i = new Intent(this, Main2Activity.class);

        gender = (RadioGroup) findViewById(R.id.radioGroup);

        b = new Bundle();

        adapt = ArrayAdapter.createFromResource(this, R.array.course, android.R.layout.simple_spinner_item);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        country = (Spinner) findViewById(R.id.spinner);
        country.setAdapter(adapt);
        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                countryPos = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                filled = true;

                if (name.getText().toString().equals("")) {
                    name.setError("Please Enter your name");
                    filled = false;

                }
                else {
                    b.putString(NAME, name.getText().toString());
                }

                if (email.getText().toString().equals("")) {
                    email.setError("Please Enter your Email");
                    filled = false;


                }
                else {
                    b.putString(EMAIL, email.getText().toString());
                }

                if (pass.getText().toString().equals("")) {
                    pass.setError("Please Enter your password");
                    filled = false;


                }


                if (mob.getText().toString().equals("")) {
                    mob.setError("Please Enter your mobile no.");
                    filled = false;

                }
                else {
                    b.putString(MOB, mob.getText().toString());
                }


                if (gender.getCheckedRadioButtonId() != R.id.male && gender.getCheckedRadioButtonId() != R.id.female ) {
                    Toast.makeText(getApplicationContext(), "Please Select Your Gender" , Toast.LENGTH_SHORT).show();
                    filled=false;
                }
                else {
                    String gen;
                    if (gender.getCheckedRadioButtonId() == R.id.male) {
                        gen = "Male";
                    }
                    else {
                        gen = "Female";
                    }
                    b.putString(GENDER, gen);

                }

                if (countryPos == 0 ) {
                    Toast.makeText(getApplicationContext(), "Please Select Your Country" , Toast.LENGTH_SHORT).show();
                    filled=false;
                }

                else {
                    b.putString(COUNTRY, country.getSelectedItem().toString());
                }

               if (filled) {
                   i.putExtras(b);
                   startActivity(i);
               }


            }
        });





    }

    protected void onPause() {
        super.onPause();
        finish();
    }
}
