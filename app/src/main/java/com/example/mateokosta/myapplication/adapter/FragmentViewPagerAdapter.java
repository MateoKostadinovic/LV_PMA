package com.example.mateokosta.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.mateokosta.myapplication.fragments.PersonalInfoFragment;
import com.example.mateokosta.myapplication.fragments.StudentInfoFragment;
import com.example.mateokosta.myapplication.fragments.SummaryFragment;

import java.util.List;

public class FragmentViewPagerAdapter  extends FragmentPagerAdapter {
    List<Integer> dataList;
    public FragmentViewPagerAdapter(FragmentManager fm, List<Integer> dataList) {
        super(fm);
        this.dataList=dataList;
    }

    @Override
    public Fragment getItem(int position) {
        int dataType = dataList.get(position);

        if(dataType == 1)
        {
            return PersonalInfoFragment.newInstance();
        }
        else if (dataType == 2)
        {
            return StudentInfoFragment.newInstance();
        }
        else
        {
            return SummaryFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return dataList.size();
    }
}
