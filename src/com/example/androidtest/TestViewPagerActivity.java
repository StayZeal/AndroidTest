package com.example.androidtest;

import java.util.ArrayList;
import java.util.List;




import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class TestViewPagerActivity extends Activity implements OnPageChangeListener {

	private ViewPager viewPager;
	private MyPageAdapter mPageAdapter;
	private View view1;
	private View view2;
	private View view3;
	private List<View> viewList;
	private List<String> titleList;
	private LayoutInflater l;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_view_pager);
		viewPager = (ViewPager) findViewById(R.id.view_pager);
		viewPager.setOnPageChangeListener(this);
		
		l = getLayoutInflater().from(this);
		
		viewList = new ArrayList<View>();
		view1 = l.inflate(R.drawable.view_pager_1, null);
		view2 = l.inflate(R.drawable.view_pager_2, null);
		view3 = l.inflate(R.drawable.view_pager_3, null);
		
		/*view1 = findViewById(R.drawable.view_pager_1);
		view2 = findViewById(R.drawable.view_pager_2);
		view3 = findViewById(R.drawable.view_pager_3);*/
	 
		 
		
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		
		titleList = new ArrayList<String>();
		/*titleList.add("标题一");
		titleList.add("标题二");
		titleList.add("标题二");*/
		titleList.add("1");
		titleList.add("2");
		titleList.add("3");
		
		
		mPageAdapter = new MyPageAdapter();
		viewPager.setAdapter(mPageAdapter);
	}
	
	class MyPageAdapter extends PagerAdapter{

		
		
		
		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			return titleList.get(position);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return viewList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			container.addView(viewList.get(position));
			return viewList.get(position);
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			container.removeView(viewList.get(position));
		}
	}



	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		
	}
}
