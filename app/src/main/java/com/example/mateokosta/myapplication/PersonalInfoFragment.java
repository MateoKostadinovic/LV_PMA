package com.example.mateokosta.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PersonalInfoFragment extends Fragment {

   static PersonalInfoFragment newInstance(String firstName, String lastName)
   {
       /*omogucuje da se ne otvori fragment bez parametara firstName i lastName*/
       PersonalInfoFragment fragment = new PersonalInfoFragment();

       Bundle extras=new Bundle();
       extras.putString("firstName",firstName);
       extras.putString("lastName",lastName);
       fragment.setArguments(extras);
       return fragment;
   }

   TextInputLayout tilName;
   TextInputLayout tilLastName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view=inflater.inflate(R.layout.activity_main,container,false);
        tilName=view.findViewById(R.id.edittextIme);
        tilLastName=view.findViewById(R.id.edittextPrezime);
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
