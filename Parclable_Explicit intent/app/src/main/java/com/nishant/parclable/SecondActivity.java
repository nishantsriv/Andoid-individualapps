package com.nishant.parclable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView textView2;
    private TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        readdata();
    }

    public void readdata() {
        Bundle bundle = getIntent().getExtras();
        KidsInfo k = bundle.getParcelable("key");
        textView2.setText("Name is" + k.name);
        textView3.setText("Standard is" + k.standard);
    }
}
