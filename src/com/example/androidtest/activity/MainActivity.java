package com.example.androidtest.activity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.androidtest.charge.ChargeActivity;
import com.example.androidtest.display.DisplayActivity;
import com.example.androidtest.intent.IntentActivity1;
import com.example.androidtest.locate.GpsActivity;
import com.example.androidtest.material.MaterialActivity;
import com.example.androidtest.storage.SharePreferenceActivity;
import com.example.listview.ListViewActivity;
import com.example.listview.RefreshListViewActivity;
import com.example.viewpager.BackGroundColorAnimationActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Animation animation;
    private Context context;
    private Activity acticity;
    // private List<String> testList;
    private List<String> titleList;
    private ArrayAdapter<String> arrayAdapter;

    private static final DemoInfo[] demo = {
            new DemoInfo("Zaker风格欢迎界面测试", TestZakerActivity.class),
            new DemoInfo("ViewPager全屏背景渐变",
                    BackGroundColorAnimationActivity.class),
            new DemoInfo("Image透明", ImageTranspaencyActivity.class),
            new DemoInfo("ImageView像素测试", ImagePixelActivity.class),
            new DemoInfo("startActivityForResult",
                    StartForResultActivity_A.class),
            new DemoInfo("下拉刷新ListView", RefreshListViewActivity.class),
            new DemoInfo("SharePreference", SharePreferenceActivity.class),
            new DemoInfo("Intent", IntentActivity1.class),
            new DemoInfo("Material", MaterialActivity.class),
            new DemoInfo("Charge", ChargeActivity.class),
            new DemoInfo("屏幕适配", DisplayActivity.class),
            new DemoInfo("GPS", GpsActivity.class),
            new DemoInfo("VideoView", VideoViewActivity.class),
            new DemoInfo("QQ聊天跳转", null),
            new DemoInfo("RSA加密", RSAEncryptActivity.class),
            new DemoInfo("Volley Https", VolleyActivity.class),
            new DemoInfo("Intent使用", IntentTestActivity.class),
            new DemoInfo("listViewbtn和text点击事件", ListViewActivity.class),
            new DemoInfo("SD路径适配", GetSDPathActivity.class),
            new DemoInfo("显示手机堆大小", GetPhoneHeapSizeActivity.class),
            new DemoInfo("执行linux 命令", ExecuteCommandActivity.class),
            new DemoInfo("popupwindow", PopupWindowActivity.class),
            new DemoInfo("FrameLayout点击事件", FrameLayoutOnClickActivity.class),
            new DemoInfo("全屏测试", FullScreenActivity.class),
            new DemoInfo("Activity生命周期", LifecycleTestActivity.class),
            new DemoInfo("Camera", CameraActivity.class),
            new DemoInfo("透明状态栏", TransparentActivity.class)
    };

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        titleList = new ArrayList<String>();

        for (int i = 0; i < demo.length; i++) {
            titleList.add(demo[i].title);
        }

        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, titleList);
        // arrayAdapter = new
        // ArrayAdapter<String>(this,R.layout.item_main_acitvity,R.id.title,titleList);
        this.setListAdapter(arrayAdapter);

		/*
         * acticity = this; this.getWindow(); View layout =
		 * LayoutInflater.from(this).inflate(R.layout.activity_main, null);
		 * 
		 * layout.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * 
		 * Log.i(TAG,"点击了屏幕");
		 * acticity.getWindow().getDecorView().setSystemUiVisibility
		 * (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION); } });
		 * 
		 * startActivity(new Intent().setClass(MainActivity.this,
		 * TestViewPagerActivity.class));
		 */
        //
        //
    }

    /*
     * @SuppressLint("InlinedApi") public void pClick(View view){ int flag =
     * acticity.getWindow().getDecorView().getSystemUiVisibility();
     * Log.i(TAG,"点击了屏幕 "+ flag);
     * acticity.getWindow().getDecorView().setSystemUiVisibility
     * (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
     *
     * }
     */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        if (demo[position].title.equals("QQ聊天跳转")) {
            String url11 = "mqqwpa://im/chat?chat_type=wpa&uin=543244&version=1";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url11)));

        } else {
            startActivity(new Intent(this, demo[position].actitity));
        }

    }

    //
    // titleList = new String[] { "", "",
    // "", "", "", "", "", "",
    // "", "", "", "",
    // "", "", "", "全屏测试" };

    @SuppressWarnings("unused")
    private static class DemoInfo {
        private final String title;
        private final Class<? extends Activity> actitity;

        public DemoInfo(String title, Class<? extends Activity> activity) {
            this.title = title;
            this.actitity = activity;
        }
    }

}
