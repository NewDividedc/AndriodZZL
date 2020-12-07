package com.example.design2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.design2.MovieDic.movie
import com.example.design2.MovieDic.movieListAdapter
import kotlinx.android.synthetic.main.fragment2_layout.*

class fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView=inflater.inflate(R.layout.fragment2_layout, container, false)
        initMovie()
        val movieRecycler=rootView.findViewById<RecyclerView>(R.id.movie_recyclerView)
        movieRecycler.layoutManager=LinearLayoutManager(activity)
        val adapter= movieListAdapter(movieList)
        movieRecycler.adapter=adapter
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        searchMoviewInput.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(!"".equals(s.toString())){
                    search_delete.visibility=View.VISIBLE
                }
                else{
                    search_delete.visibility=View.GONE
                }
            }
        })

        search_delete.setOnClickListener {
            searchMoviewInput.setText("")
            search_delete.visibility=View.GONE
        }
    }

    private val movieList=ArrayList<movie>()
    private fun initMovie(){
        movieList.add(
            movie(
                "肖申克的救赎",
                9.7,
                "弗兰克·德拉邦特",
                " 蒂姆·罗宾斯/摩根·弗里曼/鲍勃·冈顿",
                1994,
                R.drawable.first
            )
        )
        movieList.add(
            movie(
                "霸王别姬",
                9.6,
                "陈凯歌",
                "张国荣/张丰毅/巩俐",
                1993,
                R.drawable.second
            )
        )
        movieList.add(
            movie(
                "阿甘正传",
                9.5,
                "罗伯特·泽米吉斯",
                "汤姆·汉克斯/罗宾·怀特/加里·西尼斯",
                1994,
                R.drawable.third
            )
        )
        movieList.add(
            movie(
                "这个杀手不太冷",
                9.4,
                "吕克·贝松",
                "让·雷诺/娜塔莉·波特曼/加里·奥德曼",
                1994,
                R.drawable.fourth
            )
        )
        movieList.add(
            movie(
                "泰坦尼克号",
                9.4,
                "詹姆斯·卡梅隆",
                "莱昂纳多·迪卡普里奥/凯特·温丝莱特/比利·赞恩",
                1997,
                R.drawable.fifth
            )
        )
    }

}