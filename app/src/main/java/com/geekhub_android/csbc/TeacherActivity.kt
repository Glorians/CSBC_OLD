package com.geekhub_android.csbc

import com.geekhub_android.csbc.ViewPager2.ExampleStateAdapter
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

class TeacherActivity : AppCompatActivity() {
  private val cont = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)
        initViewPager2WithFragments(cont)
    }


@TargetApi(Build.VERSION_CODES.O)
private fun initViewPager2WithFragments(context:Context) {
    var viewPager: ViewPager2 = findViewById(R.id.viewpager)
    var adapter = ExampleStateAdapter(
        supportFragmentManager,
        lifecycle,context
    )
    viewPager.adapter = adapter

    var tabLayout: TabLayout = findViewById(R.id.tablayout)
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