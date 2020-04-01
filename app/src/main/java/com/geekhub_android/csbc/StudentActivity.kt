package com.geekhub_android.csbc

import ViewPager2.ExampleStateAdapter
import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.MenuItemCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

class StudentActivity : AppCompatActivity()  , NavigationView.OnNavigationItemSelectedListener{
    private val cont = this

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        initViewPager2WithFragments(cont)


        //menu Navigation Drawer
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_teacher -> {
                Toast.makeText(this, "Teacher clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_student -> {
                Toast.makeText(this, "Student clicked", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true


    }



    @TargetApi(Build.VERSION_CODES.O)
    private fun initViewPager2WithFragments(context: Context) {
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main, menu)
        val item = menu!!.findItem(R.id.spinner)
        val spinner = MenuItemCompat.getActionView(item) as Spinner
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.spinner_list_item_array, R.layout.support_simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)

        spinner.adapter = adapter
        return true
    }



}
