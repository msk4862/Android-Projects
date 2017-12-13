package com.msk.menu;

import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed, email, sub, content;
    TextView t1, t2, show;
    Button b, send;
    Intent i;

    AlertDialog.Builder adb;

    AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ed = (EditText) findViewById(R.id.editText);
        email = (EditText) findViewById(R.id.email);
        sub = (EditText) findViewById(R.id.sub);
        content = (EditText) findViewById(R.id.con);

        t1 = (TextView) findViewById(R.id.textView2);
        t2 = (TextView) findViewById(R.id.textView3);
        show = (TextView) findViewById(R.id.show);


        b = (Button) findViewById(R.id.button);
        send = (Button) findViewById(R.id.send);


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        show.setVisibility(View.INVISIBLE);
        email.setVisibility(View.INVISIBLE);
        sub.setVisibility(View.INVISIBLE);
        content.setVisibility(View.INVISIBLE);
        send.setVisibility(View.INVISIBLE);
        ed.setVisibility(View.INVISIBLE);
        b.setVisibility(View.INVISIBLE);
        t1.setVisibility(View.INVISIBLE);
        t2.setVisibility(View.INVISIBLE);

        switch (item.getItemId()) {
            case R.id.call:

                ed.setText(null);
                ed.setInputType(InputType.TYPE_CLASS_NUMBER);
                ed.setHint("Enter Phone Number");
                b.setText("CALL");
                ed.setVisibility(View.VISIBLE);
                b.setVisibility(View.VISIBLE);


                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ed.getText().length() != 0) {
                            i = new Intent(Intent.ACTION_DIAL);
                            i.setData(Uri.parse("tel:"+ed.getText().toString()));
                            startActivity(i);
                        }
                        else  {
                            ed.setError("Please Enter Phone Number");
                        }
                    }
                });


                break;

            case R.id.gsearch:

                ed.setText(null);
                ed.setInputType(InputType.TYPE_CLASS_TEXT);
                ed.setHint("Search ...");
                b.setText("Google Search");
                ed.setVisibility(View.VISIBLE);
                b.setVisibility(View.VISIBLE);


                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ed.getText().length() != 0) {
                            i = new Intent(Intent.ACTION_WEB_SEARCH);
                            i.putExtra(SearchManager.QUERY, ed.getText().toString());
                            startActivity(i);
                        }
                        else  {
                            ed.setError("Please Enter your query");
                        }
                    }
                });

                break;

            case R.id.usearch:

                ed.setText(null);
                ed.setInputType(InputType.TYPE_CLASS_TEXT);
                ed.setHint("Enter URL");
                ed.append("http://");
                b.setText("GO");
                ed.setVisibility(View.VISIBLE);
                b.setVisibility(View.VISIBLE);


                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ed.getText().length() != 0) {
                            i = new Intent(Intent.ACTION_VIEW, Uri.parse(ed.getText().toString()));
                            i.putExtra(Intent.EXTRA_TEXT, ed.getText().toString());
                            startActivity(i);
                        }
                        else  {
                            ed.setError("Please Enter URL");
                        }
                    }
                });


                break;

            case R.id.email:

                email.setVisibility(View.VISIBLE);
                sub.setVisibility(View.VISIBLE);
                content.setVisibility(View.VISIBLE);
                send.setVisibility(View.VISIBLE);
                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);


                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (email.getText().length() != 0 && sub.getText().length() !=0 && content.getText().length() !=0) {
                            i = new Intent(Intent.ACTION_SEND);
                            i.setType("text/plain");
                            i.putExtra(Intent.EXTRA_EMAIL, new String[] {email.getText().toString()}); // recipients
                            i.putExtra(Intent.EXTRA_SUBJECT, sub.getText().toString());
                            i.putExtra(Intent.EXTRA_TEXT, content.getText().toString());
                            startActivity(i);
                        }
                        else  {
                            if (email.getText().length() == 0)
                                email.setError("Please Enter Receiver's Email ID");
                            if (sub.getText().length() ==0) {
                                sub.setError("Please Enter a Subject");
                            }
                            if (content.getText().length() == 0) {
                                content.setError("Please Type your message");
                            }

                        }
                    }
                });

                break;



            case R.id.exit:

                adb = new AlertDialog.Builder(this);


                adb.setCancelable(false);
                adb.setTitle("EXIT");
                adb.setMessage("Are you really want to exit?");


                adb.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                adb.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ad.dismiss();
                    }
                });

                ad = adb.create();
                ad.show();


        }



        return true;
    }
}
