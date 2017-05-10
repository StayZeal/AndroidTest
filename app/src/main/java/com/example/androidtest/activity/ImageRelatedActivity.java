package com.example.androidtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androidtest.DemoInfo;
import com.example.androidtest.R;
import com.example.androidtest.adapter.MainAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageRelatedActivity extends AppCompatActivity {


    @Bind(R.id.image_related_Rv)
    RecyclerView imageRelatedRv;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_related);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        mAdapter = new MainAdapter(this);
        imageRelatedRv.setLayoutManager(new LinearLayoutManager(this));
        imageRelatedRv.setAdapter(mAdapter);
        mAdapter.setDatas(DemoInfo.images);

    }
}
