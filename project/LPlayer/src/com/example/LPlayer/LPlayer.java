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
    private Button albumsbut=null;
    private Button albumsbackbut=null;
    private Button artistsbut=null;
    private Button artistsbackbut=null;

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
        albumsbut = (Button)findViewById(R.id.albumsbut);
        albumsbackbut = (Button)findViewById(R.id.albumsbackbut);
        artistsbut = (Button)findViewById(R.id.artistsbut);
        artistsbackbut=(Button)findViewById(R.id.artistsbackbut);

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
    public void albumsbut_Clicked(View v){setContentView(R.layout.albums);}
    public void artistsbackbut_Clicked(View v){setContentView(R.layout.main);}
    public void artistsbut_Clicked(View v){setContentView(R.layout.artists);}

    }
