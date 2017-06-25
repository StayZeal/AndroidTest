package com.example.androidtest.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidtest.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DpiTestActivity extends AppCompatActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.dpi_Tv)
    TextView dpiTv;
    @Bind(R.id.dpi)
    ImageView dpi;
    @Bind(R.id.mdpi_Tv)
    TextView mdpiTv;
    @Bind(R.id.mdpi)
    ImageView mdpi;
    @Bind(R.id.hdpi_Tv)
    TextView hdpiTv;
    @Bind(R.id.hdpi)
    ImageView hdpi;
    @Bind(R.id.nodpi_Tv)
    TextView nodpiTv;
    @Bind(R.id.nodpi)
    ImageView nodpi;
    @Bind(R.id.xhdpi_Tv)
    TextView xhdpiTv;
    @Bind(R.id.xhdpi)
    ImageView xhdpi;
    @Bind(R.id.xxhdpi_Tv)
    TextView xxhdpiTv;
    @Bind(R.id.xxhdpi)
    ImageView xxhdpi;
    @Bind(R.id.xxxhdpi_Tv)
    TextView xxxhdpiTv;
    @Bind(R.id.xxxhdpi)
    ImageView xxxhdpi;


    private List<TextView> textViews;
    private List<ImageView> imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dpi_test);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        toolbar.setTitle("DpiTest");

        init();

    }

    private void init() {
        textViews = new ArrayList<>();
        textViews.add(dpiTv);
        textViews.add(mdpiTv);
        textViews.add(hdpiTv);
        textViews.add(nodpiTv);
        textViews.add(xhdpiTv);
        textViews.add(xxhdpiTv);
        textViews.add(xxxhdpiTv);

        imageViews = new ArrayList<>();
        imageViews.add(dpi);
        imageViews.add(mdpi);
        imageViews.add(hdpi);
        imageViews.add(nodpi);
        imageViews.add(xhdpi);
        imageViews.add(xxhdpi);
        imageViews.add(xxxhdpi);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.dpi_test, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.show:
                setView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setView() {
        for (int i = 0; i < textViews.size(); i++) {
            textViews.get(i).setText(getMText(i));
        }
    }


    private String getMText(int postion) {
        ImageView iv = imageViews.get(postion);
        Bitmap bitmap = iv.getDrawingCache();
//        bitmap.getRowBytes()*bitmap.getByteCount();
        String s = "宽" + iv.getWidth() + "高" + iv.getHeight()+"大小";
        return s;
    }


}
