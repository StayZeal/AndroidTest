package com.example.androidtest.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.androidtest.R;
import com.example.androidtest.adapter.BaseVPAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScrollActivity extends AppCompatActivity {

    private static final String TAG = "TransparentActivity";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.title_image)
    ImageView titleImage;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private GestureDetectorCompat mDetector;

    private BaseVPAdapter<String> mVpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        ButterKnife.bind(this);
        toolbar.inflateMenu(R.menu.widget_menu);

        if (Build.VERSION.SDK_INT >= 21) {

            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

            //设置状态栏颜色
            getWindow().setStatusBarColor(Color.TRANSPARENT);
//            getWindow().setStatusBarColor(getResources().getColor(android.R.color.holo_blue_bright));
        }

//        mDetector = new GestureDetectorCompat(this, new MyGestureDetector());
//        lp=(RelativeLayout.LayoutParams) titleImage.getLayoutParams();

        init();
    }


    private void init() {
        mVpAdapter = new BaseVPAdapter<>(getSupportFragmentManager(), getData());
        viewPager.setAdapter(mVpAdapter);
    }

    private List<String> getData() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        return list;
    }

    RelativeLayout.LayoutParams lp = null;
    float startX = 0;
    float startY;
    float endX;
    float endY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

//        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) titleImage.getLayoutParams();
//        mDetector.onTouchEvent(event);
/*
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
//                Log.i(TAG, "start x:" + startX);
                startY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                endX = event.getX();
                endY = event.getY();

                Log.i(TAG, "margin top:" + lp.topMargin);
                int top = (int) (lp.topMargin + (endY - startY) / 10.0f);
                Log.i(TAG, "Top:" + top);
                int b = titleImage.getBottom();
                Log.i(TAG, "bottom:" + b);
//                if (b >= 100) {
                    lp.setMargins(0, top, 0, 0);
//                    titleImage.setLayoutParams(lp);
//                titleImage.scrollBy(0, (int) (endY-startY));
//                titleImage.scrollTo(0, (int) -(endY-startY));
//                }
//                titleImage.setPadding(0, (int) (endX - startX), 0, 0);

//                Log.i(TAG, "end x:" + endX);
        }*/
        return super.onTouchEvent(event);
    }

    /*class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return super.onDown(e);
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            Log.i(TAG, "onScroll-->");
//            Log.i(TAG, "onScroll event 1:" + e1.getAction() + " " + e2.getAction());
//            Log.i(TAG, "X轴上的距离：" + distanceX);
//            Log.i(TAG, "Y轴上的距离：" + distanceY);
//            titleImage.setPadding(0, (int) distanceX,0,0);
            return true;
        }

    }*/

}
