package com.nishant.sharedprefrences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button4;
    private EditText edittext;
    private boolean isLoggedin;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        edittext = (EditText) findViewById(R.id.edittext);

        prefs = getSharedPreferences("LoginPref", Context.MODE_PRIVATE);

        isLoggedin = prefs.getBoolean("LOGIN", false);
        if (isLoggedin) {
            String value = prefs.getString("display text", null);
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("t", value);
            startActivity(intent);
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button4) {

            SharedPreferences.Editor editor = prefs.edit();

            editor.putBoolean("LOGIN", true);
            editor.commit();


            editor.putString("display text", edittext.getText().toString());
            editor.commit();

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("t", edittext.getText().toString());
            startActivity(intent);
        }

    }
}
