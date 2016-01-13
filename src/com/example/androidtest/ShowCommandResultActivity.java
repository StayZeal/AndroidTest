package com.example.androidtest;

import com.example.androidtest.getsysinfo.SystemInfoUtil;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowCommandResultActivity extends Activity {

	TextView info;
	String command;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_command_result);
		info = (TextView) findViewById(R.id.info);

		command = getIntent().getStringExtra("command");

		setText(command);

	}

	private void setText(String command) {

		if (command.equals("build")) {
			info.setText(SystemInfoUtil.getBuildFile());
			return;
		} else if (command.equals("cpuinfo")) {
			info.setText(SystemInfoUtil.getCpuInfo());
			return;
		}
		if (command.equals("meminfo")) {
			info.setText(SystemInfoUtil.getMeminfo());
			return;
		}

	}
}
