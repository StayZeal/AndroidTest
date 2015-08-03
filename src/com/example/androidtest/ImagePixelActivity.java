package com.example.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ImagePixelActivity extends Activity {

	private Button btn;
	private ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_pixel);
		
		img = (ImageView) findViewById(R.id.image_pixel);
		btn = (Button) findViewById(R.id.btn_image_pixel);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int x= img.getWidth();
				int y = img.getHeight();
				Toast.makeText(getApplication(),"x="+x+",y="+y, Toast.LENGTH_SHORT).show();
				
			}
		});
	}

}
