package com.nishant.fraggi.Myfraggi.sCROLLING;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.nishant.fraggi.R;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

public class Recyclerview extends AppCompatActivity {
    private RecyclerView RecyclerView;
    private RecyclerViewAdapter adapter;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         RecyclerView= (android.support.v7.widget.RecyclerView) findViewById(R.id.RecyclerView);
       init();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tabbed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.grid) {
            grid();
        }
        if (id==R.id.linear)
        {
            init();
        }
        return super.onOptionsItemSelected(item);
    }

    private void    init()
    {


        RecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).color(Color.BLACK).build());

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);



        RecyclerView.setLayoutManager(layoutManager);

        adapter=new RecyclerViewAdapter(this);
        RecyclerView.setAdapter(adapter);
        adapter.setData(DataHelper.getstudentsdata());
    }
    private void grid()
    {


        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);


        RecyclerView.setLayoutManager(gridLayoutManager);

        adapter=new RecyclerViewAdapter(this);
        RecyclerView.setAdapter(adapter);
        adapter.setData(DataHelper.getstudentsdata());
    }


}
