package com.example.a13218.demo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mfragments;
    private List<String> mTitles;
    public FragmentAdapter(FragmentManager fm,List<Fragment> fragments,List<String> titles){
        super(fm);
        mfragments=fragments;
        mTitles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mfragments.get(position);
    }

    @Override
    public int getCount() {
        return mfragments.size();
    }

    public CharSequence getPageTitle(int position){
        return mTitles.get(position);
    }
}
