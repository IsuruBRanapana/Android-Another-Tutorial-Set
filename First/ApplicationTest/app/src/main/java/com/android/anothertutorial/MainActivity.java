package com.android.anothertutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer sound;
    TextView tvLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLoading=(TextView) findViewById(R.id.tvLoading);
        sound=MediaPlayer.create(MainActivity.this,R.raw.music);
        sound.start();
        Thread timer=new Thread(){
          public void run(){
              try {
                  sleep(5000);
              }catch (InterruptedException e){
                  e.printStackTrace();
              }finally {
                  Intent intent=new Intent("com.android.anothertutorial.INCREMENTANDDECREMENT");
                  startActivity(intent);
              }
          }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sound.release();
        finish();
    }
}
