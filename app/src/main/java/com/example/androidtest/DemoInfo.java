package com.example.androidtest;

import android.app.Activity;

import com.example.androidtest.activity.BrightnessActivity;
import com.example.androidtest.activity.CameraActivity;
import com.example.androidtest.activity.CustomViewActivity;
import com.example.androidtest.activity.DpiTestActivity;
import com.example.androidtest.activity.ExecuteCommandActivity;
import com.example.androidtest.activity.ExpandableActivity;
import com.example.androidtest.activity.FrameLayoutOnClickActivity;
import com.example.androidtest.activity.FullScreenActivity;
import com.example.androidtest.activity.GetPhoneHeapSizeActivity;
import com.example.androidtest.activity.GetSDPathActivity;
import com.example.androidtest.activity.GlSurfaceActivity;
import com.example.androidtest.activity.GlSurfaceActivity2;
import com.example.androidtest.activity.ImageCacheActivity;
import com.example.androidtest.activity.ImagePixelActivity;
import com.example.androidtest.activity.ImageTranspaencyActivity;
import com.example.androidtest.activity.IntentTestActivity;
import com.example.androidtest.activity.LifecycleTestActivity;
import com.example.androidtest.activity.MyListActivity;
import com.example.androidtest.activity.PitChartActivity;
import com.example.androidtest.activity.PopupWindowActivity;
import com.example.androidtest.activity.QlCodeActivity;
import com.example.androidtest.activity.RSAEncryptActivity;
import com.example.androidtest.activity.RecycleDemoActivity;
import com.example.androidtest.activity.ScrollActivity;
import com.example.androidtest.activity.Scrolling2Activity;
import com.example.androidtest.activity.ScrollingActivity;
import com.example.androidtest.activity.StartForResultActivity_A;
import com.example.androidtest.activity.TestZakerActivity;
import com.example.androidtest.activity.TransparentActivity;
import com.example.androidtest.activity.VideoViewActivity;
import com.example.androidtest.activity.VolleyActivity;
import com.example.androidtest.activity.ZoomImageActivity;
import com.example.androidtest.activity.launch.FlagIntentActivity;
import com.example.androidtest.activity.launch.LaunchStandardActivity;
import com.example.androidtest.activity.view.CustomLLActivity;
import com.example.androidtest.animate.AnimationListActivity;
import com.example.androidtest.charge.ChargeActivity;
import com.example.androidtest.display.DisplayActivity;
import com.example.androidtest.intent.IntentActivity1;
import com.example.androidtest.listview.ListViewActivity;
import com.example.androidtest.listview.RefreshListViewActivity;
import com.example.androidtest.locate.GpsActivity;
import com.example.androidtest.material.MaterialActivity;
import com.example.androidtest.storage.SharePreferenceActivity;
import com.example.androidtest.viewpager.BackGroundColorAnimationActivity;

import java.io.Serializable;


public class DemoInfo {
    public final String title;
    public final Class<? extends Activity> actitity;
    public final Params bundle;

    public DemoInfo(String title, Class<? extends Activity> activity) {
        this.title = title;
        this.actitity = activity;
        this.bundle = null;
    }

    public DemoInfo(String title, Class<? extends Activity> activity, Params bundle) {
        this.title = title;
        this.bundle = bundle;
        this.actitity = activity;
    }


    public static final DemoInfo[] images = {
            new DemoInfo("Scrolling2Activity", Scrolling2Activity.class),
            new DemoInfo("DpiTest", DpiTestActivity.class),
            new DemoInfo("Image透明", ImageTranspaencyActivity.class),
            new DemoInfo("ImageView像素测试", ImagePixelActivity.class),
            new DemoInfo("图片缩放", ZoomImageActivity.class),
            new DemoInfo("图片缓存", ImageCacheActivity.class),
    };

    public static final Params imagesBundle = new Params(Params.IMAGE_TYPE);
    public static final DemoInfo[] customView = {
            new DemoInfo("CustomeLinearLayout", CustomLLActivity.class)
    };


    public static final Params customViewBundle = new Params(Params.CUSTOM_VIEW_TYPE);


    public static class Params implements Serializable {

        public static final int IMAGE_TYPE = 1;
        public static final int CUSTOM_VIEW_TYPE = 2;
        public final int type;

        public Params(int type) {
            this.type = type;
        }
    }

    public static final DemoInfo[] demo = {

            new DemoInfo("动画", AnimationListActivity.class),
            new DemoInfo("test",TestActivity.class),
            new DemoInfo("CustomView", MyListActivity.class, customViewBundle),
            new DemoInfo("Activity启动模式", LaunchStandardActivity.class),
            new DemoInfo("Activity启动模式Flag", FlagIntentActivity.class),
            new DemoInfo("Image相关", MyListActivity.class, imagesBundle),
            new DemoInfo("Zaker风格欢迎界面测试", TestZakerActivity.class),
            new DemoInfo("ViewPager全屏背景渐变",
                    BackGroundColorAnimationActivity.class),

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
            new DemoInfo("屏幕亮度", BrightnessActivity.class),
            new DemoInfo("ExpandableList", ExpandableActivity.class),
            new DemoInfo("PieChart", PitChartActivity.class),
            new DemoInfo("CustomView", CustomViewActivity.class),

    };
}