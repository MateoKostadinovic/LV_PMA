package com.example.mateokosta.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mateokosta.myapplication.R;
import com.example.mateokosta.myapplication.listeners.StudentInfoListener;
import com.example.mateokosta.myapplication.models.Course;
import com.example.mateokosta.myapplication.models.CoursesResponse;
import com.example.mateokosta.myapplication.models.Instructor;
import com.example.mateokosta.myapplication.network.RetrofitManager;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfoFragment extends Fragment implements Callback<CoursesResponse> , AdapterView.OnItemSelectedListener {
    public static StudentInfoFragment newInstance() {

        Bundle args = new Bundle();

        StudentInfoFragment fragment = new StudentInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    EditText etTeacher;
    EditText etAkGod;
    EditText etBrojSati;
    EditText etBrojSatiLv;
    TextView textView;

    ArrayList<String> subjects = new ArrayList<String>();
    ArrayList<String> teachers = new ArrayList<String>();
    public StudentInfoListener studentInfoListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_student_info,container,false);

        //textView=view.findViewById(R.id.textView);

        Call<CoursesResponse> callResponse = RetrofitManager.getInstance().getService().getCourses();
        callResponse.enqueue(this);

        // SPINNER PREDMETI
        // Spinner element
        Spinner spinner = view.findViewById(R.id.subject_spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        subjects.add("Predmeti");
        // Creating adapter for spinner
        final ArrayAdapter dataAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                subjects);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);



        // SPINNER PROFESORI
        // Spinner element
        Spinner sppiner_profesori = view.findViewById(R.id.teacher_spinner);

        // Spinner click listener
        sppiner_profesori.setOnItemSelectedListener(this);
        teachers.add("Profesori");
        // Creating adapter for spinner
        final ArrayAdapter profesoriAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                teachers);

        // Drop down layout style - list view with radio button
        profesoriAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        sppiner_profesori.setAdapter(profesoriAdapter);

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


    @Override
    public void onResponse(Call<CoursesResponse> call, Response<CoursesResponse> response)
    {
        String text;
        String text2;

        if (response.isSuccessful() && response.body()!=null)
        {
            text = response.body().getCourses().toString();
            text2 = response.body().getCourses().toString(); //ovdje pitat za objasnjenje
        }
        else
        {
            text = "Doslo je pogreske, podaci nisu dostupni." ;
            text2 = "Doslo je pogreske, podaci nisu dostupni." ;
        }
        setText(text);
        setTeacher(text2);
    }

    @Override
    public void onFailure(Call<CoursesResponse> call, Throwable t)
    {
        setText("Doslo je do greske: "+ t.getMessage());
    }
    void setText(String text)
    {
        text = text.substring(1);
        text = text.replaceFirst(".$","");
        String[] items = text.split(",");
        for (String item : items)
        {
            subjects.add(item);
            //teachers.add(item);
            //textView.setText(text);
        }
    }
    void setTeacher(String text2)
    {
        text2 = text2.substring(1);
        text2 = text2.replaceFirst(".$","");
        String[] items = text2.split(",");
        for (String item : items)
        {
            teachers.add(item);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();


        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        if (studentInfoListener != null) {
            studentInfoListener.setPredmet(item.toString());
        }
        if (studentInfoListener != null) {
            studentInfoListener.setProfesor(item.toString());
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
}
