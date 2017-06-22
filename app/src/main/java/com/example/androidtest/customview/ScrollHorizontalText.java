package com.example.androidtest.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

/**
 * Created by yangfeng on 2017/6/22.
 */

public class ScrollHorizontalText extends View {

    private static final String TAG = ScrollHorizontalText.class.getSimpleName();
    private List<String> contents;
    private Paint mPaint;
    private int offsetX = 0;
    private int offsetY = 0;
    private Rect mRect;
    private int count = 0;
    private int textSpace = 10;
    private int widthSize;
    private int heightSize;
    private GestureDetector mDetector;
    private float scrollX;

    public void setContent(List<String> content) {
        this.contents = content;
        count = contents.size();
    }


    public ScrollHorizontalText(Context context) {
        super(context);
        init(context);
    }

    public ScrollHorizontalText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ScrollHorizontalText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ScrollHorizontalText(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//消除锯齿
        mPaint.setTextSize(40);
        mPaint.setColor(Color.RED);
        mRect = new Rect();

        mDetector = new GestureDetector(context, new GestureListener());
        setClickable(true);


    }

    private String currentContent;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        widthSize = MeasureSpec.getSize(widthMeasureSpec);
        heightSize = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        offsetX = 0;
        offsetX -= scrollX;
        Log.i(TAG, "offsetX:" + offsetX);


        for (int i = 0; i < count; i++) {
            currentContent = contents.get(i);
            mPaint.getTextBounds(currentContent, 0, currentContent.length(), mRect);

            if (offsetY < mRect.height())
                offsetY = mRect.height();

            canvas.drawText(currentContent, offsetX, offsetY, mPaint);
            offsetX += mRect.width() + textSpace;

            getWidth();
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

            Log.i(TAG, "onScroll distanceX:" + distanceX);
            scrollX += distanceX;

            invalidate();
            return super.onScroll(e1, e2, distanceX, distanceY);
        }
    }

}
