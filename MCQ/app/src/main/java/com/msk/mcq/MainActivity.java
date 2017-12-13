package com.msk.mcq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CheckBox op[][] = new CheckBox[5][4];
    Button sub, reset, show;

    TextView ans;

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        op[0][0] = (CheckBox) findViewById(R.id.checkBox1);
        op[0][1] = (CheckBox) findViewById(R.id.checkBox2);
        op[0][2] = (CheckBox) findViewById(R.id.checkBox3);
        op[0][3] = (CheckBox) findViewById(R.id.checkBox4);

        op[1][0] = (CheckBox) findViewById(R.id.checkBox5);
        op[1][1] = (CheckBox) findViewById(R.id.checkBox6);
        op[1][2] = (CheckBox) findViewById(R.id.checkBox7);
        op[1][3] = (CheckBox) findViewById(R.id.checkBox8);

        op[2][0] = (CheckBox) findViewById(R.id.checkBox9);
        op[2][1] = (CheckBox) findViewById(R.id.checkBox10);
        op[2][2] = (CheckBox) findViewById(R.id.checkBox11);
        op[2][3] = (CheckBox) findViewById(R.id.checkBox12);

        op[3][0] = (CheckBox) findViewById(R.id.checkBox13);
        op[3][1] = (CheckBox) findViewById(R.id.checkBox14);
        op[3][2] = (CheckBox) findViewById(R.id.checkBox15);
        op[3][3] = (CheckBox) findViewById(R.id.checkBox16);

        op[4][0] = (CheckBox) findViewById(R.id.checkBox17);
        op[4][1] = (CheckBox) findViewById(R.id.checkBox18);
        op[4][2] = (CheckBox) findViewById(R.id.checkBox19);
        op[4][3] = (CheckBox) findViewById(R.id.checkBox20);

        sub = (Button) findViewById(R.id.submit);
        reset = (Button) findViewById(R.id.reset);
        show = (Button) findViewById(R.id.show);

        ans = (TextView) findViewById(R.id.textView8);


        sub.setOnClickListener(this);
        reset.setOnClickListener(this);
        show.setOnClickListener(this);

        reset.setVisibility(View.INVISIBLE);
        show.setVisibility(View.INVISIBLE);
        ans.setVisibility(View.INVISIBLE);

        for(int i=0; i < 5; ++i) {
            for(int j = 0; j < 4;++j) {
                op[i][j].setOnClickListener(this);
            }
        }


    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.submit) {
            score=0;


            if(op[0][0].isChecked() || op[0][1].isChecked() || op[0][2].isChecked() || op[0][3].isChecked()) {

                if (!op[0][0].isChecked() && !op[0][1].isChecked() && op[0][2].isChecked() && !op[0][3].isChecked()) {
                    score++;
                    //Toast.makeText(this, "correct1 "+score, Toast.LENGTH_SHORT).show();

                } else {
                    score--;
                }
            }


            if(op[1][0].isChecked() || op[1][1].isChecked() || (op[1][2].isChecked()) || op[1][3].isChecked()) {
                if (op[1][0].isChecked() && op[1][1].isChecked() && !(op[1][2].isChecked()) && op[1][3].isChecked()) {
                    score++;
                    //Toast.makeText(this, "correct2"+score, Toast.LENGTH_SHORT).show();

                } else {
                    score--;
                }
            }


            if (op[2][0].isChecked() || (op[2][1].isChecked()) || (op[2][2].isChecked()) || op[2][3].isChecked()) {

                if (op[2][0].isChecked() && !(op[2][1].isChecked()) && !(op[2][2].isChecked()) && op[2][3].isChecked()) {
                    score++;
                    //Toast.makeText(this, "correct3 "+score, Toast.LENGTH_SHORT).show();

                } else {
                    score--;
                }
            }


            if (op[3][0].isChecked() || op[3][1].isChecked() || op[3][2].isChecked() || op[3][3].isChecked()) {
                if (op[3][0].isChecked() && !op[3][1].isChecked() && op[3][2].isChecked() && op[3][3].isChecked()) {
                    score++;
                    //Toast.makeText(this, "correct4 "+score, Toast.LENGTH_SHORT).show();

                } else {
                    score--;
                }
            }


            if (op[4][0].isChecked() || op[4][1].isChecked() || op[4][2].isChecked() || op[4][3].isChecked()) {
                if (op[4][0].isChecked() && op[4][1].isChecked() && op[4][2].isChecked() && op[4][3].isChecked()) {
                    score++;
                    //Toast.makeText(this, "correct5 "+score, Toast.LENGTH_SHORT).show();

                } else {
                    score--;
                }
            }


            Toast.makeText(this, "Your Score: "+score, Toast.LENGTH_SHORT).show();



            for(int i=0; i < 5; ++i) {
                for(int j = 0; j < 4;++j) {
                    op[i][j].setEnabled(false);
                }
            }

            reset.setVisibility(View.VISIBLE);
            show.setVisibility(View.VISIBLE);


        }

        if (v.getId() == R.id.show) {

            ans.setVisibility(View.VISIBLE);
        }

        if (v.getId() == R.id.reset) {

            reset.setVisibility(View.INVISIBLE);
            show.setVisibility(View.INVISIBLE);
            ans.setVisibility(View.INVISIBLE);

            for(int i=0; i < 5; ++i) {
                for(int j = 0; j < 4;++j) {
                    op[i][j].setEnabled(true);
                }
            }
        }
    }
}
