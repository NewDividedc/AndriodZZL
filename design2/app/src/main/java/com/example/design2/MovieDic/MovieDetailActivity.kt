package com.example.design2.MovieDic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.design2.Adapter.MovieDBHelper
import com.example.design2.R
import kotlinx.android.synthetic.main.movie_spe.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.security.auth.callback.Callback

//电影详情页的activity
class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_spe)
        SendMessage(1291549)
    }

    fun SendMessage(id:Int) {

        //直接在activity中请求网络
        val retrofit = Retrofit.Builder()
            .baseUrl("https://movie.querydata.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val appService = retrofit.create(MovieAPI::class.java)
        appService.getMessageByGet(1292052)
            .enqueue(object : retrofit2.Callback<movieBasicBean> {
                override fun onResponse(call: Call<movieBasicBean>, response: Response<movieBasicBean>) {
                    Log.d("Retrofit", response.body().toString())
                    val msg = response.body()
                    if(msg != null){
                        Glide.with(this@MovieDetailActivity).load(msg.data[0].poster).into(moviePic)
                        name.setText(msg.data[0].name)
                        type.setText(msg.data[0].genre+" | "+
                                msg.data[0].country+" | "+
                                (msg.duration/60).toInt().toString()+"分钟 | "
                                +msg.year.toString()+"年")
                        brief.setText(msg.data[0].description)
                        chName.setText(msg.data[0].name)
                        oriName.setText(msg.originalName)
                        othName.setText(msg.alias)
                        proTime.setText(msg.year.toString())
                        country.setText(msg.data[0].country)
                        genre.setText(msg.data[0].genre)
                        duration.setText((msg.duration/60).toInt().toString()+"分钟")
                        dataReleased.setText(msg.dateReleased.toString().subSequence(0,10))
                        language.setText(msg.data[0].language)
                        director.setText(msg.director[0].data[0].name)
                        actor.setText(msg.actor[0].data[0].name+","+msg.actor[1].data[0].name+","+msg.actor[2].data[0].name+","+msg.actor[3].data[0].name+","+msg.actor[4].data[0].name)
                        imbdID.setText(msg.imdbId.toString())
                        imbdRating.setText(msg.imdbRating.toString())
                    }
                }
                override fun onFailure(call: Call<movieBasicBean>, t: Throwable) {
                    t.printStackTrace()
                }
            })
        /*val Moviepro= MovieProce(id,  this)
        val msg=Moviepro.findMsg()

        if(msg != null){
            Glide.with(this@MovieDetailActivity).load(msg.poster).into(moviePic)
            name.setText(msg.chName)
            val typeText =msg.genre+" | "+
                    msg.country+" | "+
                    msg.duration
            type.setText(typeText)
            brief.setText(msg.intro)
            chName.setText(msg.chName)
            oriName.setText(msg.oriName)
            othName.setText(msg.othName)
            proTime.setText(msg.proTime)
            country.setText(msg.country)
            genre.setText(msg.genre)
            duration.setText(msg.duration)
            dataReleased.setText(msg.dateReleased)
            language.setText(msg.language)
            director.setText(msg.director)
            actor.setText(msg.actor)
            imbdID.setText(msg.imdbID)
            imbdRating.setText(msg.imdbRating)
        }*/
        /*val Moviepro= MovieProce(id, this)
        val msg=Moviepro.findMsg()
        if(msg != null) {
            Glide.with(this@MovieDetailActivity).load(msg.data[0].poster).into(moviePic)
            name.setText(msg.data[0].name)
            type.setText(
                msg.data[0].genre + " | " +
                        msg.data[0].country + " | " +
                        (msg.duration / 60).toInt().toString() + "分钟 | "
                        + msg.year.toString() + "年"
            )
            brief.setText(msg.data[0].description)
            chName.setText(msg.data[0].name)
            oriName.setText(msg.originalName)
            othName.setText(msg.alias)
            proTime.setText(msg.year.toString())
            country.setText(msg.data[0].country)
            genre.setText(msg.data[0].genre)
            duration.setText((msg.duration / 60).toInt().toString() + "分钟")
            dataReleased.setText(msg.dateReleased.toString().subSequence(0, 10))
            language.setText(msg.data[0].language)
            director.setText(msg.director[0].data[0].name)
            actor.setText(msg.actor[0].data[0].name + "," + msg.actor[1].data[0].name + "," + msg.actor[2].data[0].name + "," + msg.actor[3].data[0].name + "," + msg.actor[4].data[0].name)
            imbdID.setText(msg.imdbId.toString())
            imbdRating.setText(msg.imdbRating.toString())
        }*/

    }
}