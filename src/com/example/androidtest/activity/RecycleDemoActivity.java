package com.example.androidtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.androidtest.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecycleDemoActivity extends AppCompatActivity {

    @Bind(R.id.list)
    ListView list;
    ArrayAdapter<String> mAdapter;

    List<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_demo);
        ButterKnife.bind(this);
        datas = new ArrayList<>();
        datas.add("1");
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(RecycleDemoActivity.this, QlCodeActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
