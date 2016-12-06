package com.example.androidtest.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androidtest.R;

public class GetPhoneHeapSizeActivity extends Activity {

	private TextView heapSize;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_phone_heap_size);
		heapSize = (TextView) findViewById(R.id.heap_size_text);
		
		ActivityManager manager = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);  
		int heapSize = manager.getMemoryClass(); 
		this.heapSize.setText("手机堆size："+heapSize+"M");
	}
}
