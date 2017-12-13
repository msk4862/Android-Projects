package com.msk.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserSessionActivity extends AppCompatActivity {

    TextView user, pass;

    EditText newPass;

    Button update;

    Intent i;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_session);

        i = getIntent();

        db = new DBHelper(this);

        user = (TextView) findViewById(R.id.username);
        update = (Button) findViewById(R.id.update);

        newPass = (EditText) findViewById(R.id.newpass);

        pass = (TextView) findViewById(R.id.pass);

        user.setText("Welcome " + i.getStringExtra(LoginActivity.USER)+"!");
        pass.setText(i.getStringExtra(LoginActivity.PASS));

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.updateInfo(user.getText().toString(), newPass.getText().toString());
                Toast.makeText(UserSessionActivity.this, "Updated!!", Toast.LENGTH_SHORT).show();

                /*if (b) {
                    Toast.makeText(UserSessionActivity.this, "Updated!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(UserSessionActivity.this, "Error!!", Toast.LENGTH_SHORT).show();
                }*/
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}