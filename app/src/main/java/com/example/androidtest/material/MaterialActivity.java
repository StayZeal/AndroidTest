package com.example.androidtest.material;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.androidtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MaterialActivity extends Activity {

    private static final String TAG = "MaterialActivity";
    @BindView(R.id.info_text)
    TextView infoText;
    @BindView(R.id.card_view)
    CardView cardView;
    @BindView(R.id.seek_bar)
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        ButterKnife.bind(this);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i(TAG, "onProgressChanged()");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i(TAG, "onStartTrackingTouch()");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i(TAG, "onStopTrackingTouch()");

            }
        });

    }

}
