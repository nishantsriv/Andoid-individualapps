package com.nishant.newapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class ActivityLifeCycleDemo extends AppCompatActivity {
    private final static String LOG_TAG="Fist Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG,"Create");
        setContentView(R.layout.activity_activity_life_cycle_demo);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(LOG_TAG,"Start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"Restart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"Destroy");
    }

    public void testMethod(View view) {
        Intent thirdintent =new Intent(this,ActivityLifeCycleDemo2.class);
        startActivity(thirdintent);
    }
}



