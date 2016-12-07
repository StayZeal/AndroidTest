package com.example.constant;

import android.app.Activity;

import com.example.androidtest.activity.BrightnessActivity;
import com.example.androidtest.activity.CameraActivity;
import com.example.androidtest.activity.ExecuteCommandActivity;
import com.example.androidtest.activity.FrameLayoutOnClickActivity;
import com.example.androidtest.activity.FullScreenActivity;
import com.example.androidtest.activity.GetPhoneHeapSizeActivity;
import com.example.androidtest.activity.GetSDPathActivity;
import com.example.androidtest.activity.GlSurfaceActivity;
import com.example.androidtest.activity.GlSurfaceActivity2;
import com.example.androidtest.activity.ImagePixelActivity;
import com.example.androidtest.activity.ImageTranspaencyActivity;
import com.example.androidtest.activity.IntentTestActivity;
import com.example.androidtest.activity.LifecycleTestActivity;
import com.example.androidtest.activity.PopupWindowActivity;
import com.example.androidtest.activity.QlCodeActivity;
import com.example.androidtest.activity.RSAEncryptActivity;
import com.example.androidtest.activity.RecycleDemoActivity;
import com.example.androidtest.activity.ScrollActivity;
import com.example.androidtest.activity.ScrollingActivity;
import com.example.androidtest.activity.StartForResultActivity_A;
import com.example.androidtest.activity.TestZakerActivity;
import com.example.androidtest.activity.TransparentActivity;
import com.example.androidtest.activity.VideoViewActivity;
import com.example.androidtest.activity.VolleyActivity;
import com.example.androidtest.charge.ChargeActivity;
import com.example.androidtest.display.DisplayActivity;
import com.example.androidtest.intent.IntentActivity1;
import com.example.androidtest.locate.GpsActivity;
import com.example.androidtest.material.MaterialActivity;
import com.example.androidtest.storage.SharePreferenceActivity;
import com.example.listview.ListViewActivity;
import com.example.listview.RefreshListViewActivity;
import com.example.viewpager.BackGroundColorAnimationActivity;

/**
 * Created by yangfeng on 2016/12/6.
 */
public class DemoInfo {
    public final String title;
    public final Class<? extends Activity> actitity;

    public DemoInfo(String title, Class<? extends Activity> activity) {
        this.title = title;
        this.actitity = activity;
    }

    public static final DemoInfo[] demo = {
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
            new DemoInfo("Activity Fragment生命周期", LifecycleTestActivity.class),
            new DemoInfo("Camera", CameraActivity.class),
            new DemoInfo("透明状态栏", TransparentActivity.class),
            new DemoInfo("ScrollView", ScrollActivity.class),
            new DemoInfo("ScrollingActivity", ScrollingActivity.class),
            new DemoInfo("GLSurface", GlSurfaceActivity.class),
            new DemoInfo("GLSurface 2", GlSurfaceActivity2.class),
            new DemoInfo("RecycleDemo", RecycleDemoActivity.class),
            new DemoInfo("QlcodeDemo", QlCodeActivity.class),
            new DemoInfo("屏幕亮度", BrightnessActivity.class)
    };
}