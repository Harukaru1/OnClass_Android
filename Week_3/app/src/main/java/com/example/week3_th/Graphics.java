package com.example.week3_th;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Graphics extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphicsView(this));
    }
}
