package com.example.androidtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Intent 的使用
 * 
 * @author yangfeng
 *
 */
public class IntentTestActivity extends Activity {

	private ListView intentList;
	private ArrayAdapter<String> mAdapter;
	private List<String> listData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent_test);
		intentList = (ListView) findViewById(R.id.intent_list);
		listData = new ArrayList<String>();
		getData();
		mAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listData);

		intentList.setAdapter(mAdapter);
		intentList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0:
					Intent intent = new Intent(Intent.ACTION_VIEW);
//					intent.setData(Uri.parse("content://contacts/people/1"));//打开第一个联系人
					intent.setData(Uri.parse("content://contacts/people/"));//打开通讯录列表
//					intent.setData(Contacts.CONTENT_URI);
					startActivity(intent);
					break;
				case 1:
					startActivity(new Intent(Intent.ACTION_DIAL));//打开拨号键
					break;
				case 2:
					//编辑第2个联系人注意不是联系人列表的顺序，而是新建联系人的顺序
					startActivity(new Intent(Intent.ACTION_EDIT,Uri.parse("content://contacts/people/2")));
					break;
				default:
					break;
				}

			}
		});
	}

	private void getData() {

		listData.add("ACTION_VIEW");
		listData.add("ACTION_DIAL");
		listData.add("ACTION_EDIT");
	}
}
