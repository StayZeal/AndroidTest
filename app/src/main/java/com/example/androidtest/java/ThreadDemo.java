package com.example.androidtest.java;


import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;

public class ThreadDemo extends Thread {

    Looper looper;
    Handler handler;

    TextView textView;
    ValueAnimator valueAnimator;
    AccelerateInterpolator accelerateInterpolator;
    ViewGroup viewGroup;
//    ViewRootImpl viewRoot;

    @Override
    public void run() {
        super.run();
        textView.animate();
        valueAnimator.start();


        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        try {
            this.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}
