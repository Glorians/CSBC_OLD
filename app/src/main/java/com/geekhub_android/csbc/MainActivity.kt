package com.geekhub_android.csbc


import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.geekhub_android.csbc.DBHelper.ReaderDBHelper
import com.geekhub_android.csbc.DBHelper.SubjectDB
import com.geekhub_android.csbc.Model.Subject
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewPager2WithFragments(this)

//        val db = FirebaseFirestore.getInstance()


        fun dbWork(context: Context) {
            val dbHelper = ReaderDBHelper(context)
            val db = dbHelper.writableDatabase

            val values = ContentValues().apply {
                put(SubjectDB.COLUMN_PARITY, 1)
                put(SubjectDB.COLUMN_NAME, "Програмирование")
                put(SubjectDB.COLUMN_CLASSROOM, 216)
                put(SubjectDB.COLUMN_NUMBER, 4)
                put(SubjectDB.COLUMN_TEACHER, "Стасик")
                put(SubjectDB.COLUMN_TYPE, "Лекция")
                put(SubjectDB.COLUMN_DAY, 1)
            }

            val newRowId = db?.insert(SubjectDB.TABLE_NAME, null, values)
        }
//        dbWork(this)

        fun dbDelete(context: Context) {
            val dbHelper = ReaderDBHelper(context)
            val db = dbHelper.writableDatabase

            dbHelper.onDowngrade(db, 1, 2)

        }




//        val groups: MutableMap<String, Any> = HashMap()
//        groups["name"] = "1П-16"
//        groups["subgroup"] = "A"

        // Create a new user with a first and last name


// Add a new document with a generated ID
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

//        database.addValueEventListener(subjectListener)


    }

    override fun onStart() {
        super.onStart()

    }


    private fun writeNewSubject(
        id: Long,
        parity: Int,
        name: String,
        classroom: Int,
        number: Int,
        teacher: String,
        type: String,
        day: Int){

//        val subject = Subject(id, parity, name, classroom, number, teacher, type, day)
//        database.child("subject").child(id.toString()).setValue(subject)
    }


    private fun initViewPager2WithFragments(context: Context) {
        val viewPager: ViewPager2 = findViewById(R.id.viewpager)
        val adapter = ExampleStateAdapter(supportFragmentManager, lifecycle, this)
        viewPager.adapter=adapter
        val tabLayout:TabLayout = findViewById(R.id.tablayout)
        val names:ArrayList<String> = arrayListOf("Понеділок","Вівторок","Середа","Четвер","Пятниця","Субота")
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = names[position]
        }.attach()

    }


}




