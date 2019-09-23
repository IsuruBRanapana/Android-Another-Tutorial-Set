package com.android.anothertutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLoading=(TextView) findViewById(R.id.tvLoading);
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
}
