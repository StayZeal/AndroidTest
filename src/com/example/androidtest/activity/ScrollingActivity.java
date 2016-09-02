package com.example.androidtest.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.androidtest.R;
import com.example.androidtest.adapter.VPAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ScrollingActivity extends AppCompatActivity {

    @Bind(R.id.action_bar_bg)
    ImageView actionBarBg;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @Bind(R.id.app_bar)
    AppBarLayout appBar;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.tablayout)
    TabLayout tablayout;
    /*    @Bind(R.id.listview)
        ListView listview;*/
    private VPAdapter<String> mVpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= 21) {

            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

            //设置状态栏颜色
            getWindow().setStatusBarColor(Color.TRANSPARENT);
//            getWindow().setStatusBarColor(getResources().getColor(android.R.color.holo_blue_bright));
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbarLayout.setTitle("啦啦啦");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.gradient);

        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                actionBarBg.setAnimation(animation);
                int a = verticalOffset * 128 / appBarLayout.getTotalScrollRange();

//                actionBarBg.setImageAlpha(a);

            }
        });

        init();
    }


    private void init() {
        mVpAdapter = new VPAdapter<>(getSupportFragmentManager(), getData());
        viewPager.setAdapter(mVpAdapter);

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
//                getData());
//        listview.setAdapter(arrayAdapter);
    }

    private List<String> getData() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        return list;
    }
}
