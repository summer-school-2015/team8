package com.example.Player;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MyActivity extends Activity {
    List<Song> playList;
    TextView txt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        txt=(TextView)findViewById(R.id.text);
        txt.setText( + "  " + R.raw.s2 + "  " +  R.raw.s3);
        playList.add()
    }
}
