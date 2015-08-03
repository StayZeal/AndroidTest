package com.example.listview;

import java.util.ArrayList;
import java.util.List;

import com.example.androidtest.R;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.ArrayAdapter;
/**
 * 下拉刷新listview
 * @author Administrator
 *
 */
public class RefreshListViewActivity extends Activity {

	private RefreshListView listView;
	private List<String> listData;
	private ArrayAdapter<String> mAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_refresh_list_view);
		init();
	}

	private void init(){
		listView =   (RefreshListView) findViewById(R.id.refresh_listview);
		listData = new ArrayList<String>();
		getData();
		mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listData);
		
		listView.setOnRefreshListener(new RefreshListView.OnRefreshListener() {
			
			@Override
			public void onRefresh() {
				// TODO Auto-generated method stub
				new AsyncTask<Void, Void, Void>() {

					@Override
					protected Void doInBackground(Void... params) {
						
						SystemClock.sleep(2000);
						listData.add(0, "这是刷新出来的数据");
						return null;
						
					}
					protected void onPostExecute(Void result) {
						listView.onRefreshFinish();
						mAdapter.notifyDataSetChanged();
					};
				}.execute();
				
			}
		});
		listView.setAdapter(mAdapter);
	}
	private void getData(){
		for(int i=0;i<100;i++){
			listData.add(i+" 条数据");
		}
	}
	
}
