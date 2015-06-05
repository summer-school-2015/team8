package com.example.myapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

public class MyActivity extends Activity{

    private int mix =0;
    private int x1 =0;
    private int x2 =0;
    private int x3 =0;
    private Button button1 = (Button)findViewById(R.id.button1);
    private Button button2 = (Button)findViewById(R.id.button2);
    private Button button3 = (Button)findViewById(R.id.button3);


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        int i=0;
        int b=0;
        while(i<Math.sqrt(mix)) {
            if(mix%i==0) {
                button1.setBackgroundColor(Color.GREEN);
                button2.setBackgroundColor(Color.GREEN);
                button3.setBackgroundColor(Color.GREEN);
                b++;
                break;
            }
            i++;
            if(b==0)
            {
                button1.setBackgroundColor(Color.BLUE);
                button2.setBackgroundColor(Color.BLUE);
                button3.setBackgroundColor(Color.BLUE);
        }

        }


    }

    public void button1_Clicked(View v)
    {
        mix+=1;
        x1++;
        button1.setText(""+x1);
    }
    public void button2_Clicked(View v)
    {
        x2++;
        mix+=1;
        button2.setText(""+x2);
    }
    public void button3_Clicked(View v)
    {
        x3++;
        mix+=1;
        button3.setText(""+x3);
    }
}