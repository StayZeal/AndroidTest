package com.example.listview;

import com.example.androidtest.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends Activity {

	private static final String TAG = ListViewActivity.class.getSimpleName();
	private View footView;
	private ListView listView;
	private Button btn;
	private TextView text,title;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		
		title = (TextView) findViewById(R.id.title);
		listView = (ListView) findViewById(R.id.list);
		footView = LayoutInflater.from(this).inflate(R.layout.footview, null);
		listView.addFooterView(footView);
		
		btn = (Button) footView.findViewById(R.id.foot_view_btn);
		text = (TextView) footView.findViewById(R.id.foot_view_text);
		
		ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, 
				              android.R.layout.simple_list_item_1,
				              new String[]{"1","2","3","4","5","6"});
		
		listView.setAdapter(mAdapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Toast.makeText(ListViewActivity.this, "点击listView的item", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Log.i(TAG	, "");
				title.setText("按钮");
				Toast.makeText(ListViewActivity.this, "点击了按钮", Toast.LENGTH_SHORT).show();
			}
		});
		
		text.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				title.setText("文本");
				Toast.makeText(ListViewActivity.this, "点击了文本", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
