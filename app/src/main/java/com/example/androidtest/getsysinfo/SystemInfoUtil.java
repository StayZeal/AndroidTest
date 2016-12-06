package com.example.androidtest.getsysinfo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import android.util.Log;

public class SystemInfoUtil {

	private static final String TAG = "SystemInfoUtil";

	public static String getBuildFile() {

		try {
			Process localProcess = Runtime.getRuntime().exec(
					"cat system/build.prop");
			// OutputStream os = localProcess.getOutputStream();
			// DataOutputStream dos = new DataOutputStream(os);
			// dos.writeBytes("cat system/build.prop");
			InputStream is = localProcess.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			// InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			Log.i(TAG, sb.toString());

			return sb.toString();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getCpuInfo() {
		try {
			Process localProcess = Runtime.getRuntime()
					.exec("cat proc/cpuinfo");
			// OutputStream os = localProcess.getOutputStream();
			// DataOutputStream dos = new DataOutputStream(os);
			// dos.writeBytes("cat system/build.prop");
			InputStream is = localProcess.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			// InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			Log.i(TAG, sb.toString());

			return sb.toString();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getMeminfo() {
		try {
			Process localProcess = Runtime.getRuntime()
					.exec("cat proc/meminfo");
			// OutputStream os = localProcess.getOutputStream();
			// DataOutputStream dos = new DataOutputStream(os);
			// dos.writeBytes("cat system/build.prop");
			InputStream is = localProcess.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			// InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			Log.i(TAG, sb.toString());

			return sb.toString();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
