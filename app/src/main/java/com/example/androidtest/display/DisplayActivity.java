package com.example.androidtest.display;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.example.androidtest.R;

public class DisplayActivity extends Activity {

    private TextView currentDp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        currentDp = (TextView) findViewById(R.id.current_dp);
        get();
    }


    private void get() {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        currentDp.setText("Dip:" + metrics.density+"desityDpi: "+metrics.densityDpi + " width:" + metrics.widthPixels + "px,height:" + metrics.heightPixels + "px");

    }

}
