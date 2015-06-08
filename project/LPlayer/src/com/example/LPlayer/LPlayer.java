package com.example.LPlayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;

public class LPlayer extends Activity {
    private Button settingsbut=null;
    private  Button infobut=null;
    private Button setbackbut=null;
    private Button infobackbut=null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        settingsbut = (Button)findViewById(R.id.settingsbutton);
        infobut = (Button)findViewById(R.id.infobut);
        setbackbut = (Button)findViewById(R.id.setbackbut);
        infobackbut =(Button)findViewById(R.id.infobackbut);

    }
    public void settingsbutton_Clicked(View v)
    {
        setContentView(R.layout.settings);
    }
    public void infobut_Clicked(View v)
    {
        setContentView(R.layout.info);
    }
    public void setbackbut_Clicked(View v)
    {
        setContentView(R.layout.main);
    }
    public void infobackbut_Clicked(View v)
    {
        setContentView(R.layout.settings);
    }

    }
