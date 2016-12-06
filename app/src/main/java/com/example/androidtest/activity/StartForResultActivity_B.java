package com.example.androidtest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.androidtest.R;

public class StartForResultActivity_B extends Activity {

	private TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_for_result_activity__b);
		textView = (TextView) findViewById(R.id.text_a_f_r_B);
	}

	public void backOnClick(View view){
		int resultCode = 100;
		Intent data = new Intent();
		String str= textView.getText().toString();
		data.putExtra("textContent", str);
		//setResult(resultCode, data);
		this.finish();
	}
}
