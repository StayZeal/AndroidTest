package com.example.androidtest;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.constant.DemoInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Animation animation;
    private Context context;
    private Activity acticity;
    // private List<String> testList;
    private List<String> titleList;
    private ArrayAdapter<String> arrayAdapter;



    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        titleList = new ArrayList<String>();

        for (int i = 0; i < DemoInfo.demo.length; i++) {
            titleList.add(DemoInfo.demo[i].title);
        }

        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, titleList);
        // arrayAdapter = new
        // ArrayAdapter<String>(this,R.layout.item_main_acitvity,R.id.title,titleList);
        this.setListAdapter(arrayAdapter);

		/*
         * acticity = this; this.getWindow(); View layout =
		 * LayoutInflater.from(this).inflate(R.layout.activity_main, null);
		 * 
		 * layout.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * 
		 * Log.i(TAG,"点击了屏幕");
		 * acticity.getWindow().getDecorView().setSystemUiVisibility
		 * (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION); } });
		 * 
		 * startActivity(new Intent().setClass(MainActivity.this,
		 * TestViewPagerActivity.class));
		 */
        //
        //
    }

    /*
     * @SuppressLint("InlinedApi") public void pClick(View view){ int flag =
     * acticity.getWindow().getDecorView().getSystemUiVisibility();
     * Log.i(TAG,"点击了屏幕 "+ flag);
     * acticity.getWindow().getDecorView().setSystemUiVisibility
     * (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
     *
     * }
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        if (DemoInfo.demo[position].title.equals("QQ聊天跳转")) {
            String url11 = "mqqwpa://im/chat?chat_type=wpa&uin=543244&version=1";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url11)));

        } else {
            startActivity(new Intent(this, DemoInfo.demo[position].actitity));
        }

    }




}
