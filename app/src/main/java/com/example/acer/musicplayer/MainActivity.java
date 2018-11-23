package com.example.acer.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button play,pause,stop;
    MediaPlayer mediaPlayer;
    int pausecurrentpotision;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=(Button)findViewById(R.id.btn_play);
        pause=(Button)findViewById(R.id.btn_pause);
        stop=(Button)findViewById(R.id.btn_stop);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {

                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.amusic);
                    mediaPlayer.start();

                }else if(!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pausecurrentpotision);
                    mediaPlayer.start();
                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer!=null) {
                    mediaPlayer.pause();
                    pausecurrentpotision=mediaPlayer.getCurrentPosition();
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer!=null) {
                    mediaPlayer.stop();
                    mediaPlayer=null;

                }
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}
