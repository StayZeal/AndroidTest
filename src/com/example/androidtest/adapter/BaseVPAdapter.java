package com.example.androidtest.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.androidtest.fragment.RecycleFragment;

import java.util.List;

/**
 * Created by yangfeng on 2016/8/24.
 */
public class BaseVPAdapter<T> extends FragmentStatePagerAdapter {

    private List<T> datalist;


    public BaseVPAdapter(FragmentManager fm, List<T> datalist) {
        super(fm);
        this.datalist = datalist;
    }


    @Override
    public Fragment getItem(int position) {
        return RecycleFragment.newInstance("", "");
//        return MyListFrag.newInstance();
    }

    @Override
    public int getCount() {
        return 1;
    }

}
