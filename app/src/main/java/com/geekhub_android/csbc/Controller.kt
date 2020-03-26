package com.geekhub_android.csbc

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.geekhub_android.csbc.DBHelper.ReaderDBHelper
import com.geekhub_android.csbc.DBHelper.SubjectDB
import com.geekhub_android.csbc.Model.Subject
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import com.google.firebase.firestore.FirebaseFirestore
import java.util.HashMap


class Controller () {

    fun work () {
        val db = FirebaseFirestore.getInstance()
        val groups: MutableMap<String, Any> = HashMap()
        groups["name"] = "1П-16"
        groups["subgroup"] = "A"

        // Create a new user with a first and last name
// Add a new document with a generated ID

    }

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

    fun dbDelete(context: Context) {
        val dbHelper = ReaderDBHelper(context)
        val db = dbHelper.writableDatabase

        dbHelper.onDowngrade(db, 1, 2)

    }

    fun db1 () {
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
    }


//        dbWork(this)
}