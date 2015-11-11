package com.example.androidtest;

import android.text.Layout;
import android.util.Log;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Scroller;

public class ZakerActivity extends Activity {

	private static final String TAG = "ZakerActivity";
	private static float myWinHeight ;
	float eventX = 0;
	float eventY = 0;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zaker);
		RelativeLayout container  = (RelativeLayout)findViewById(R.id.zakerLayout);
		container.addView(new MyView(this));
		myWinHeight = getWindowManager().getDefaultDisplay().getHeight();
		
	}
	
	class MyView extends ImageView{
		
		private Scroller mScroller;

		public MyView(Context context) {
			super(context);
			this.setPivotX(0);
			this.setPivotY(0);
			//this.setBackgroundColor(Color.argb(0, 0, 0, 0));
			this.setBackgroundResource(R.drawable.bg);
		}

		@SuppressLint("ClickableViewAccessibility")
		@Override
		public boolean onTouchEvent(MotionEvent event) {
		
			float height  = (float)getHeight();
			
			Log.i(TAG, "height:"+String.valueOf(height));
			int action = event.getAction();

			float nowX = 0;
			float nowY = 0;
			float moveX = 0;
			float moveY = 0;
			float move_x;
			float move_y = 0;
			ValueAnimator valueAnimator = ObjectAnimator.ofFloat(this,"y",moveY);
			switch (action) {
			case MotionEvent.ACTION_DOWN:
				eventX = event.getX();
				eventY = event.getY();
				Log.i(TAG+" event y: ", String.valueOf(eventY));
				break;
			case MotionEvent.ACTION_MOVE:
				nowX = event.getX();
				nowY = event.getY();
				moveX = nowX -eventX;
				moveY = nowY- eventY;
				Log.i(TAG+"move y: ", String.valueOf(moveY));
				if(moveY<height/2){
					Log.i(TAG,"move ");
					//ValueAnimator va = ObjectAnimator.ofFloat(this,"y",moveY);
					//va.start();
					valueAnimator.start();
				}else{
					ValueAnimator va = ObjectAnimator.ofFloat(this,"y",0,-height);
					va.start();
				}
				break;
			case MotionEvent.ACTION_UP:
//				moveX = event.getX();
//				moveY = event.getY();
				/*ValueAnimator va = ObjectAnimator.ofFloat(this,"y",0);
				
				va.start();*/
				break;

			default:
				break;
			}
			
//			move_x = moveX - eventX;
//			move_y = moveY - eventY;
//			Log.i(TAG+"move y: ", String.valueOf(move_y));
			/*
			if(event.getAction()==MotionEvent.ACTION_MOVE){
				if(Math.abs(move_y)<height/2){
					Log.i(TAG,"move");
					ValueAnimator va = ObjectAnimator.ofFloat(this,"y",0,-(height/2+move_y));
					
					va.start();
				}else{
					
				}
					
			}
			
			if(event.getAction()!=MotionEvent.ACTION_CANCEL){
				if(Math.abs(move_y)>height/2){
					Log.i(TAG, "移动到顶部");
					ValueAnimator va = ObjectAnimator.ofFloat(this, "y", 0);
					va.setInterpolator(new AccelerateInterpolator());
					va.start();
				}
			}*/
			
			return true;
		}
		
	}

	/**
	 * image 上拉事件
	 * @param view
	 */
	public void pullUp(View view){
		
		ObjectAnimator oa = ObjectAnimator.ofFloat(view, "y", 0,myWinHeight);
		oa.start();
	}
	 

}
