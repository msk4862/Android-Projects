package com.msk.login;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText username, password;
    Button show, login;

    int count=0;


    Intent i;

    DBHelper mydb;

    public final static String USER = "user";
    public final static String PASS = "pass";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mydb = new DBHelper(this);


        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.pass);

        show = (Button) findViewById(R.id.show);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(this);
        show.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login) {
            if(username.getText().toString().length() != 0 && password.getText().toString().length() !=0) {
                //Toast.makeText(this, "Username: "+username.getText().toString() + "\nPassword: "+password.getText().toString(), Toast.LENGTH_SHORT).show();


               Cursor c =  mydb.fetchInfo(username.getText().toString(), password.getText().toString());
                if (c.getCount() != 0) {
                    i = new Intent(LoginActivity.this, UserSessionActivity.class);

                    i.putExtra(USER, username.getText().toString());
                    i.putExtra(PASS, password.getText().toString());
                    startActivity(i);

                    Toast.makeText(this, "Successfully Logged In!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "Entered user doesn't exist!!", Toast.LENGTH_SHORT).show();
                }


            }
            else {
                Toast.makeText(this, "Please Enter Your Details", Toast.LENGTH_SHORT).show();
            }
        }

        else {
            count++;
            if(count % 2 != 0) {
                password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                show.setBackgroundResource(R.drawable.show);
            }
            else {
                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                show.setBackgroundResource(R.drawable.hide);

            }
        }
    }
}
