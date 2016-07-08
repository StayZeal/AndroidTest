package com.example.androidtest.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import com.example.androidtest.R;

public class ZakerLayout extends RelativeLayout {

	private static final String TAG = "ZakerLayout";
	private Context context;
	private Scroller scroller;
	private float screenHeight;
	private float screenWidth;
	private ImageView imageView;
	private float lastDownY;
	private float currentY;
	private float moveY;

	private boolean closeFlag = false;

	public ZakerLayout(Context context) {
		super(context);
		this.context = context;
		setUpView();
	}

	public ZakerLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		setUpView();
	}

	private void setUpView() {

		Interpolator polator = new BounceInterpolator();
		scroller = new Scroller(context, polator);

		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics metrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(metrics);
		screenHeight = metrics.heightPixels;
		screenWidth = metrics.widthPixels;

		this.setBackgroundColor(Color.argb(0, 0, 0, 0));

		imageView = new ImageView(context);
		imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
		imageView.setScaleType(ScaleType.FIT_XY);// 填充整个屏幕
		imageView.setImageResource(R.drawable.bg);// 默认背景

		addView(imageView);

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			lastDownY = event.getY();
			return true;
		case MotionEvent.ACTION_MOVE:
			currentY = event.getY();
			moveY = currentY - lastDownY;
			if (moveY < 0) {// 只有向上滑动才有效果
			//	Log.i(TAG, "手指在屏幕上滑动");
				scrollTo(0, (int) -moveY);
			}
			break;
		case MotionEvent.ACTION_UP:
			currentY = event.getY();
			moveY = currentY - lastDownY;
			if (moveY < 0) {
				if (Math.abs(moveY) > screenHeight / 2) {
					startBounceAnmi(this.getScrollY(), (int)screenHeight, 450);
					closeFlag = true;
				} else {
					Log.i(TAG,"图片将要掉落 scroll y: " + String.valueOf(getScrollY()));
					startBounceAnmi(this.getScrollY(), -this.getScrollY(), 1000);
				}
			}
			break;

		default:
			break;
		}

		return super.onTouchEvent(event);
	}

	private void startBounceAnmi(int startY, int dy, int duration) {
		
		//Log.i(TAG, "startBounceAnmi() start--->"+dy); 
		scroller.startScroll(0, startY, 0, dy, duration);
		invalidate();
		//Log.i(TAG, "startBounceAnmi() end--->");
		
	}

	/**
	 * 设置要推动的图片
	 * @param imageId
	 */
	public void setImageBackground(int imageId) {
		imageView.setImageResource(imageId);
	}

	public void setBounceAnim(Drawable drawable) {
		imageView.setImageDrawable(drawable);
	}

	@Override
	public void computeScroll() {
		if (scroller.computeScrollOffset()) {
			Log.i(TAG, "正在滚动....");
			scrollTo(scroller.getCurrX(), scroller.getCurrY());
			/*
			 * Log.i("scroller", "getCurrX()= " + scroller.getCurrX() +
			 * "     getCurrY()=" + scroller.getCurrY() + "  getFinalY() =  " +
			 * scroller.getFinalY());
			 */
			/*
			 * 更新界面
			 */
			postInvalidate();
		} else {
			if (closeFlag) {
				this.setVisibility(View.GONE);
			}
		}
	}

}
