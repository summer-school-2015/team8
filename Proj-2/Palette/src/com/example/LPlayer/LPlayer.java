package com.example.LPlayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;

public class LPlayer extends Activity {
    private Button settingsbut=null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        settingsbut = (Button)findViewById(R.id.settingsbutton);

    }
    public void settingsbutton_Clicked(View v)
    {
        setContentView(R.layout.settings);
    }

    }
