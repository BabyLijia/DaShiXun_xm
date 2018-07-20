package com.example.asus.jouyuejiache_dashixun1.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mlist;
    private List<String> mstrings;
    private Context context;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> mlist, List<String> mstrings, Context context) {
        super(fm);
        this.mlist = mlist;
        this.mstrings = mstrings;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mstrings.get(position);
    }
}
