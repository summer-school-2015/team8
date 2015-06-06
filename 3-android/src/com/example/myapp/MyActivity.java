package com.example.myapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

public class MyActivity extends Activity implements View.OnClickListener {

    private int n=0;
    Button button1=null;
    Button button2=null;
    Button button3=null;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }

    public void onClick(View v) {

        if( v instanceof Button) {
            Button button = (Button) v;

            int clicks = Integer.parseInt(button.getText().toString());
            clicks++;
            n++;

            button.setText(String.valueOf(clicks));

            int i;
            int b = 0;
            if (n == 1)
                b=1;
            for (i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        b=1;
                        break;
                    }
                }
            int col=Color.GREEN;

            if (b == 0)
                col=Color.BLUE;
            button1.setBackgroundColor(col);
            button2.setBackgroundColor(col);
            button3.setBackgroundColor(col);
            }
    }
}