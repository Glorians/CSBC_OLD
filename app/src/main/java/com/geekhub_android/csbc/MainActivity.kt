package com.geekhub_android.csbc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.geekhub_android.csbc.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewPager2WithFragments()
    }



    private fun initViewPager2WithFragments() {

        var viewPager: ViewPager2 = findViewById(R.id.viewpager)
        var adapter = ExampleStateAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter=adapter

        var tabLayout:TabLayout = findViewById(R.id.tablayout)
        var names:ArrayList<String> = arrayListOf("Понеділок","Вівторок","Середа","Четвер","Пятниця","Субота")
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = names[position]
        }.attach()

    }



}