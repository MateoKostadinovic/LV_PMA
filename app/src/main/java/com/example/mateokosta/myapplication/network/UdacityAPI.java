package com.example.mateokosta.myapplication.network;

import com.example.mateokosta.myapplication.models.CoursesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UdacityAPI {
    @GET("/public-api/v0/courses")
    Call<CoursesResponse> getCourses();
}
