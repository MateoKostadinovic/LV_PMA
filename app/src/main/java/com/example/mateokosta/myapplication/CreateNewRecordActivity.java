package com.example.mateokosta.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mateokosta.myapplication.adapter.FragmentViewPagerAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateNewRecordActivity extends AppCompatActivity {

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_record);
        viewPager = findViewById(R.id.viewPager);

        List<Integer> fragmentDataList=new ArrayList<>();
        fragmentDataList.add(1);
        fragmentDataList.add(2);
        fragmentDataList.add(3);

        Collections.sort(fragmentDataList);
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(getSupportFragmentManager(),fragmentDataList);
        viewPager.setAdapter(adapter);
    }
}
