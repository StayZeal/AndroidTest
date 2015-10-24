package com.example.androidtest;


import java.util.List;

import com.example.androidtest.charge.ChargeActivity;
import com.example.androidtest.display.DisplayActivity;
import com.example.androidtest.intent.IntentActivity1;
import com.example.androidtest.locate.GpsActivity;
import com.example.androidtest.material.MaterialActivity;
import com.example.androidtest.storage.SharePreferenceActivity;
import com.example.listview.ListViewActivity;
import com.example.listview.RefreshListViewActivity;
import com.example.viewpager.BackGroundColorAnimationActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
	
	private static final String TAG  = MainActivity.class.getSimpleName();
	private Animation animation;
	private Context context;
	private Activity acticity;
	private List<String> testList;
	private String[] titleList;
	private ArrayAdapter<String> arrayAdapter;

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		titleList = new String[]{
				"Zaker风格欢迎界面测试",
				"ViewPager全屏背景渐变",
				"Gallery测试",
				"Image透明",
				"ImageView像素测试",
				"startActivityForResult",
				"下拉刷新ListView",
				"SharePreference",
				"Intent",
				"Material",
				"Charge",
				"屏幕适配",
				"GPS",
				"VideoView",
				"QQ聊天跳转",
				"RSA加密",
				"Volley Https",
				"Intent使用",
				"listViewbtn和text点击事件",
				"全屏测试"
		};
		/*testList = new ArrayList<String>();
		testList.add("全屏测试");*/
		
		arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,titleList);
//		arrayAdapter = new ArrayAdapter<String>(this,R.layout.item_main_acitvity,R.id.title,titleList);
		this.setListAdapter(arrayAdapter);
		
		/*acticity = this;
		this.getWindow();
		View layout = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
		
		layout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Log.i(TAG,"点击了屏幕");
				acticity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
			}
		});
		
		startActivity(new Intent().setClass(MainActivity.this, TestViewPagerActivity.class));*/
		//
		//
	}
/*	@SuppressLint("InlinedApi")
	public void pClick(View view){
		int flag = acticity.getWindow().getDecorView().getSystemUiVisibility();
		Log.i(TAG,"点击了屏幕 "+ flag);
		acticity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

	}*/
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		Log.i(TAG, "onListItemClick-->执行");
		switch (position) {
		case 0:
			startActivity(new Intent().setClass(MainActivity.this, TestZakerActivity.class));
			break;
		case 1:
			startActivity(new Intent().setClass(MainActivity.this, BackGroundColorAnimationActivity.class));
			break;
		case 2:
			break;
		case 3:
			startActivity(new Intent().setClass(MainActivity.this, ImageTranspaencyActivity.class));
			break;
		case 4:
			startActivity(new Intent(MainActivity.this,ImagePixelActivity.class));
			
			break;
		case 5:
			startActivity(new Intent(this,StartForResultActivity_A.class));
			break;
		case 6:
			startActivity(new Intent(this,RefreshListViewActivity.class));
			break;
		case 7:
			startActivity(new Intent(this,SharePreferenceActivity.class));
			break;
		case 8:
			startActivity(new Intent(this,IntentActivity1.class));
			break;
		case 9:
			startActivity(new Intent(this,MaterialActivity.class));
			break;
		case 10:
			startActivity(new Intent(this,ChargeActivity.class));
			break;
		case 11:
			startActivity(new Intent(this,DisplayActivity.class));
			break;
		case 12:
			startActivity(new Intent(this,GpsActivity.class));
			break;
		case 13:
			startActivity(new Intent(this,VideoViewActivity.class));
			break;
		case 14:
			String url11 = "mqqwpa://im/chat?chat_type=wpa&uin=543244&version=1";  
	        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url11))); 
		case 15:
			startActivity(new Intent(this,RSAEncryptActivity.class));
			break;
		case 16:
			startActivity(new Intent(this,VolleyActivity.class));
			break;
		case 17:
			startActivity(new Intent(this,IntentTestActivity.class));
			break;
		case 18:
			startActivity(new Intent(this,ListViewActivity.class));
			break;
		default:
			break;
		}
	}
		
	 
}
