package com.example.mateokosta.myapplication.models;

import java.util.ArrayList;


public class CoursesResponse
{
    private ArrayList<Course> courses;

    public void setCourses(ArrayList<Course> courses)
    {
        this.courses = courses;
    }

    public ArrayList<Course> getCourses()
    {
        return courses;
    }
}
