package com.example.mateokosta.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FragmentViewPagerAdapter  extends FragmentStatePagerAdapter {
    public FragmentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0)
        {
            return PersonalInfoFragment.newInstance("","");
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
