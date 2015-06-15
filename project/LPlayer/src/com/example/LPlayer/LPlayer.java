package com.example.LPlayer;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class LPlayer extends Activity {
    private Button settingsbut=null;
    private  Button infobut=null;
    private Button setbackbut=null;
    private Button infobackbut=null;
    private Button songsbutton=null;
    private Button playmodebackbut=null;
    //private Button playmodebut=null;
    private Button albumsbutton=null;
    private Button albumsbackbut=null;
    private Button artistsbutton=null;
    private Button artistsbackbut=null;
    private Button genrebutton=null;
    private Button genrebackbut=null;
    private Button yearbutton=null;
    private Button yearbackbut=null;
    private int id;

    MediaPlayer mediaPlayer = new  MediaPlayer();
    ListView lv=null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        id=R.layout.main;
        settingsbut = (Button)findViewById(R.id.settingsbutton);
        infobut = (Button)findViewById(R.id.infobut);
        setbackbut = (Button)findViewById(R.id.setbackbut);
        infobackbut =(Button)findViewById(R.id.infobackbut);
        songsbutton = (Button)findViewById(R.id.songsbutton);
        playmodebackbut = (Button)findViewById(R.id.playmodebackbut);
        //playmodebut = (Button)findViewById(R.id.playmodebut);
        albumsbutton = (Button)findViewById(R.id.albumsbutton);
        albumsbackbut = (Button)findViewById(R.id.albumsbackbut);
        artistsbutton = (Button)findViewById(R.id.artistsbutton);
        artistsbackbut =(Button)findViewById(R.id.artistsbackbut);


    }

    public void songsbutton_Clicked(View v){
        setContentView(R.layout.songs);
        Intent intent = new Intent(LPlayer.this, Songs.class);
        startActivity(intent);
    }

    public void artistsbut_Clicked(View v){
        setContentView(R.layout.artists);
        Intent intent = new Intent(LPlayer.this, Artists.class);
        startActivity(intent);
    }

    public void albumsbutton_Clicked(View v){
        setContentView(R.layout.albums);
        Intent intent = new Intent(LPlayer.this, Albums.class);
        startActivity(intent);
    }

    public void settingsbutton_Clicked(View v) {
        setContentView(R.layout.settings);
        id=R.layout.settings;
    }

    //public void playmodebut_Clicked(View v){setContentView(R.layout.playmode);}

    public void infobut_Clicked(View v) {
        setContentView(R.layout.info);
        id=R.layout.info;
    }

    public void backtomainbut_Clicked(View v){
        setContentView(R.layout.main);
        id=R.layout.main;
    }

    public void backtosettingsbut_Clicked(View v){
        setContentView(R.layout.settings);
        id=R.layout.settings;
    }

    @Override
    public void onBackPressed() {
        if(id==R.layout.info){
            setContentView(R.layout.settings);
            id=R.layout.settings;
        }
        else
        if (id==R.layout.settings) {
            setContentView(R.layout.main);
            id=R.layout.main;
        }

    }



}



