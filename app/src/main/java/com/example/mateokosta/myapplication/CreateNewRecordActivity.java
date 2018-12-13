package com.example.mateokosta.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
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
    private static final String EXTRA_IMAGE_ID = "EXTRA_IMAGE_ID";
    private static final int REQUEST_IMAGE_CAPTURE = 1;
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

        Button button = findViewById(R.id.btnKraj);
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
    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            setupImageView(imageBitmap);
        }
    }
    private void setupImageView(Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }*/

}
