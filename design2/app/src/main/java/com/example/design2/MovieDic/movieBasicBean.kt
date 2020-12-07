package com.example.design2.MovieDic

import java.util.ArrayList

class movieBasicBean(val id:String,
                     val originalName: String,
                     val imdbVotes: Int,
                     val imdbRating: Double,
                     val rottenVotes: Int,
                     val rottenRating: Int,
                     val doubanId: Int,
                     val imdbId: String,
                     val alias: String,
                     val doubanVotes: Int,
                     val doubanRating: Double,
                     val year: Int,
                     val type: String,
                     val duration: Int,
                     val dateReleased: String,
                     val data: ArrayList<movieSpe>,
                     val director: ArrayList<peopleData>,
                     val actor: ArrayList<peopleData>,
                     val writer: ArrayList<peopleData>
)