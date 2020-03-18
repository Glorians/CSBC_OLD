package com.geekhub_android.csbc.DBHelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import java.io.*
import java.sql.SQLException


object FeedEntry : BaseColumns {
    const val TABLE_NAME = "subject"
    const val COLUMN_PARITY = "parity"
    const val COLUMN_NAME = "name"
    const val COLUMN_CLASSROOM = "classroom"
    const val COLUMN_NUMBER = "number"
    const val COLUMN_TEACHER = "teacher"
    const val COLUMN_TYPE = "type"
    const val COLUMN_DAY = "day"
}

class ReaderDBHelper(context: Context) : SQLiteOpenHelper( context,
    DATABASE_NAME, null, DATABASE_VERSION) {


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
<<<<<<< HEAD
=======
        onCursor(db)
>>>>>>> master
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
<<<<<<< HEAD
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
=======
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @SuppressLint("Recycle")
    fun onCursor (db: SQLiteDatabase) {

>>>>>>> master
    }


    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Main.db"

        // CREATE TABLE
        private const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${FeedEntry.TABLE_NAME} (" +          //TABLE NAME
                    "${BaseColumns._ID} INTEGER PRIMARY KEY, " + //ID
                    "${FeedEntry.COLUMN_PARITY} INTEGER, " +    //PARITY
                    "${FeedEntry.COLUMN_NAME} TEXT, " +         //NAME
                    "${FeedEntry.COLUMN_CLASSROOM} INTEGER, " + //CLASSROOM
                    "${FeedEntry.COLUMN_NUMBER} INTEGER, " +    //NUMBER
                    "${FeedEntry.COLUMN_TEACHER} TEXT, " +      //TEACHER
                    "${FeedEntry.COLUMN_TYPE} TEXT, " +         //TYPE
                    "${FeedEntry.COLUMN_DAY} INTEGER)"           //DAY


        // DELETE TABLE
        private const val SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS ${FeedEntry.TABLE_NAME}"
    }

}
