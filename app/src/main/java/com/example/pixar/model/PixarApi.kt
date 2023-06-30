package com.example.pixar.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixarApi {

    @GET("/api/")
    fun getImage(
        @Query("q") key: String,
        @Query("page") page:Int = 1,
        @Query("per_page") perPage:Int = 3,
        @Query("key") keyFinal:String = "37464586-9ec8a240d2f6c7fdf40103786"
    ):Call<PixarModel>

}