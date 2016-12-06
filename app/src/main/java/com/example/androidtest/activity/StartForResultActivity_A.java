package com.example.androidtest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.androidtest.R;

public class StartForResultActivity_A extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_for_result_activity_);
	}

	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		// TODO Auto-generated method stub
		super.onActivityResult(arg0, arg1, arg2);
		
		System.out.println("request code: "+arg0);
		System.out.println("result code: "+arg1);
		
		/*String str = arg2.getStringExtra("textContent");
		System.err.println(str);*/
		
	}

	public void btnOnClick(View View) {
		Intent intent = new Intent(this, StartForResultActivity_B.class);
		int requestCode = 120;
		startActivityForResult(intent, requestCode);
	}
}
