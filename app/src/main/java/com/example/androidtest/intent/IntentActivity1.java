package com.example.androidtest.intent;

import com.example.androidtest.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntentActivity1 extends Activity {

	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_activity1);
		btn = (Button) findViewById(R.id.btn_intent_1);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent startIntent = new Intent();
				startIntent.setType("text/plain");
				startIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
				startIntent.setAction(Intent.ACTION_SEND);
				startActivity(Intent.createChooser(startIntent, getResources().getText(R.string.send_to)));
				//startActivity(startIntent);
			}
		});
		
	}

	 
}
