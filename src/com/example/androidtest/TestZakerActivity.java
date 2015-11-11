package com.example.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class TestZakerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_test_zaker);
	}
	 
}
