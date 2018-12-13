package com.example.mateokosta.myapplication.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.mateokosta.myapplication.CameraPicker;
import com.example.mateokosta.myapplication.R;
import com.example.mateokosta.myapplication.listeners.PersonalInfoListener;

public class PersonalInfoFragment extends Fragment {
    private static final String EXTRA_IMAGE_ID = "EXTRA_IMAGE_ID";
    private static final int REQUEST_IMAGE_CAPTURE = 1;
   public static PersonalInfoFragment newInstance()
   {
       /*omogucuje da se ne otvori fragment bez parametara firstName i lastName*/
       Bundle args = new Bundle();

       PersonalInfoFragment fragment = new PersonalInfoFragment();
       fragment.setArguments(args);
       return fragment;
   }
   ImageView imageView;
   EditText etName;
   EditText etSurname;
   EditText etDatumRodenja;


    public PersonalInfoListener personalInfoListener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_personal_info,container,false);
        imageView=view.findViewById(R.id.imageView);

        Button button = view.findViewById(R.id.cameraButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CameraPicker.class);
                startActivityForResult(intent,1);

            }
        });

        etName=view.findViewById(R.id.etName);
        etSurname=view.findViewById(R.id.etSurname);
        etDatumRodenja=view.findViewById(R.id.etDatumRodenja);
        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (personalInfoListener != null) {
                    personalInfoListener.setName(s.toString());
                }

            }
        });
        etSurname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (personalInfoListener != null) {
                    personalInfoListener.setLastName(s.toString());
                }

            }
        });
        etDatumRodenja.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (personalInfoListener != null) {
                    personalInfoListener.setDate(s.toString());
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
        personalInfoListener=null;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            setupImageView(imageBitmap);
        }
    }
    private void setupImageView(Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }
}
