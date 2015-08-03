package com.example.androidtest.storage;

import com.example.androidtest.R;
import com.example.androidtest.R.id;
import com.example.androidtest.R.layout;
import com.example.androidtest.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SharePreferenceActivity extends Activity {

	private TextView text;
	private Button button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_share_preference);
		init();
	}
	
	private void init(){
		
		text = (TextView) findViewById(R.id.sharepreference_text);
		button = (Button) findViewById(R.id.shareperfefrence_btn);
		Editor editor = getSharedPreferences("test", MODE_PRIVATE).edit();
		editor.putString("name", "libo");
		editor.putInt("age", 24);
		editor.commit();
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences s = getSharedPreferences("test", MODE_PRIVATE);
				text.setText(s.getString("name", "")+s.getInt("age", 0));
			}
		});
	}

	 
}
