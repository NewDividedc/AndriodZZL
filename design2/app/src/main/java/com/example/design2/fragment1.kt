package com.example.design2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class fragment1 : Fragment() {

    private val textList = arrayListOf("我的关注","通知开关", "我的徽章", "意见反馈", "我要投稿",
        "我的关注","通知开关", "我的徽章", "意见反馈", "我要投稿",
        "我的关注","通知开关","我的徽章","意见反馈","我要投稿")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment1_layout, container, false)
        val recyclerView_1=rootView.findViewById<RecyclerView>(R.id.recyclerView1)
        recyclerView_1.layoutManager = LinearLayoutManager(activity)
        val adapter = adapter(textList)
        recyclerView_1.adapter = adapter
        return rootView
    }

}
