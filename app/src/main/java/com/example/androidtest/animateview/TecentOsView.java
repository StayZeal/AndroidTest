package com.example.androidtest.animateview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class TecentOsView extends SurfaceView implements SurfaceHolder.Callback {

    private static final String TAG = "TecentOsView";



    private final Object mSurfaceLock = new Object();
    private DrawThread mThread;
    private Paint mPaint;
    private Path mPath;

    /**
     * 振幅
     * amplitude
     */
    private int amplitude = 100;

    /**
     * 角速度
     */
    private float w = 0.5f;
    /**
     * 相位
     */
    private int offsetX = 0;
    /**
     * y轴方向位移
     */
    private double offsetY = 0;

    public TecentOsView(Context context) {
        super(context);
        init();
    }

    public TecentOsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TecentOsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TecentOsView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {


        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPath = new Path();

        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mThread = new DrawThread(holder);
        mThread.setRun(true);
        mThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        //这里可以获取SurfaceView的宽高等信息
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        synchronized (mSurfaceLock) {  //这里需要加锁，否则doDraw中有可能会crash
            mThread.setRun(false);
        }

    }

    private class DrawThread extends Thread {
        private static final long SLEEP_TIME = 4;
        private SurfaceHolder mHolder;
        private boolean mIsRun = false;

        public DrawThread(SurfaceHolder holder) {
            super(TAG);
            mHolder = holder;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (mSurfaceLock) {
                    offsetX += 5;
//                    offsetY++;
                    if (offsetX == 360) {
                        offsetX = 0;
                    }

                    if (!mIsRun) {
                        return;
                    }
                    Canvas canvas = mHolder.lockCanvas();
                    if (canvas != null) {
//                        doDraw(canvas,offsetX);  //这里做真正绘制的事情
                        drawLine(canvas);
                        mHolder.unlockCanvasAndPost(canvas);
                    }
                }
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void setRun(boolean isRun) {
            this.mIsRun = isRun;
        }
    }

    private void doDraw(Canvas canvas) {

//        canvas.drawText("aaaa",200,200,mPaint);
//        drawSin(canvas);
//        drawLine(canvas);
    }

    private void drawLine(Canvas canvas) {
        Log.i(TAG, "Start:" + System.currentTimeMillis() % 10000 + "ms");
        int x = 0, y = 500;
        canvas.drawColor(Color.WHITE);
//        mPaint.setColor(Color.BLACK);
        mPaint.setColor(Color.YELLOW);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPath.reset();
//        mPath.moveTo(200, 200);
//        mPath.lineTo(555,500);
//        mPath.lineTo(555,600);
//        mPath.lineTo(455,600);

//        canvas.drawPath(mPath, mPaint);
        int preX = 0;
        int preY = 0;
        int centerY = getHeight() / 2;

        for (int i = 0; i < getWidth(); i++) {
            x = i;
            double rad = degreeToRad(x);//角度转换成弧度
//            y = (int) (centerY - Math.sin(rad) * amplitude);
            y = centerY - (int) (amplitude * Math.sin((i * w + offsetX) * Math.PI / 180) + offsetY);
            preX = x;
            preY = y;
            if (i == 0) {
                //x=0的时候，即左上角的点，移动画笔于此
                mPath.moveTo(x, y);
            }
            //用每个x求得每个y，用quadTo方法连接成一条贝塞尔曲线
            mPath.quadTo(preX, preY, x, y);
        }

        mPath.lineTo(getWidth(), getHeight());
        mPath.lineTo(0, getHeight());
        mPath.close();
        canvas.drawPath(mPath, mPaint);

       /* while (x < getWidth()) {

            preX = x;
            preY = y;
            double rad = degreeToRad(x);//角度转换成弧度
            y = (int) (centerY - Math.sin(rad) * 100);
//            mPath.moveTo(preX, preY);
//            mPath.lineTo(x, y);
            canvas.drawPoint(x, y, mPaint);
*//*            mPath.rQuadTo(preX, preY, x, y);
            canvas.drawPath(mPath, mPaint);*//*


            x = x + 1;
        }*/
//        canvas.drawPath(mPath, mPaint);
        Log.i(TAG, "End:" + System.currentTimeMillis() % 10000 + "ms");
    }


    private void drawSinLie(Canvas canvas) {
        //绘制正弦曲线
        double preX = 0;
        double preY = 0;
        double x = 0;
        double y = 0;
        double t = 0.1;
        double scale_x = 20;
        x = t * scale_x;
        double scale_y = 50;
        y = Math.sin(t) * scale_y + 240;
        System.out.println("---------" + Math.round(Math.sin(t)));
        if (t > 0) {
            mPaint.setColor(Color.RED);
            canvas.drawLine(10 + (int) preX, (int) preY, 10 + (int) x, (int) y, mPaint);
            System.out.println(x + "s" + y);
        }
        preX = x;
        preY = y;
        if (t > 15) {
//            flag = false;
        }
    }


    /**
     * 绘制正弦曲线
     *
     * @param canvas
     */
    private void drawSin(Canvas canvas) {

        mPath.reset();
        int x = 0;
        final int width = getWidth();
        int height = getHeight();
        final int centerY = height / 2;
        canvas.drawColor(Color.WHITE);
        mPaint.setTextSize(30);
        mPaint.setColor(Color.RED);//在init()中设置不好用
        canvas.drawText("X", width - 20, centerY, mPaint);
        canvas.drawText("Y", width / 2, 25, mPaint);
        canvas.drawLine(0, centerY, width, centerY, mPaint);//在屏幕中心绘制x轴
        canvas.drawLine(width / 2, 0, width / 2, height, mPaint);//绘制Y轴

        boolean startFlag = true;
        int preX = 0;
        int preY = 0;
        int y;
        while (x < width) {
            mPaint.setColor(Color.BLUE);
            mPaint.setStrokeWidth(5);
            double rad = degreeToRad(x);//角度转换成弧度
            y = (int) (centerY - Math.sin(rad) * 100);

            mPath.moveTo(preX, preY);
//        mPath.moveTo(x, y);
//            canvas.drawPoint(x, y, mPaint);
            mPath.lineTo(x, y);
            canvas.drawPath(mPath, mPaint);

            preX = x;
            preY = y;

            x = x + 5;
//            x = x + 1;
        }
    }

    /**
     * 角度转换成弧度
     *
     * @param degree
     * @return
     */
    private double degreeToRad(double degree) {
        return degree * Math.PI / 180;
    }

}
