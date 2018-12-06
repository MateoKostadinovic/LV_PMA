package com.example.mateokosta.myapplication;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mateokosta.myapplication.adapter.FragmentViewPagerAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateNewRecordActivity extends AppCompatActivity {

    ViewPager viewPager;
    private ArrayList<Studenti> list = new ArrayList<>();
    public Studenti oStudent;
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
        Button button = findViewById(R.id.btnKraj);;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateNewRecordActivity.this, MainMainActivity.class);
                list = (ArrayList<Studenti>) intent.getSerializableExtra("list");
                intent.putExtra("student", (Serializable) oStudent);
                startActivity(intent);

            }
        });
    }
}
