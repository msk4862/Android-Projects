package com.msk.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText name, pass, conf_pass;

    RadioGroup gender;

    Spinner country;

    ArrayAdapter<CharSequence> adapt;

    Button signup;

    Intent i;

    boolean filled = true;
    int countryPos;

    public static String USERNAME, PASS, CONF_PASS;
    Bundle b;

    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mydb = new DBHelper(this);


        name = (EditText) findViewById(R.id.nameE);
        pass = (EditText) findViewById(R.id.passE);
        conf_pass = (EditText) findViewById(R.id.conpassE);

        signup = (Button) findViewById(R.id.login);

//        i = new Intent(this, Main2Activity.class);


        b = new Bundle();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                filled = true;

                if (name.getText().toString().equals("")) {
                    name.setError("Please Enter your Username");
                    filled = false;

                }
                else {
                    //b.putString(USERNAME, name.getText().toString());

                    USERNAME = name.getText().toString();
                }

                if (pass.getText().toString().equals("")) {
                    pass.setError("Please Enter your password");
                    filled = false;
                }
                else {
                    PASS = pass.getText().toString();
                }

                if (conf_pass.getText().toString().equals("")) {
                    conf_pass.setError("Please Enter your password");
                    filled = false;
                }
                else {
                    CONF_PASS = conf_pass.getText().toString();
                }

               if (filled) {
                   //i.putExtras(b);

                   if(PASS.equals(CONF_PASS)) {
                       mydb.insertInfo(USERNAME, PASS);

                       Toast.makeText(getApplicationContext(), "Successfully Registered!!", Toast.LENGTH_SHORT).show();

                       i = new Intent(getApplicationContext(), LaunchActivity.class);

                       startActivity(i);
                   }
                   else {
                       Toast.makeText(getApplicationContext(), "Password does not match!!", Toast.LENGTH_SHORT).show();
                        pass.setText("");
                       conf_pass.setText("");
                       name.setText("");
                   }


               }


            }
        });





    }

    protected void onPause() {
        super.onPause();
        finish();
    }
}
