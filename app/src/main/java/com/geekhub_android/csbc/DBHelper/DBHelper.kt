package com.geekhub_android.csbc.DBHelper

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns


object SubjectDB : BaseColumns {
    const val TABLE_NAME = "subject"
    const val COLUMN_PARITY = "parity"
    const val COLUMN_NAME = "name"
    const val COLUMN_CLASSROOM = "classroom"
    const val COLUMN_NUMBER = "number"
    const val COLUMN_TEACHER = "teacher"
    const val COLUMN_TYPE = "type"
    const val COLUMN_DAY = "day"
}

object GroupDB : BaseColumns {
    const val TABLE_NAME = "group"
    const val COLUMN_DIRECTION = "direction"
    const val COLUMN_NAME = "name"
    const val COLUMN_SUBGROUP = "subgroup"
}

object Teacher : BaseColumns {
    const val TABLE_NAME = "teacher"
    const val COLUMN_NAME = "name"
    const val COLUMN_STATUS = "status"
}

class ReaderDBHelper(context: Context?) : SQLiteOpenHelper( context,
    DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_SUBJECT)
        onCursor(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_SUBJECT)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @SuppressLint("Recycle")
    fun onCursor (db: SQLiteDatabase) {

    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Main.db"

        //////////////////////////SUBJECT////////////////////////////////////

        // CREATE TABLE SUBJECT
        private const val SQL_CREATE_SUBJECT =
            "CREATE TABLE ${SubjectDB.TABLE_NAME} (" +          //TABLE NAME
                    "${BaseColumns._ID} INTEGER PRIMARY KEY, " + //ID
                    "${SubjectDB.COLUMN_PARITY} INTEGER, " +    //PARITY
                    "${SubjectDB.COLUMN_NAME} TEXT, " +         //NAME
                    "${SubjectDB.COLUMN_CLASSROOM} INTEGER, " + //CLASSROOM
                    "${SubjectDB.COLUMN_NUMBER} INTEGER, " +    //NUMBER
                    "${SubjectDB.COLUMN_TEACHER} TEXT, " +      //TEACHER
                    "${SubjectDB.COLUMN_TYPE} TEXT, " +         //TYPE
                    "${SubjectDB.COLUMN_DAY} INTEGER)"           //DAY


        // DELETE TABLE SUBJECT
        private const val SQL_DELETE_SUBJECT =
            "DROP TABLE IF EXISTS ${SubjectDB.TABLE_NAME}"
    }


}
