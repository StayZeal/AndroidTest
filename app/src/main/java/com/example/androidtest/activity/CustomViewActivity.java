package com.example.androidtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.androidtest.R;
import com.example.androidtest.customview.ScrollHorizontalText;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CustomViewActivity extends AppCompatActivity {

    @Bind(R.id.custom_view)
    ScrollHorizontalText customView;

    List<String> strings = new ArrayList<>();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        ButterKnife.bind(this);


        strings.add("下雨了");
        strings.add("aaaaaaaaaaaa");
        strings.add("明天见");
        customView.setContent(strings);

    }
}
