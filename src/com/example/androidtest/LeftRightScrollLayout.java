package com.example.androidtest;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class LeftRightScrollLayout extends RelativeLayout {

	private Context context;
	private ImageView image;
	
	public LeftRightScrollLayout(Context context){
		super(context);
		this.context = context;
	}
	
	public LeftRightScrollLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init();
	}
	
	private void init(){
		image = new ImageView(context);
		addView(image);
	}
	
	public void setImage(int imageId){
		image.setBackgroundResource(imageId);
	}

}
