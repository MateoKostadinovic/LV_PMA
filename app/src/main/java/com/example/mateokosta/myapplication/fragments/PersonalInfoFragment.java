package com.example.mateokosta.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mateokosta.myapplication.R;

public class PersonalInfoFragment extends Fragment {

   public static PersonalInfoFragment newInstance()
   {
       /*omogucuje da se ne otvori fragment bez parametara firstName i lastName*/
       Bundle args = new Bundle();

       PersonalInfoFragment fragment = new PersonalInfoFragment();
       fragment.setArguments(args);
       return fragment;
   }

   EditText etName;
   EditText etSurname;
   EditText etDatumRodenja;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_personal_info,container,false);
        etName=view.findViewById(R.id.etName);
        etSurname=view.findViewById(R.id.etSurname);
        etDatumRodenja=view.findViewById(R.id.etDatumRodenja);
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
