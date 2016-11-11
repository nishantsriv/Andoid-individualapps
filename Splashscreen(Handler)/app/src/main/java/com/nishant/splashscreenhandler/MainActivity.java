package com.nishant.splashscreenhandler;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startsecond();
                finish();
            }
        }, 2000);
    }

    private void startsecond() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
