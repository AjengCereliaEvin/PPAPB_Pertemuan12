package com.example.tugaspertemuan12.retrofit

import com.example.tugaspertemuan12.model.Data
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getAllFiction(): Call<List<Data>>
}