package com.example.mateokosta.myapplication.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mateokosta.myapplication.R;

public class CameraFragment extends Fragment {
    private static final String EXTRA_IMAGE_ID = "EXTRA_IMAGE_ID";
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    /**
     * Primjer kako postaviti Fragment koji zahtjeve parametre za rad.
     * @param imageResourceId
     * @return
     */
    public static CameraFragment newInstance(int imageResourceId) {
        Bundle args = new Bundle();
        args.putInt(EXTRA_IMAGE_ID, imageResourceId);
        CameraFragment fragment = new CameraFragment();
        fragment.setArguments(args);
        return fragment;
    }

    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_camera_layout,container,false);
        imageView = view.findViewById(R.id.imageView);

        Button button = view.findViewById(R.id.buttonOpenCamera);
        button.setOnClickListener(onCameraButtonClickListener);
        /**
         * Primjer korištenja poslanih parametra.
         */
        Bundle bundle = getArguments();

        if(bundle != null){
            setupImageView(bundle.getInt(EXTRA_IMAGE_ID));
        }

        return view;
    }

    /**
     * Funkcija koja će biti pozvana od strane Androida kada korisnik završi sa Fotoaparatom.
     * @param requestCode
     * @param resultCode
     * @param data
     */

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ( requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            setupImageView(imageBitmap);
        }
    }

    private void setupImageView(int drawableId){
        imageView.setImageResource(drawableId);
    }

    private void setupImageView(Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }

    View.OnClickListener  onCameraButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE); }
        }
    };

}
