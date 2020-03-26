package com.geekhub_android.csbc

import ViewPager2.ExampleStateAdapter
import android.annotation.TargetApi
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.viewpager2.widget.ViewPager2
import com.geekhub_android.csbc.Model.Subject
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue

import java.util.*



class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewPager2WithFragments()


//        val db = FirebaseFirestore.getInstance()
//        val groups: MutableMap<String, Any> = HashMap()
//        groups["name"] = "1П-16"
//        groups["subgroup"] = "A"
//
//        // Create a new user with a first and last name
//// Add a new document with a generated ID
//        db.collection("groups")
//            .add(groups)
//            .addOnSuccessListener { documentReference ->
//                Log.d(
//                    "TEST",
//                    "DocumentSnapshot added with ID: " + documentReference.id
//                )
//            }
//            .addOnFailureListener { e -> Log.w("TEST", "Error adding document", e) }


        val subjectListener = object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val subject = dataSnapshot.getValue<Subject>()
                Log.d("SUBJECT!!!!", subject.toString())
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("ERROR LEHA", "loadSubject:onCancelled", databaseError.toException())
            }
        }

    }


    @TargetApi(Build.VERSION_CODES.O)
    private fun initViewPager2WithFragments() {
        var viewPager: ViewPager2 = findViewById(R.id.viewpager)
        var adapter = ExampleStateAdapter(
            supportFragmentManager,
            lifecycle,
            this
        )
        viewPager.adapter = adapter

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




