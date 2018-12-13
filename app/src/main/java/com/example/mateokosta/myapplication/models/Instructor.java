package com.example.mateokosta.myapplication.models;

import android.support.annotation.NonNull;


public class Instructor {
    String bio;
    String image;
    String name;

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {

        return bio;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
    @NonNull

    public String toDo()
    {
        //return "Ime: "+ name.toString() + "\n";
        return name;
    }
}
