package com.example.androidtest;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.VideoView;

public class VideoViewActivity extends Activity {

	private VideoView videoView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video_view);
		videoView = (VideoView) findViewById(R.id.play_video_view);
//		videoView.setVideoPath("http://www.xiniubox.com/androbox/api.php?action=api.common.geapp&fid=5572b75dd0d4fb73398b456f");
		videoView.setVideoPath("http://test.xiniubox.com/androbox/app-vedio-id-1426497546.mp4");
//		videoView.setVideoURI(Uri.parse("http://test.xiniubox.com/androbox/app-vedio-id-1426497546.mp4"));
		videoView.start();
	}
}
