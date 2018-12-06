package com.example.mateokosta.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mateokosta.myapplication.R;
import com.example.mateokosta.myapplication.listeners.StudentInfoListener;

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
    String sMirko="Mirko";
    public StudentInfoListener studentInfoListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_student_info,container,false);
        etSubject=view.findViewById(R.id.edittextPredmet);
        etSubject.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (studentInfoListener != null) {
                    studentInfoListener.setPredmet(s.toString());
                }

            }
        });
        etTeacher=view.findViewById(R.id.edittextProfesor);
        etTeacher.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (studentInfoListener != null) {
                    studentInfoListener.setProfesor(s.toString());
                }

            }
        });
        etAkGod=view.findViewById(R.id.edittextAkademskaGodina);
        etAkGod.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (studentInfoListener != null) {
                    studentInfoListener.setAkGodina(s.toString());
                }

            }
        });
        etBrojSati=view.findViewById(R.id.edittextBrojSati);
        etBrojSati.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (studentInfoListener != null) {
                    studentInfoListener.setBrojSati(s.toString());
                }

            }
        });
        etBrojSatiLv=view.findViewById(R.id.edittextBrojSatiLV);
        etBrojSatiLv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (studentInfoListener != null) {
                    studentInfoListener.setBrojSatiLv(s.toString());
                }

            }
        });
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
        studentInfoListener=null;
    }
}
