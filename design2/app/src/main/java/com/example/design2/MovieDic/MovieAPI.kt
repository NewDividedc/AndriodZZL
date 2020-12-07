package com.example.design2.MovieDic

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET("api")
    fun getMessageByGet(@Query("id")id:Int): Call<movieBasicBean>
}