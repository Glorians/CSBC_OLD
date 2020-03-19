package com.geekhub_android.csbc.fragments

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.provider.BaseColumns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.geekhub_android.csbc.DBHelper.ReaderDBHelper
import com.geekhub_android.csbc.DBHelper.SubjectDB
import com.geekhub_android.csbc.Model.Subject
import com.geekhub_android.csbc.R
import kotlinx.android.synthetic.main.fragment_monday.*


class FragmentMonday(context: Context) : Fragment() {
    private val cont = context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val view = inflater.inflate(R.layout.fragment_monday, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        start(cont)
    }


    private fun start(context: Context) {
        val dbHelper = ReaderDBHelper(context)
        val db = dbHelper.writableDatabase
        dbWork(context)
        val result = workCursor(db)

        cool.text = result[0].toString()
    }

    private fun dbWork(context: Context) {
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

    private fun workCursor(db: SQLiteDatabase): MutableList<Subject> {

        val projection = arrayOf(
            BaseColumns._ID,
            SubjectDB.COLUMN_PARITY,
            SubjectDB.COLUMN_NAME,
            SubjectDB.COLUMN_CLASSROOM,
            SubjectDB.COLUMN_NUMBER,
            SubjectDB.COLUMN_TEACHER,
            SubjectDB.COLUMN_TYPE,
            SubjectDB.COLUMN_DAY
        )

        val selection = "${SubjectDB.COLUMN_NAME} = ?"
        val selectionArgs = arrayOf("My Name")
        val sortOrder = "${SubjectDB.COLUMN_PARITY} DESC"

        val cursor = db.query(
            SubjectDB.TABLE_NAME,
            null, null, null, null, null, null
        )

        val items = mutableListOf<Subject>()

        with(cursor) {
            while (moveToNext()) {
                val itemId = getLong(getColumnIndexOrThrow(BaseColumns._ID))
                val parity = getInt(getColumnIndexOrThrow(SubjectDB.COLUMN_PARITY))
                val name = getString(getColumnIndexOrThrow(SubjectDB.COLUMN_NAME))
                val classroom = getInt(getColumnIndexOrThrow(SubjectDB.COLUMN_CLASSROOM))
                val number = getInt(getColumnIndexOrThrow(SubjectDB.COLUMN_NUMBER))
                val teacher = getString(getColumnIndexOrThrow(SubjectDB.COLUMN_TEACHER))
                val type = getString(getColumnIndexOrThrow(SubjectDB.COLUMN_TYPE))
                val day = getInt(getColumnIndexOrThrow(SubjectDB.COLUMN_DAY))
                val feed = Subject(itemId, parity, name, classroom, number, teacher, type, day)
                items.add(feed)
            }
        }
        cursor.close()
        return items
    }
}
