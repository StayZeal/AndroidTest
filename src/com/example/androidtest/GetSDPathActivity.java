package com.example.androidtest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.util.Log;
import android.widget.ArrayAdapter;

public class GetSDPathActivity extends ListActivity {

	private static final String TAG = "GetSDPathActivity";
	
	private static String[] strs;

	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

//		setContentView(R.layout.activity_get_sdpath);
		context = this;

		String path = getAvailableSdPath("yangfeng");
		Log.i(TAG, path);
		
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,strs));
	}

	public String getAvailableSdPath(String filePath) {
		StorageManager sm = (StorageManager) context
				.getSystemService(Context.STORAGE_SERVICE);
		try {
			String[] paths = (String[]) sm.getClass()
					.getMethod("getVolumePaths", null).invoke(sm, null);
            strs = paths;
			for (String s : paths) {
				Log.e(TAG, "path: " + s);
				String fullPath = join(s, filePath);

				boolean b = makeDir(fullPath, 777);
				if (b == true) {
					Log.i(TAG, "可用SD路径："+fullPath);
					return fullPath;
				}
			}

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static boolean makeDir(String dir, int mod) {
		File destDir = new File(dir);
		if (destDir.exists()==false) {
			Log.i(TAG, "文件不存在，正在创建目录..."+dir);
			if (destDir.mkdirs()==false) {
				Log.e(TAG, "文件不存在，创建目录失败："+dir);
				return false;
			}
		}

		Process p;
		String cmd = "chmod -R " + mod + " " + dir;
		try {
			p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static String join(String parent, String child) {
		return parent + File.separator + child;
	}

}
