package com.example.androidtest.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by yangfeng on 2016/9/27.
 * http://www.qlcoder.com/task/75de
 */
public class QlcodeView extends View {
    private static final String TAG = "QlcodeView";

    public QlcodeView(Context context) {
        super(context);
    }

    public QlcodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QlcodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public QlcodeView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint mPaint = new Paint();
        mPaint.setColor(Color.RED);
//        canvas.drawCircle(200,200, 50, mPaint);
        try {
            InputStreamReader inputReader = new InputStreamReader(getResources().getAssets().open("145035182953188.txt"));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line = "";
            String Result = "";
            while ((line = bufReader.readLine()) != null) {
                Log.i(TAG,line);
                String[] s = line.split(" ");
                canvas.drawCircle(Integer.parseInt(s[0]), Integer.parseInt(s[1]), 5, mPaint);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
