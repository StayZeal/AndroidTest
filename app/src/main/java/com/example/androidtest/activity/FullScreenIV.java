package com.example.androidtest.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by yangfeng on 2016/4/6.
 */
public  class FullScreenIV extends ImageView implements
        View.OnSystemUiVisibilityChangeListener, View.OnClickListener,
        ActionBar.OnMenuVisibilityListener {
    Activity mActivity;
    TextView mTitleView;
    Button mPlayButton;
    SeekBar mSeekView;
    boolean mAddedMenuListener;
    boolean mMenusOpen;
    boolean mPaused;
    boolean mNavVisible;
    int mLastSystemUiVis;

    Runnable mNavHider = new Runnable() {
        @Override public void run() {
            setNavVisibility(false);
        }
    };

    public FullScreenIV(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnSystemUiVisibilityChangeListener(this);
        setOnClickListener(this);
    }

    public void init(Activity activity, TextView title, Button playButton,
                     SeekBar seek) {
        // This called by the containing activity to supply the surrounding
        // state of the video player that it will interact with.
        mActivity = activity;
        mTitleView = title;
        mPlayButton = playButton;
        mSeekView = seek;
        mPlayButton.setOnClickListener(this);
        setPlayPaused(true);
    }

    @Override protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mActivity != null) {
            mAddedMenuListener = true;
            mActivity.getActionBar().addOnMenuVisibilityListener(this);
        }
    }

    @Override protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mAddedMenuListener) {
            mActivity.getActionBar().removeOnMenuVisibilityListener(this);
        }
    }

    @Override public void onSystemUiVisibilityChange(int visibility) {
        // Detect when we go out of nav-hidden mode, to clear our state
        // back to having the full UI chrome up.  Only do this when
        // the state is changing and nav is no longer hidden.
        int diff = mLastSystemUiVis ^ visibility;
        mLastSystemUiVis = visibility;
        if ((diff&SYSTEM_UI_FLAG_HIDE_NAVIGATION) != 0
                && (visibility&SYSTEM_UI_FLAG_HIDE_NAVIGATION) == 0) {
            setNavVisibility(true);
        }
    }

    @Override protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);

        // When we become visible or invisible, play is paused.
        setPlayPaused(true);
    }

    @Override public void onClick(View v) {
        if (v == mPlayButton) {
            // Clicking on the play/pause button toggles its state.
            setPlayPaused(!mPaused);
        } else {
            // Clicking elsewhere makes the navigation visible.
            setNavVisibility(true);
        }
    }

    @Override public void onMenuVisibilityChanged(boolean isVisible) {
        mMenusOpen = isVisible;
        setNavVisibility(true);
    }

    void setPlayPaused(boolean paused) {
        mPaused = paused;
        mPlayButton.setText(paused ? "播放" : "暂停");
        setKeepScreenOn(!paused);
        setNavVisibility(true);
    }

    void setNavVisibility(boolean visible) {
        int newVis = SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | SYSTEM_UI_FLAG_LAYOUT_STABLE;
        if (!visible) {
            newVis |= SYSTEM_UI_FLAG_LOW_PROFILE | SYSTEM_UI_FLAG_FULLSCREEN
                    | SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }

        // If we are now visible, schedule a timer for us to go invisible.
        if (visible) {
            Handler h = getHandler();
            if (h != null) {
                h.removeCallbacks(mNavHider);
                if (!mMenusOpen && !mPaused) {
                    // If the menus are open or play is paused, we will not auto-hide.
                    h.postDelayed(mNavHider, 3000);
                }
            }
        }

        // Set the new desired visibility.
        setSystemUiVisibility(newVis);
        mTitleView.setVisibility(visible ? VISIBLE : INVISIBLE);
        mPlayButton.setVisibility(visible ? VISIBLE : INVISIBLE);
        mSeekView.setVisibility(visible ? VISIBLE : INVISIBLE);
    }
}