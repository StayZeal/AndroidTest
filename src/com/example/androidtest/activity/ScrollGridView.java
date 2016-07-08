package com.example.androidtest.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;


/**
 * 解决ScrollView中嵌套GridView，GridView不能完全显示的问题
 * @author yangfeng
 *
 */
public class ScrollGridView extends GridView{

	public ScrollGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		int expendSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2, MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expendSpec);
	}

}
