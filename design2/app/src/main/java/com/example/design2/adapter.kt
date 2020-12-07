package com.example.design2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class adapter(private val textList: ArrayList<String>) : RecyclerView.Adapter<adapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = textList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val textpos = textList[position]
        holder.title.text = textpos
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${holder.title.text}", Toast.LENGTH_SHORT)
                .show()
        }
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.mine_title)
    }
}