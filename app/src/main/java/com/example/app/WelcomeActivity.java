package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.ProgressBar;

public class WelcomeActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=(4000);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ProgressBar progressBar=findViewById(R.id.progressBar);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent=new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(homeIntent);
                finish();

            }

        },SPLASH_TIME_OUT);


        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<4;i++){
                    progressBar.setProgress(progressBar.getProgress()+1);
                // Thread.sleep(500);
                SystemClock.sleep(1000);}

            }
        });

        thread.start();

    }
}