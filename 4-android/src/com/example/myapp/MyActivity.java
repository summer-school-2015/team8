package com.example.myapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity implements View.OnClickListener {
    private int n = 0;
    Button[][] button = new Button[4][4];
    TextView textView1 = null;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button[0][0] = (Button) findViewById(R.id.button00);
        button[0][0].setOnClickListener(this);
        button[0][1] = (Button) findViewById(R.id.button01);
        button[0][1].setOnClickListener(this);
        button[0][2] = (Button) findViewById(R.id.button02);
        button[0][2].setOnClickListener(this);
        button[0][3] = (Button) findViewById(R.id.button03);
        button[0][3].setOnClickListener(this);

        button[1][0] = (Button) findViewById(R.id.button10);
        button[1][0].setOnClickListener(this);
        button[1][1] = (Button) findViewById(R.id.button11);
        button[1][1].setOnClickListener(this);
        button[1][2] = (Button) findViewById(R.id.button12);
        button[1][2].setOnClickListener(this);
        button[1][3] = (Button) findViewById(R.id.button13);
        button[1][3].setOnClickListener(this);

        button[2][0] = (Button) findViewById(R.id.button20);
        button[2][0].setOnClickListener(this);
        button[2][1] = (Button) findViewById(R.id.button21);
        button[2][1].setOnClickListener(this);
        button[2][2] = (Button) findViewById(R.id.button22);
        button[2][2].setOnClickListener(this);
        button[2][3] = (Button) findViewById(R.id.button23);
        button[2][3].setOnClickListener(this);

        button[3][0] = (Button) findViewById(R.id.button30);
        button[3][0].setOnClickListener(this);
        button[3][1] = (Button) findViewById(R.id.button31);
        button[3][1].setOnClickListener(this);
        button[3][2] = (Button) findViewById(R.id.button32);
        button[3][2].setOnClickListener(this);
        button[3][3] = (Button) findViewById(R.id.button33);
        button[3][3].setOnClickListener(this);
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                button[i][j].setBackgroundColor(Color.RED);

    }

    public void onClick(View v) {

        if (v instanceof Button) {
            Button but = (Button) v;
            if (but.getText().toString().equals("#")) {

                if (n % 2 == 0)
                    but.setText("X");
                else
                    but.setText("O");
                n++;
            }
            iswin();

        }
    }

    private void iswin() {
        if (n >= 5) {
            for (int i = 0; i < 4; i++) {
                if (button[i][1].getText().toString().equals(button[i][2].getText().toString()) &&
                        !button[i][1].getText().toString().equals("#")) {
                    if (button[i][1].getText().toString().equals(button[i][0].getText().toString()) ||
                            button[i][1].getText().toString().equals(button[i][3].getText().toString()))
                        for (int k = 0; k < 4; k++)
                            for (int m = 0; m < 4; m++) {
                                button[k][m].setText(button[i][1].getText().toString());
                                button[k][m].setBackgroundColor(Color.BLUE);
                            }
                }

                for (i = 0; i < 4; i++) {
                    if (button[1][i].getText().toString().equals(button[2][i].getText().toString()) &&
                            !button[1][i].getText().toString().equals("#")) {
                        if (button[1][i].getText().toString().equals(button[0][i].getText().toString()) ||
                                button[1][i].getText().toString().equals(button[3][i].getText().toString()))
                            for (int k = 0; k < 4; k++)
                                for (int m = 0; m < 4; m++) {
                                    button[k][m].setText(button[1][i].getText().toString());
                                    button[k][m].setBackgroundColor(Color.BLUE);
                                }
                    }
                }

                if (button[2][0].getText().toString().equals(button[1][1].getText().toString()) &&
                        button[2][0].getText().toString().equals(button[0][2].getText().toString()))
                    for (int k = 0; k < 4; k++)
                        for (int m = 0; m < 4; m++) {
                            button[k][m].setText(button[1][1].getText().toString());
                            button[k][m].setBackgroundColor(Color.BLUE);
                        }

                if (button[3][1].getText().toString().equals(button[2][2].getText().toString()) &&
                        button[2][2].getText().toString().equals(button[1][3].getText().toString()))
                    for (int k = 0; k < 4; k++)
                        for (int m = 0; m < 4; m++) {
                            button[k][m].setText(button[2][2].getText().toString());
                            button[k][m].setBackgroundColor(Color.BLUE);
                        }

                if (button[2][1].getText().toString().equals(button[1][2].getText().toString()))
                    if (button[2][1].getText().toString().equals(button[3][0].getText().toString()) ||
                            button[2][1].getText().toString().equals(button[0][3].getText().toString()))
                        for (int k = 0; k < 4; k++)
                            for (int m = 0; m < 4; m++) {
                                if (n % 2 == 0)
                                    button[k][m].setText("O");
                                else
                                    button[k][m].setText("X");
                                button[k][m].setBackgroundColor(Color.BLUE);
                            }

                if (button[1][0].getText().toString().equals(button[2][1].getText().toString()) &&
                        button[1][0].getText().toString().equals(button[3][2].getText().toString()))
                    for (int k = 0; k < 4; k++)
                        for (int m = 0; m < 4; m++) {
                            button[k][m].setText(button[1][0].getText().toString());
                            button[k][m].setBackgroundColor(Color.BLUE);
                        }

                if (button[0][1].getText().toString().equals(button[1][2].getText().toString()) &&
                        button[0][1].getText().toString().equals(button[2][3].getText().toString()))
                    for (int k = 0; k < 4; k++)
                        for (int m = 0; m < 4; m++) {
                            button[k][m].setText(button[0][1].getText().toString());
                            button[k][m].setBackgroundColor(Color.BLUE);
                        }

                if (button[1][1].getText().toString().equals(button[2][2].getText().toString()))
                    if (button[1][1].getText().toString().equals(button[0][0].getText().toString()) ||
                            button[1][1].getText().toString().equals(button[3][3].getText().toString()))
                        for (int k = 0; k < 4; k++)
                            for (int m = 0; m < 4; m++) {
                                if (n % 2 == 0)
                                    button[k][m].setText("O");
                                else
                                    button[k][m].setText("X");
                                button[k][m].setBackgroundColor(Color.BLUE);
                            }
            }
        }
    }
}




