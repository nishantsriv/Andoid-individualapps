package com.nishant.parclable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private EditText editText;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
    }

    public void secondactivity() {
        KidsInfo k = new KidsInfo();
        k.name = editText.getText().toString();
        k.standard = editText2.getText().toString();
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, SecondActivity.class);
        bundle.putParcelable("key", k);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            secondactivity();
        }

    }
}
