package com.example.design2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment1_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(fragment1())

        bnv.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.id1->{
                    replaceFragment(fragment1())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.id2->{
                    replaceFragment(fragment2())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.id3->{
                    replaceFragment(fragment3())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frag,fragment)
        transaction.commit()
        transaction.addToBackStack(null)
    }
}
