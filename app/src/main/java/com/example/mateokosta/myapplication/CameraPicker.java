package com.example.mateokosta.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.mateokosta.myapplication.fragments.CameraFragment;

public class CameraPicker extends AppCompatActivity {

    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_picker);

        frameLayout = findViewById(R.id.frameLayout);

        setupFragment();
    }

    private void setupFragment(){
        Fragment fragment = CameraFragment.newInstance(R.drawable.students);
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout,fragment)
                .commit();
    }
}
