package com.example.androidtest.customview;


import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.NestedScrollingParent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ListView;

public class NestSV extends LinearLayout implements NestedScrollingParent {


    RecyclerView recyclerView;

    LinearLayoutManager linearLayoutManager;

    ListView listView;

    public NestSV(Context context) {
        super(context);
    }

    public NestSV(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NestSV(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public NestSV(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
