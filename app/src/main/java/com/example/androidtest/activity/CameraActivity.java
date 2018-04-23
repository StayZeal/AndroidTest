package com.example.androidtest.activity;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;

import com.example.androidtest.R;
import com.example.androidtest.customview.Preview;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CameraActivity extends AppCompatActivity {

    private static final String TAG = "CameraActivity";
    @BindView(R.id.camerea_preview)
    Preview mPreview;
    @BindView(R.id.framlayout)
    FrameLayout framlayout;
    private Camera mCamera;
    SurfaceHolder surfaceHolder;
    SurfaceView surfaceView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ButterKnife.bind(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        safeCameraOpen(0);

       /* surfaceView = new SurfaceView(this);
//        mPreview.addView(surfaceView);
        framlayout.addView(surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Log.i(TAG, "surfaceCreated");
                try {
                    mCamera.setPreviewDisplay(holder);
                    mCamera.setDisplayOrientation(90);
                    mCamera.startPreview();
                } catch (IOException e) {
                    Log.d(TAG, "Error setting camera preview: " + e.getMessage());
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//
//                Camera.Parameters parameters = mCamera.getParameters();
//                parameters.setPreviewSize(width, height);
//                surfaceView.requestLayout();
//                mCamera.setParameters(parameters);
//
//                // Important: Call startPreview() to start updating the preview surface.
//                // Preview must be started before you can take a picture.
//                mCamera.startPreview();
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });*/

        mPreview.setCamera(mCamera);
    }

    private boolean safeCameraOpen(int id) {
        boolean qOpened = false;

        try {
//            releaseCameraAndPreview();
            mCamera = Camera.open(id);
            qOpened = (mCamera != null);
        } catch (Exception e) {
            Log.e(getString(R.string.app_name), "failed to open Camera");
            e.printStackTrace();
        }

        return qOpened;
    }


    private void releaseCameraAndPreview() {
        mPreview.setCamera(null);
        if (mCamera != null) {
            mCamera.release();
            mCamera = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        releaseCameraAndPreview();
    }
}
