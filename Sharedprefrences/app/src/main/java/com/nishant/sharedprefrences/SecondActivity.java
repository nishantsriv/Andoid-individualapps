package com.nishant.sharedprefrences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button5;
    private TextView edittext2;
    private SharedPreferences prefs1;
    private  String displayname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(this);
        edittext2= (TextView) findViewById(R.id.edittext2);

        readdatafromintent();

        prefs1=getSharedPreferences("LoginPref", Context.MODE_PRIVATE);

        edittext2.setText(displayname);
    }

    private void readdatafromintent() {
        Intent intent=getIntent();
        displayname=intent.getStringExtra("t");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button5) {

            SharedPreferences.Editor editor = prefs1.edit();
            editor.clear();
            editor.commit();
            finish();
        }
    }
}
