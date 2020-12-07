package com.example.design2.MovieDic

import android.util.Log
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//未解决网络请求延时问题
class MovieConnctor(val movieId:Int,var msg :movieBasicBean?) {

    fun SendMessage() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://movie.querydata.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val appService = retrofit.create(MovieAPI::class.java)
        appService.getMessageByGet(1292052)
            .enqueue(object : retrofit2.Callback<movieBasicBean> {
                override fun onResponse(call: Call<movieBasicBean>, response: Response<movieBasicBean>) {
                    Log.d("Retrofit", response.body().toString())
                    msg = response.body()
                }
                override fun onFailure(call: Call<movieBasicBean>, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }
}