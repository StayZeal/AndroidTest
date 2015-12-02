package com.example.androidtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Path;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.MediaStore.Audio.Media;
import android.util.Log;
import android.widget.ArrayAdapter;

public class GetSDPathActivity extends ListActivity {

	private static final String TAG = "GetSDPathActivity";

	private static List<String> strs;

	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// setContentView(R.layout.activity_get_sdpath);
		context = this;

		File extFile = Environment.getExternalStorageDirectory();

		strs = new ArrayList<String>();
		String path = getAvailableSdPath("test2015wai.txt");
		getExtSDCardPaths();
		Log.i(TAG, path);

		strs.add(extFile.getAbsolutePath());
		strs.add(context.getCacheDir().getAbsolutePath());
		strs.add(context.getCacheDir().getPath());
		strs.add(context.getFilesDir().getAbsolutePath());
		String s = context.getFilesDir().getParentFile().getParentFile()
				.getParentFile().getParentFile().getAbsolutePath();
		strs.add(s);
		// strs.add(context.getExternalFilesDir(null).getAbsolutePath());
		// for (File f : context.getExternalFilesDirs("youngTest")) {
		// strs.add(f.getAbsolutePath());
		// }
		// try {
		// strs.add(context.getCacheDir().getCanonicalPath());
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, strs));

	}

	public String getAvailableSdPath(String filePath) {

		String availablePath = "";

		StorageManager sm = (StorageManager) context
				.getSystemService(Context.STORAGE_SERVICE);
		try {
			String[] paths = (String[]) sm.getClass()
					.getMethod("getVolumePaths", null).invoke(sm, null);
			for (String s : paths) {
				Log.e(TAG, "path: " + s);
				String fullPath = join(s, filePath);

				boolean b = makeDir(fullPath, 777);
				if (b == true) {
					Log.i(TAG, "可用SD路径：" + fullPath);
					availablePath = fullPath;
					// return availablePath;
					StatFs statfs = new StatFs(availablePath);
					long totalBlocks = statfs.getBlockCountLong();
					long size = statfs.getBlockSizeLong();
					long total = totalBlocks * size;
					strs.add("可用SD路径：" + availablePath + " 大小：" + total / 1024
							/ 1024 / 1024 + "G");

				} else {
					strs.add("不可用SD：" + s);
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
		return availablePath;
	}

	public static boolean makeDir(String dir, int mod) {
		File destDir = new File(dir);
		if (destDir.exists() == false) {
			Log.i(TAG, "文件不存在，正在创建目录..." + dir);
			if (destDir.mkdirs() == false) {
				Log.e(TAG, "文件不存在，创建目录失败：" + dir);
				return false;
			}
		} else {
			Log.i(TAG, "文件已存在：" + destDir.getAbsolutePath());
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

	/**
	 * @Title: getExtSDCardPaths
	 * @Description: to obtain storage paths, the first path is theoretically
	 *               the returned value of
	 *               Environment.getExternalStorageDirectory(), namely the
	 *               primary external storage. It can be the storage of internal
	 *               device, or that of external sdcard. If paths.size() >1,
	 *               basically, the current device contains two type of storage:
	 *               one is the storage of the device itself, one is that of
	 *               external sdcard. Additionally, the paths is directory.
	 * @return List<String>
	 * @throws IOException
	 */
	public static List<String> getExtSDCardPaths() {
		List<String> paths = new ArrayList<String>();
		String extFileStatus = Environment.getExternalStorageState();
		File extFile = Environment.getExternalStorageDirectory();
		if (extFileStatus.equals(Environment.MEDIA_MOUNTED) && extFile.exists()
				&& extFile.isDirectory() && extFile.canWrite()) {
			paths.add(extFile.getAbsolutePath());
			strs.add("get by Environment: " + extFile.getAbsolutePath());
		} else {
			strs.add("get by Environment:无法获取");
		}
		try {
			// obtain executed result of command line code of 'mount', to judge
			// whether tfCard exists by the result
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec("mount");
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			int mountPathIndex = 1;
			while ((line = br.readLine()) != null) {
				// format of sdcard file system: vfat/fuse
				if ((!line.contains("fat") && !line.contains("fuse") && !line
						.contains("storage"))
						|| line.contains("secure")
						|| line.contains("asec")
						|| line.contains("firmware")
						|| line.contains("shell")
						|| line.contains("obb")
						|| line.contains("legacy") || line.contains("data")) {
					continue;
				}
				String[] parts = line.split(" ");
				int length = parts.length;
				if (mountPathIndex >= length) {
					continue;
				}
				String mountPath = parts[mountPathIndex];
				if (!mountPath.contains("/") || mountPath.contains("data")
						|| mountPath.contains("Data")) {
					continue;
				}
				File mountRoot = new File(mountPath);
				if (!mountRoot.exists() || !mountRoot.isDirectory()
						|| !mountRoot.canWrite()) {
					continue;
				}
				boolean equalsToPrimarySD = mountPath.equals(extFile
						.getAbsolutePath());
				if (equalsToPrimarySD) {
					continue;
				}
				paths.add(mountPath);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paths;
	}
}
