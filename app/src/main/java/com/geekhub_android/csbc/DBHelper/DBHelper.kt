package com.geekhub_android.csbc.DBHelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.*
import java.sql.SQLException


class DatabaseHelper(private val myContext: Context) :
    SQLiteOpenHelper(
        myContext,
        DB_NAME,
        null,
        SCHEMA
    ) {
    var database: SQLiteDatabase? = null
    override fun onCreate(db: SQLiteDatabase) {}
    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
    }

    fun create_db() {
        var myInput: InputStream? = null
        var myOutput: OutputStream? = null
        try {
            val file =
                File(DB_PATH + DB_NAME)
            if (!file.exists()) {
                this.readableDatabase
                myInput = myContext.assets.open(DB_NAME)
                val outFileName =
                    DB_PATH + DB_NAME
                myOutput = FileOutputStream(outFileName)
                val buffer = ByteArray(1024)
                var length: Int
                while (myInput.read(buffer).also { length = it } > 0) {
                    myOutput.write(buffer, 0, length)
                }
                myOutput.flush()
                myOutput.close()
                myInput.close()
            }
        } catch (ex: IOException) {
        }
    }

    @Throws(SQLException::class)
    fun open() {
        val path =
            DB_PATH + DB_NAME
        database = SQLiteDatabase.openDatabase(
            path, null,
            SQLiteDatabase.OPEN_READONLY
        )
    }

    @Synchronized
    override fun close() {
        if (database != null) {
            database!!.close()
        }
        super.close()
    }

    companion object {
        var DB_NAME = "main.sqlite"
        private const val SCHEMA = 1 // версия базы данных
        const val TABLE = "main"
        private const val DB_PATH = "/data/data/com.geekhub_android.csbc/databases/"
        const val COLUMN_ID = "id"
        const val COLUMN_PARITY = "parity"
        const val COLUMN_NAME = "name"
        const val COLUMN_CLASSROOM = "classroom"
        const val COLUMN_NUMBER = "number"
        const val COLUMN_TEACHER = "teacher"
        const val COLUMN_TYPE = "type"
        const val COLUMN_DAY = "day"
    }

}


//class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {
//
//    override fun onCreate(db: SQLiteDatabase?) {
//        val CREATE_TABLE_QUERY: String =
//            ("CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY, $COL_NAME TEXT, " +
//                    "$COL_CLASSROOM INTEGER PRIMARY KEY, $COL_TIME TEXT, $COL_TEACHER TEXT, $COL_TYPE TEXT)")
//        db!!.execSQL(CREATE_TABLE_QUERY)
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
//        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
//        onCreate(db)
//    }
//
//    //CRUD
//    val allSubject: List<Subject>
//        @SuppressLint("Recycle")
//        get() {
//            val lstSubject = ArrayList<Subject>()
//            val selectQuery = "SELECT * FROM $TABLE_NAME"
//            val db = this.writableDatabase
//            val cursor = db.rawQuery(selectQuery, null)
//            if (cursor.moveToFirst()) {
//                do {
//                    val subject = Subject(
//                        cursor.getInt(cursor.getColumnIndex(COL_ID)),
//                        cursor.getString(cursor.getColumnIndex(COL_NAME)),
//                        cursor.getInt(cursor.getColumnIndex(COL_CLASSROOM)),
//                        cursor.getString(cursor.getColumnIndex(COL_TIME)),
//                        cursor.getString(cursor.getColumnIndex(COL_TEACHER)),
//                        cursor.getString(cursor.getColumnIndex(COL_TYPE))
//                    )
//                    lstSubject.add(subject)
//                } while (cursor.moveToNext())
//            }
//            return lstSubject
//        }
//
//    companion object {
//        private const val DATABASE_VER = 1
//        private const val DATABASE_NAME = "CSBC.db"
//
//        //Table
//        private const val TABLE_NAME = "Subject"
//        private const val COL_ID = "Id"
//        private const val COL_NAME = "Name"
//        private const val COL_CLASSROOM = "Number"
//        private const val COL_TIME = "Time"
//        private const val COL_TEACHER = "Teacher"
//        private const val COL_TYPE = "Type"
//    }
//}