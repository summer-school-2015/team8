package com.example.LPlayer;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Songs extends Activity{


    MediaPlayer mediaPlayer = new  MediaPlayer();
    ListView lv=null;
    Button songsbackbut=null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs);

        songsbackbut=(Button)findViewById(R.id.songsbackbut);

        lv = (ListView)findViewById(R.id.SongslistView);
        String[][] titles;
        String[] projection = { MediaStore.Audio.Media._ID,             // 0

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

                projection, selection , null, null,0);

        Cursor musicListInternalMemoryCursor = myquery(

                this,

                MediaStore.Audio.Media.INTERNAL_CONTENT_URI,

                projection, selection , null, null,0);
        //   musicListSDCardCursor.moveToFirst();
     /*   int i=0;
        while(musicListSDCardCursor.isAfterLast() == false) {
            musicListSDCardCursor.moveToNext();
            i++;
        }*/
        titles = new String[4][ musicListSDCardCursor.getCount()];
        int i=0;
        String h="";
        musicListSDCardCursor.moveToFirst();
        while(musicListSDCardCursor.isAfterLast() == false){
            titles[3][i]=musicListSDCardCursor.getString(5);
            titles[2][i]=musicListSDCardCursor.getString(4);
            titles[1][i]=musicListSDCardCursor.getString(1);
            titles[0][i]=musicListSDCardCursor.getString(2);
            musicListSDCardCursor.moveToNext();
            i++;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, titles[0]);
        lv.setAdapter(adapter);

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
    public void songsbackbut_Clicked(View v){
        setContentView(R.layout.main);
        Intent intent = new Intent(Songs.this, LPlayer.class);
        startActivity(intent);
    }

}