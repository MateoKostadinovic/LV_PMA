package com.example.mateokosta.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mateokosta.myapplication.R;

public class StudentInfoFragment extends Fragment {
    public static StudentInfoFragment newInstance() {

        Bundle args = new Bundle();

        StudentInfoFragment fragment = new StudentInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }
    EditText etSubject;
    EditText etTeacher;
    EditText etAkGod;
    EditText etBrojSati;
    EditText etBrojSatiLv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_student_info,container,false);
        etSubject=view.findViewById(R.id.edittextPredmet);
        etTeacher=view.findViewById(R.id.edittextProfesor);
        etAkGod=view.findViewById(R.id.edittextAkademskaGodina);
        etBrojSati=view.findViewById(R.id.edittextBrojSati);
        etBrojSatiLv=view.findViewById(R.id.edittextBrojSatiLV);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
