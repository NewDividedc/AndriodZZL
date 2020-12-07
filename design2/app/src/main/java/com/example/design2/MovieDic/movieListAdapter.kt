package com.example.design2.MovieDic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.design2.R

class movieListAdapter(val movieList:List<movie>):RecyclerView.Adapter<movieListAdapter.movieViewHolder>() {
    inner class movieViewHolder(view: View):RecyclerView.ViewHolder(view){
        val movieTitle:TextView=view.findViewById(R.id.tv_movie_title)
        val movieRating:TextView=view.findViewById(R.id.tv_rating)
        val movieDirector:TextView=view.findViewById(R.id.tv_directors)
        val movieCast:TextView=view.findViewById(R.id.tv_casts)
        val movieYear:TextView=view.findViewById(R.id.tv_year)
        val movieImage:ImageView=view.findViewById(R.id.image_movie)
        val movieRatingStar:RatingBar=view.findViewById(R.id.rating_bar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movieViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
        val viewHolder=movieViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: movieViewHolder, position: Int) {
        val movieItem=movieList[position]
        holder.movieTitle.setText(movieItem.title)
        holder.movieRating.setText(movieItem.rating.toString())
        holder.movieDirector.setText("导演："+movieItem.directer)
        holder.movieCast.setText("主演："+movieItem.casts)
        holder.movieYear.setText("年份："+movieItem.year.toString())
        holder.movieImage.setImageResource(movieItem.imageID)
        holder.movieRatingStar.rating= (movieItem.rating/2).toFloat()
    }

    override fun getItemCount() = movieList.size
}