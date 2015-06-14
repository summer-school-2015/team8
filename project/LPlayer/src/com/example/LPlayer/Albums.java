package com.example.LPlayer;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.*;

import java.io.IOException;

/**
 * Created by User on 6/15/2015.
 */
public class Albums extends Activity implements SeekBar.OnSeekBarChangeListener {


    MediaPlayer mediaPlayer = new  MediaPlayer();
    private ListView lv=null;
    private ListView isplv=null;
    private Button songsbackbut=null;
    private ImageButton prev=null;
    private ImageButton next=null;
    private ImageButton pbut=null;
    private SeekBar seekbar;
    private Handler myHandler = new Handler();
    private TextView timer=null;
    private TextView namefield=null;
    private Button backplayerbut=null;
    Bundle savedstate=null;


    String[][] titles;
    String[][] trecs;
    String[][] trecs2;

    int k;
    int max;
    boolean isPause=false, isClicked = false;
    int dur;
    int p=0;
    int e=0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artists);
        savedstate = savedInstanceState;

        songsbackbut = (Button) findViewById(R.id.songsbackbut);

        prev = (ImageButton) findViewById(R.id.prev);
        pbut = (ImageButton) findViewById(R.id.PPbut);
        next = (ImageButton) findViewById(R.id.next);
        backplayerbut = (Button) findViewById(R.id.backplayerbut);

        lv = (ListView) findViewById(R.id.arlbumslistview);
        isplv = (ListView) findViewById(R.id.isplv);
        String[] projection = {MediaStore.Audio.Media._ID,             // 0

                MediaStore.Audio.Media.ARTIST,          // 1

                MediaStore.Audio.Media.TITLE,           // 2

                MediaStore.Audio.Media.ALBUM_ID,  // 3

                MediaStore.Audio.Media.ALBUM,           // 4

                MediaStore.Audio.Media.DATA,            // 5

                MediaStore.Audio.Media.DISPLAY_NAME,    // 6

                MediaStore.Audio.Media.DURATION,

                MediaStore.Audio.Media.TITLE_KEY

        };      // 7


        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0 ";

        Cursor musicListSDCardCursor = myquery(

                this,

                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,

                projection, selection, null, null, 0);

        Cursor musicListInternalMemoryCursor = myquery(

                this,

                MediaStore.Audio.Media.INTERNAL_CONTENT_URI,

                projection, selection, null, null, 0);
        //   musicListSDCardCursor.moveToFirst();
     /*   int i=0;
        while(musicListSDCardCursor.isAfterLast() == false) {
            musicListSDCardCursor.moveToNext();
            i++;
        }*/
        titles = new String[4][musicListSDCardCursor.getCount()];
        max = musicListSDCardCursor.getCount();
        int i = 0;
        musicListSDCardCursor.moveToFirst();
        while (musicListSDCardCursor.isAfterLast() == false) {
            titles[3][i] = musicListSDCardCursor.getString(5);
            titles[2][i] = musicListSDCardCursor.getString(4);
            titles[1][i] = musicListSDCardCursor.getString(1);
            titles[0][i] = musicListSDCardCursor.getString(2);
            musicListSDCardCursor.moveToNext();
            i++;
        }
        boolean flag=true;
        trecs = new String[4][max];
        String[] alb=new String[max];
        String[] alb2;
        for (int d=0; d < max; d++) {
            flag=true;
            for (int m=0;m<p;m++){
                if (titles[2][d].equals(alb[m])) {
                    flag=false;
                }
            }
            if(flag){
                alb[p]=titles[2][d];
                p++;
            }
        }
        alb2=new String[p];
        for(i=0;i<p;i++){
            alb2[i]=alb[i];
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, alb2);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                setContentView(R.layout.ispol);
                for(int a=0;a<max;a++)
                {
                    if(alb2[position].equals(titles[2][a])){
                        for(int r=0;r<4;r++){
                            trecs[r][e]=titles[r][a];
                        }
                        e++;
                    }

                }
                trecs2=new String[4][e];
                for(int i=0;i<e;i++){
                    for(int r=0;r<4;r++)
                    {
                        trecs2[r][i]=trecs[r][i];
                    }
                }
                selectsongs();
            }
        });


    }
    void selectsongs()
    {
        isplv = (ListView) findViewById(R.id.isplv);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, trecs2[0]);
        isplv.setAdapter(adapter1);
        isplv.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                setContentView(R.layout.player);
                k=position;
                player(k);
            }
        });
    }


    public void player(int n){
        try {
            mediaPlayer.reset();

            mediaPlayer.setDataSource(trecs2[3][n]);

            mediaPlayer.prepare();


            mediaPlayer.start();
            if(isPause) {
                mediaPlayer.pause();
            }
            dur=mediaPlayer.getDuration();
            seekbar = (SeekBar)findViewById(R.id.songbar);
            seekbar.setMax((int)mediaPlayer.getDuration());
            seekbar.setProgress((int)mediaPlayer.getCurrentPosition());
            seekbar.setOnSeekBarChangeListener(this);
            myHandler.postDelayed(UpdateSongTime,100);




        } catch (IllegalArgumentException iae) {


            iae.printStackTrace();



        } catch (IllegalStateException ise) {

            ise.printStackTrace();



        } catch (IOException ioe) {

            ioe.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }
    }


    public static Cursor myquery(Context context, Uri uri, String[] projection,

                                 String selection, String[] selectionArgs, String sortOrder, int limit) {

        try {

            ContentResolver resolver = context.getContentResolver();

            if (resolver == null) {

                return null;

            }

            if (limit > 0) {

                uri = uri.buildUpon().appendQueryParameter("limit", "" + limit).build();

            }

            return resolver.query(uri, projection, selection, selectionArgs, sortOrder);

        } catch (UnsupportedOperationException ex) {

            return null;

        }
    }

    public void ispolbackbut_Clicked(View v) throws InterruptedException {
        setContentView(R.layout.artists);
        onCreate(savedstate);
    }
    public void backplayerbut_Clicked(View v) throws InterruptedException {
        myHandler.removeCallbacks(UpdateSongTime);
        setContentView(R.layout.artists);
        onCreate(savedstate);
    }

    public void  backtomainbut_Clicked(View v){
        setContentView(R.layout.main);
        Intent intent = new Intent(Albums.this, LPlayer.class);
        startActivity(intent);
    }

    public void PPbut_Clicked(View v){
        pbut=(ImageButton)findViewById(R.id.PPbut);
        if(!isPause){
            mediaPlayer.pause();
            pbut.setImageResource(R.drawable.play);
            isPause=true;
        }
        else
        {
            mediaPlayer.start();
            pbut.setImageResource(R.drawable.pause);
            isPause=false;
        }

    }

    public void next_Clicked(View v){
        mediaPlayer.reset();
        k++;
        if (k>=max)
            k=0;
        player(k);
    }
    public void prev_Clicked(View v){
        mediaPlayer.reset();
        k--;
        if (k<0)
            k=max;
        player(k);
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            timer=(TextView)findViewById(R.id.timer);
            namefield=(TextView)findViewById(R.id.namefield);
            seekbar.setProgress((int)mediaPlayer.getCurrentPosition());
            myHandler.postDelayed(this, 100);
            int b=(int)(((float)mediaPlayer.getDuration()- (float)mediaPlayer.getCurrentPosition())/60000);
            timer.setText("" + b + ":" + ((int) ((((float) mediaPlayer.getDuration() - (float) mediaPlayer.getCurrentPosition()) / 1000) % 60)));
            namefield.setText(titles[1][k] +" - " +titles[0][k] +"\n" +titles[2][k]);
            if(seekbar.getProgress()>=dur)
            {
                mediaPlayer.reset();
                k++;
                if (k>=max)
                    k=0;
                player(k);
            }
        }
    };

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mediaPlayer.seekTo(seekBar.getProgress());


    }

}
