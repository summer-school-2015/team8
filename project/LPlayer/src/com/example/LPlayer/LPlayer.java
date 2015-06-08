package com.example.LPlayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LPlayer extends Activity {
    private Button settingsbut=null;
    private  Button infobut=null;
    private Button setbackbut=null;
    private Button infobackbut=null;
    private Button songsbackbut=null;
    private Button songsbutton=null;
    private Button playmodebackbut=null;
    private Button playmodebut=null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        settingsbut = (Button)findViewById(R.id.settingsbutton);
        infobut = (Button)findViewById(R.id.infobut);
        setbackbut = (Button)findViewById(R.id.setbackbut);
        infobackbut =(Button)findViewById(R.id.infobackbut);
        songsbackbut=(Button)findViewById(R.id.songsbackbut);
        songsbutton = (Button)findViewById(R.id.songsbutton);
        playmodebackbut = (Button)findViewById(R.id.playmodebackbut);
        playmodebut = (Button)findViewById(R.id.playmodebut);

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
    public void songsbackbut_Clicked(View v){setContentView(R.layout.main);}
    public void songsbutton_Clicked(View v){setContentView(R.layout.songs);}
    public void playmodebackbut_Clicked(View v){setContentView(R.layout.settings);}
    public void playmodebut_Clicked(View v){setContentView(R.layout.playmode);}

    }
