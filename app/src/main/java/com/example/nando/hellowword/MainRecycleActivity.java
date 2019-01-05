package com.example.nando.hellowword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainRecycleActivity extends AppCompatActivity {


    GreenAdapter mAdapter;
    RecyclerView mNumberList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recycle);

        // configura a RecyclerView

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        mNumberList = (RecyclerView) findViewById(R.id.rv_numbers);
        mNumberList.setLayoutManager(layoutManager);
        mNumberList.setHasFixedSize(true);

        mAdapter = new GreenAdapter(100);

        mNumberList.setAdapter(mAdapter);





    }
}
