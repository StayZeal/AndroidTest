package com.example.androidtest.animate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import com.example.androidtest.R;
import com.example.androidtest.animateview.MyView;
import com.example.androidtest.arithmetic.TecentOsView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    @Bind(R.id.my_view)
    MyView myView;
    @Bind(R.id.tecent_os_view)
    TecentOsView tecentOsView;




    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ButterKnife.bind(this);

        System.out.print("");

//        listView.addHeaderView(new View(this));
//        listView.addFooterView(new View(this));


        tecentOsView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i(TAG, "tecentodview on click");
                return false;
            }
        });



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, "Activity on click");
        return super.onTouchEvent(event);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TAG, "Activity dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }
}
