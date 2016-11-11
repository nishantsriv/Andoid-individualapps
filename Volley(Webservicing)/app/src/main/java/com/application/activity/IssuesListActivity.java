package com.application.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.twittercrashlytics.R;
import com.application.fragment.IssuesListFragment;


public class IssuesListActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_issues_list);

        setupToolbar();

        addIssuesListFragment();


    }

    private void setupToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

      private void addIssuesListFragment() {

        IssuesListFragment IssuesListFragment = new IssuesListFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.frame_container, IssuesListFragment).commit();

    }


}
