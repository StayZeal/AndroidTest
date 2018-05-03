package com.example.androidtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androidtest.DemoInfo;
import com.example.androidtest.R;
import com.example.androidtest.adapter.MainAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyListActivity extends AppCompatActivity {


    @BindView(R.id.image_related_Rv)
    RecyclerView imageRelatedRv;
    private MainAdapter mAdapter;

    DemoInfo.Params params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_related);
        ButterKnife.bind(this);

        params = (DemoInfo.Params) getIntent().getSerializableExtra("params");
        init();
    }

    private void init() {


        mAdapter = new MainAdapter(this);
        imageRelatedRv.setLayoutManager(new LinearLayoutManager(this));
        imageRelatedRv.setAdapter(mAdapter);
        if (params != null) {
            if (params.type == DemoInfo.Params.IMAGE_TYPE) {
                mAdapter.setDatas(DemoInfo.images);
            } else if (params.type == DemoInfo.Params.CUSTOM_VIEW_TYPE) {
                mAdapter.setDatas(DemoInfo.customView);
            }
        } else {
            mAdapter.setDatas(DemoInfo.images);
        }

    }
}
