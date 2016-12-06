package com.example.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by yangfeng on 2016/8/24.
 */
public class MyScrollView extends LinearLayout {

    private static final String TAG = "MyScrollView";

    private Scroller mScroller;
    private float lastDownY;
    private float currentY;
    private float moveY;
    View v;
    private float startY;

    public MyScrollView(Context context) {
        super(context);
        initView(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }


    private void initView(Context context) {
        mScroller = new Scroller(context);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        Log.i(TAG,"onInterceptTouchEvent");
        switch (ev.getAction()){
            /*case MotionEvent.ACTION_DOWN:
                mXDown = ev.getRawX();
                mXLastMove = mXDown;
                break;
            case MotionEvent.ACTION_MOVE:
                mXMove = ev.getRawX();
                float diff = Math.abs(mXMove - mXDown);
                mXLastMove = mXMove;
                // 当手指拖动值大于TouchSlop值时，认为应该进行滚动，拦截子控件的事件
                if (diff > mTouchSlop) {
                    return true;
                }
                break;*/
        }

        return super.onInterceptTouchEvent(ev);
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        requestDisallowInterceptTouchEvent(true);
        Log.i(TAG,"onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastDownY = event.getY();
                startY = getScrollY();
//                break;
                return true;
            case MotionEvent.ACTION_MOVE:
                currentY = event.getY();
                moveY = currentY - lastDownY;
                scrollTo(0, (int) (startY - moveY));
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                currentY = event.getY();
                moveY = currentY - lastDownY;
                startBounceAnmi(this.getScrollY(), -this.getScrollY(), 1000);
                break;
        }

        return true;
//        return super.onTouchEvent(event);
    }


    private void startBounceAnmi(int startY, int dy, int duration) {

        //Log.i(TAG, "startBounceAnmi() start--->"+dy);
//        mScroller.startScroll(0, startY, 0, dy, duration);
//        invalidate();
        //Log.i(TAG, "startBounceAnmi() end--->");

    }

//    @Override
//    public void computeScroll() {
//
//        if (mScroller.computeScrollOffset()) {
//            Log.i(TAG, "正在滚动....");
//            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
//        }
//
//    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int childCount = getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            View childView = getChildAt(i);
//            // 为ScrollerLayout中的每一个子控件测量大小
//            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
//        }
//    }


//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//
//        if (changed) {
//            int childCount = getChildCount();
//            for (int i = 0; i < childCount; i++) {
//                View childView = getChildAt(i);
//                // 为ScrollerLayout中的每一个子控件在水平方向上进行布局
//                childView.layout(i * childView.getMeasuredWidth(), 0, (i + 1) * childView.getMeasuredWidth(), childView.getMeasuredHeight());
//            }
//        }
//    }
}
