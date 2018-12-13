package com.example.mateokosta.myapplication.models;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;

public class Course {
    ArrayList<Instructor> instructors;
    String subtitle;
    String image;
    String title;
    boolean featured;

    public void setInstructors(ArrayList<Instructor> instructors) {
        this.instructors = instructors;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public ArrayList<Instructor> getInstructors() {

        return instructors;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public boolean isFeatured() {
        return featured;
    }

    @NonNull
    @Override
    public String toString() {
        //return "Instruktori: "+ instructors.toString() + "\n" +"naslov: " +title + "\n";
        return title;
    }
}
