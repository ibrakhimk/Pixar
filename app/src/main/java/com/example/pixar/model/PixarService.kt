package com.example.pixar.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PixarService {

    private var retrofit = Retrofit.Builder().baseUrl("https://pixabay.com")
        .addConverterFactory(GsonConverterFactory.create()).build()

    var apiPixar = retrofit.create(PixarApi::class.java)

}