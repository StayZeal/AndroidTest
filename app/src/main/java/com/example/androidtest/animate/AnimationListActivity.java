package com.example.androidtest.animate;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.androidtest.R;

public class AnimationListActivity extends ListActivity {

    private ArrayAdapter<String> mAdapter;
    private String[] datas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        initData();

        mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, datas);

        setListAdapter(mAdapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(AnimationListActivity.this, MyActivity.class);
                        break;

                }

                AnimationListActivity.this.startActivity(intent);
            }
        });

    }

    private void initData() {
        datas = new String[]{"MyActivity"};
    }


//    class AnimateAdapter extends Basea
}
