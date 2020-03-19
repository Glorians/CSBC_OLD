package com.geekhub_android.csbc

import android.annotation.TargetApi
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

import java.text.SimpleDateFormat

import java.util.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewPager2WithFragments()
    }



    @TargetApi(Build.VERSION_CODES.O)
    private fun initViewPager2WithFragments() {

        var viewPager: ViewPager2 = findViewById(R.id.viewpager)
        var adapter = ExampleStateAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter=adapter

        var tabLayout:TabLayout = findViewById(R.id.tablayout)
        var names = mutableListOf<String>("Today")

        val instance = Calendar.getInstance()
        fun splitData (data: String): String {
            var result = ""
            val list = data.split(" ")
            for (i in 0..2) {
                result += list[i] + " "
            }
            return result
        }

        for (i in 1..6) {
            instance.add(Calendar.DAY_OF_WEEK, 1)


            names.add(splitData( instance.time.toString()))
                }


        TabLayoutMediator(tabLayout, viewPager) { tab, position ->

            tab.text = names[position]
        }.attach()

    }



}