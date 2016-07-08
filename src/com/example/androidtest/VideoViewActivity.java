package com.example.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewActivity extends Activity {

    private VideoView videoView;

    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        mediaController = new MediaController(this);
        videoView = (VideoView) findViewById(R.id.play_video_view);
        videoView.setMediaController(mediaController);
        videoView.setVideoPath("http://192.168.3.111/dj.mp4");
        videoView.start();
    }
}
