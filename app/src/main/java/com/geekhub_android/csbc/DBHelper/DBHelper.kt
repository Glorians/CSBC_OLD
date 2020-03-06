package com.geekhub_android.csbc.DBHelper

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.geekhub_android.csbc.Model.Subject

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY: String =
            ("CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY, $COL_NAME TEXT, " +
                    "$COL_CLASSROOM INTEGER PRIMARY KEY, $COL_TIME TEXT, $COL_TEACHER TEXT, $COL_TYPE TEXT)")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    //CRUD
    val allSubject: List<Subject>
        @SuppressLint("Recycle")
        get() {
            val lstSubject = ArrayList<Subject>()
            val selectQuery = "SELECT * FROM $TABLE_NAME"
            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)
            if (cursor.moveToFirst()) {
                do {
                    val subject = Subject(
                        cursor.getInt(cursor.getColumnIndex(COL_ID)),
                        cursor.getString(cursor.getColumnIndex(COL_NAME)),
                        cursor.getInt(cursor.getColumnIndex(COL_CLASSROOM)),
                        cursor.getString(cursor.getColumnIndex(COL_TIME)),
                        cursor.getString(cursor.getColumnIndex(COL_TEACHER)),
                        cursor.getString(cursor.getColumnIndex(COL_TYPE))
                    )
                    lstSubject.add(subject)
                } while (cursor.moveToNext())
            }
            return lstSubject
        }

    companion object {
        private const val DATABASE_VER = 1
        private const val DATABASE_NAME = "CSBC.db"

        //Table
        private const val TABLE_NAME = "Subject"
        private const val COL_ID = "Id"
        private const val COL_NAME = "Name"
        private const val COL_CLASSROOM = "Number"
        private const val COL_TIME = "Time"
        private const val COL_TEACHER = "Teacher"
        private const val COL_TYPE = "Type"
    }
}