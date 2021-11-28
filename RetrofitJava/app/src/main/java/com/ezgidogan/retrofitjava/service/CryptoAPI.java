package com.ezgidogan.retrofitjava.service;

import com.ezgidogan.retrofitjava.model.CryptoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {

    //GET, POST, UPDATE, DELETE

    @GET("prices?key=253f32b48d72b33d6cf36dc27de14ebc")
    Call<List<CryptoModel>> getData ();
}
