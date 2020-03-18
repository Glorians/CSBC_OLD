package com.geekhub_android.csbc

<<<<<<< HEAD
import android.content.ContentValues
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.geekhub_android.csbc.DBHelper.FeedEntry
import com.geekhub_android.csbc.DBHelper.ReaderDBHelper
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
=======

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

>>>>>>> master


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

<<<<<<< HEAD
        initViewPager2WithFragments()
        dbWork()
    }

    private fun initViewPager2WithFragments() {
        val viewPager: ViewPager2 = findViewById(R.id.viewpager)
        val adapter = ExampleStateAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter=adapter
        val tabLayout:TabLayout = findViewById(R.id.tablayout)
        val names:ArrayList<String> = arrayListOf("Понеділок","Вівторок","Середа","Четвер","Пятниця","Субота")
        val b = Bundle()
        b.putString("tabID", "1")
=======
        initViewPager2WithFragments(this)
    }

    private fun initViewPager2WithFragments(context: Context) {
        val viewPager: ViewPager2 = findViewById(R.id.viewpager)
        val adapter = ExampleStateAdapter(supportFragmentManager, lifecycle, this)
        viewPager.adapter=adapter
        val tabLayout:TabLayout = findViewById(R.id.tablayout)
        val names:ArrayList<String> = arrayListOf("Понеділок","Вівторок","Середа","Четвер","Пятниця","Субота")
>>>>>>> master
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = names[position]
        }.attach()

    }

    private fun dbWork () {
        val dbHelper = ReaderDBHelper(this)
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(FeedEntry.COLUMN_PARITY, 1)
            put(FeedEntry.COLUMN_NAME, "Програмирование")
            put(FeedEntry.COLUMN_CLASSROOM, 216)
            put(FeedEntry.COLUMN_NUMBER, 4)
            put(FeedEntry.COLUMN_TEACHER, "Стасик")
            put(FeedEntry.COLUMN_TYPE, "Лекция")
            put(FeedEntry.COLUMN_DAY, 1)
        }

        val newRowId = db?.insert(FeedEntry.TABLE_NAME, null, values)
    }


}


