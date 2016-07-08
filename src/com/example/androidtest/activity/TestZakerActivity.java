package com.example.androidtest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.example.androidtest.R;

public class TestZakerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_test_zaker);
	}
	 
}
