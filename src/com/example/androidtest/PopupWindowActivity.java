package com.example.androidtest;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

public class PopupWindowActivity extends Activity {

	private PopupWindow popupWindow;
	private View contentView;
	private Handler mHandler = new Handler();
	private View popupView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popup_window);
		popupView = LayoutInflater.from(this).inflate(
				R.layout.popup_window_test, null);
		popupWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, true);
		contentView = findViewById(android.R.id.content);
		popupWindow.setBackgroundDrawable(new BitmapDrawable());

		/**
		 * 报错
		 */
		// popupWindow.showAtLocation(contentView, Gravity.CENTER, 0, 0);
		
		/**
		 * 不报错
		 */
		/*contentView.post(new Runnable() {
			
			@Override
			public void run() {
				popupWindow.showAtLocation(contentView, Gravity.CENTER, 0, 0);
				
			}
		});*/

		contentView.postDelayed(new Runnable() {

			@Override
			public void run() {
				popupWindow.showAtLocation(contentView, Gravity.CENTER, 0, 0);
			}
		}, 0);
	}
	
	
	@Override
	protected void onResume() {
		super.onResume();
		/**
		 *报错
		 */
//		popupWindow.showAtLocation(contentView, Gravity.CENTER, 0, 0);
	}
	
}
