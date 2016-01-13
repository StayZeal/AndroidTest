package com.example.androidtest;

import java.util.ArrayList;
import java.util.List;

import com.example.androidtest.getsysinfo.SystemInfoUtil;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ExecuteCommandActivity extends ListActivity {

	List<String> titleList = new ArrayList<String>();
	ArrayAdapter<String> mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_execute_command);

		String s = SystemInfoUtil.getBuildFile();

		titleList.add("system/build.prop");
		titleList.add("proc/cpuinfo");
		titleList.add("proc/meminfo");

		mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, titleList);

		setListAdapter(mAdapter);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(ExecuteCommandActivity.this,
				ShowCommandResultActivity.class);
		switch (position) {
		case 0:
			intent.putExtra("command", "build");
			startActivity(intent);
			break;
		case 1:
			intent.putExtra("command", "cpuinfo");
			startActivity(intent);
			break;
		case 2:
			intent.putExtra("command", "meminfo");
			startActivity(intent);
			break;

		default:
			break;
		}
		
	}
}
