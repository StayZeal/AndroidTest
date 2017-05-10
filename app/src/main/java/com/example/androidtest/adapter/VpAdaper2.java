package com.example.androidtest.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.androidtest.fragment.LifeFragment;

import java.util.List;


public class VpAdaper2<T> extends BaseVPAdapter<T> {



    public VpAdaper2(FragmentManager fm, List<T> datalist) {
        super(fm, datalist);
    }

    @Override
    public Fragment getItem(int position) {
        return LifeFragment.newInstance("", "");
    }
}
