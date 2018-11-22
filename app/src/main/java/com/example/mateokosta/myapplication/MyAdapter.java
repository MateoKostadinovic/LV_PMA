package com.example.mateokosta.myapplication;


import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "MyAdapter";

    private ArrayList<Studenti> dataList = new ArrayList<>();

    public MyAdapter(ArrayList<Studenti> myDataset)
    {
        dataList=myDataset;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType)
    {
        // create a new view
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_layout, viewGroup, false);
        StudentViewHolder oStudent = new StudentViewHolder(view);
        return oStudent;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position)
    {
        Log.d(TAG, "onBindViewHolder: called.");

        StudentViewHolder myStudentHolder = (StudentViewHolder) viewHolder;
        Studenti student = (Studenti)(dataList.get(position));
        myStudentHolder.StudentiPrezime.setText(student.getPrezime());
        myStudentHolder.StudentiIme.setText(student.getIme());
    }

    @Override
    public int getItemCount()
    {
        return dataList.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    /*public static class NaslovViewHolder extends RecyclerView.ViewHolder {
        public TextView NaslovTextView;
        ConstraintLayout headerLayout;
        public NaslovViewHolder(@NonNull View itemView) {
            super(itemView);
            NaslovTextView = itemView.findViewById(R.id.textviewStudentiNaslov);
            headerLayout = itemView.findViewById(R.id.header_layout);
        }
    }*/
    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView StudentiIme;
        public TextView StudentiPrezime;
        ConstraintLayout studentLayout;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            StudentiIme = itemView.findViewById(R.id.textviewStudentiIme);
            StudentiPrezime = itemView.findViewById(R.id.textviewStudentiPrezime);
            studentLayout = itemView.findViewById(R.id.student_layout);
        }
    }
}
