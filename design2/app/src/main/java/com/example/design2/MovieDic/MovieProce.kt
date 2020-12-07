package com.example.design2.MovieDic

import android.content.Context
import android.util.Log
import com.example.design2.Adapter.MovieDBHelper
//未解决网络请求延时问题
class MovieProce(val movieId:Int, val context:Context) {

    fun findMsg(): movieBasicBean?{

        var msg : MovieNeed ?=null
        /*val dbHelper= MovieDBHelper(
            context,
            "MovieSection.db",
            1
        )
        val db=dbHelper.writableDatabase
        val cursor = db.query("Movie",null,"id=?", arrayOf(movieId.toString()),null,null,null)

        if(cursor.moveToFirst()){
            val intro=cursor.getString(cursor.getColumnIndex("intro"))
            val poster=cursor.getString(cursor.getColumnIndex("poster"))
            val chName=cursor.getString(cursor.getColumnIndex("chName"))
            val oriName=cursor.getString(cursor.getColumnIndex("oriName"))
            val othName=cursor.getString(cursor.getColumnIndex("othName"))
            val proTime=cursor.getString(cursor.getColumnIndex("proTime"))
            val country=cursor.getString(cursor.getColumnIndex("country"))
            val genre=cursor.getString(cursor.getColumnIndex("genre"))
            val duration=cursor.getString(cursor.getColumnIndex("duration"))
            val dataReleased=cursor.getString(cursor.getColumnIndex("dataReleased"))
            val language=cursor.getString(cursor.getColumnIndex("language"))
            val director=cursor.getString(cursor.getColumnIndex("director"))
            val actor=cursor.getString(cursor.getColumnIndex("actor"))
            val imbdID=cursor.getString(cursor.getColumnIndex("imbdID"))
            val imbdRating=cursor.getString(cursor.getColumnIndex("imbdRating"))
            msg = MovieNeed(
                movieId,
                intro,
                poster,
                chName,
                oriName,
                othName,
                proTime,
                country,
                genre,
                duration,
                dataReleased,
                language,
                director,
                actor,
                imbdID,
                imbdRating
            )
        }
        else{*/
            val connct= MovieConnctor(movieId,null)
            //while(connct.msg==null){

            //}
            val msg1=connct.msg
            if (msg1!=null){
                val poster= msg1.data[0].poster
                val chName=msg1.data[0].name
                val intro=msg1.data[0].description
                val oriName=msg1.originalName
                val othName=msg1.alias
                val proTime=msg1.year.toString()
                val country=msg1.data[0].country
                val genre=msg1.data[0].genre
                val duration=(msg1.duration/60).toInt().toString()+"分钟"
                val dataReleased=msg1.dateReleased.toString().subSequence(0,10).toString()
                val language=msg1.data[0].language
                val director=msg1.director[0].data[0].name
                val actor = msg1.actor[0].data[0].name+","+
                        msg1.actor[1].data[0].name+","+
                        msg1.actor[2].data[0].name+","+
                        msg1.actor[3].data[0].name+","+
                        msg1.actor[4].data[0].name
                val imdbID=msg1.imdbId.toString()
                val imdbRating=msg1.imdbRating.toString()
                msg= MovieNeed(
                    movieId,
                    intro,
                    poster,
                    chName,
                    oriName,
                    othName,
                    proTime,
                    country,
                    genre,
                    duration,
                    dataReleased,
                    language,
                    director,
                    actor,
                    imdbID,
                    imdbRating
                )
                /*val v="insert into Movie values("+movieId+",'"+intro+"','"+poster+"','"+
                        chName+"','"+oriName+"','"+othName+"','"+proTime+"','"+country+"','"+
                        genre+"','"+duration+"','"+dataReleased+"','"+language+"','"+director+
                        "','"+actor+"','"+imdbID+"','"+imdbRating+"')"
                db.execSQL(v)*/
            }
            else{
                msg=null
            }
        if(msg1==null)
            Log.d("proces","failed")
        //}
        return msg1
    }
}
