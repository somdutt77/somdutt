package com.example.api.API;


import com.example.api.Model.Login.LoginExample;
import com.example.api.Model.ModelApi;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API {
    @POST("users/login")
    @FormUrlEncoded
    Call<ModelApi> call(
            @Field("email") String email,
            @Field("password") String name
    );


    @POST("users/login")
    Call<LoginExample> LOGINapI(@Body JsonObject jsonObject);
}
