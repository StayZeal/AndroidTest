package com.example.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class FullScreenActivity extends Activity {


    private FullScreenIV fullScreenIV;
    private Button button;
    private TextView textView;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        button = new Button(this);
        button.setText("按钮");
        textView = new TextView(this);
        textView.setText("标题");
        seekBar = new SeekBar(this);


        fullScreenIV = (FullScreenIV) findViewById(R.id.full_screen_image);
        fullScreenIV.init(this, textView, button, seekBar);
        setContentView(R.layout.activity_full_screen);

    }
}
