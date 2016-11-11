package com.nishant.fraggi.Myfraggi.sCROLLING;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.nishant.fraggi.R;

public class ListViewDemoActivity extends AppCompatActivity {
   private ListView listviewstudents;
    private ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    init();
    }

   private  void init(){
   listviewstudents = (ListView) findViewById(R.id.listview_students);
       listViewAdapter=new ListViewAdapter(this);
       listviewstudents.setAdapter(listViewAdapter);
       listViewAdapter.setdata(DataHelper.getstudentsdata());
   }
}

