package com.geekhub_android.csbc

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listGroup = mutableListOf<Group>()
        val listSubject = mutableListOf<Subject>()
        val listTeacher = mutableListOf<Teacher>()


        val group1 = Group("2P-16", listSubject)
        val subject1 = Subject("Network", 216, "13:10")
        val teacher1 = Teacher("Alex", listGroup, listSubject)



        listGroup.add(group1)
        listSubject.add(subject1)
        listTeacher.add(teacher1)


        val name = findViewById<TextView>(R.id.name)
        val info1 = findViewById<TextView>(R.id.info1)
        val info2 = findViewById<TextView>(R.id.info2)

        name.text = teacher1.name
        info1.text = teacher1.listSubject.toString()
        info2.text = teacher1.listGroup.toString()


        Log.d("TEST", name.toString())







    }

}
