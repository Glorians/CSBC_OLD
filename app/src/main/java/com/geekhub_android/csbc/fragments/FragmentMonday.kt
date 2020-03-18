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
<<<<<<< HEAD
import com.geekhub_android.csbc.DBHelper.ReaderDBHelper
import com.geekhub_android.csbc.MainActivity
=======
import com.geekhub_android.csbc.DBHelper.FeedEntry
import com.geekhub_android.csbc.DBHelper.ReaderDBHelper
import com.geekhub_android.csbc.Feed
import com.geekhub_android.csbc.MainActivity

>>>>>>> master
import com.geekhub_android.csbc.R
import kotlinx.android.synthetic.main.fragment_monday.*

<<<<<<< HEAD

class FragmentMonday(): Fragment(){


=======
class FragmentMonday(context: Context): Fragment(){
    private val cont = context
>>>>>>> master
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

<<<<<<< HEAD
        val view = inflater.inflate(R.layout.fragment_monday, container, false)
=======
        val view = inflater.inflate(R.layout.fragment_monday,container,false)
>>>>>>> master
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
<<<<<<< HEAD

    }


=======
        start(cont)
    }

    private fun start (context: Context) {
        val dbHelper = ReaderDBHelper(context)
        val db = dbHelper.writableDatabase
        dbWork(context)
        val result = workCursor(db)

        cool.text = result[0].toString()
    }

    private fun dbWork (context: Context) {
        val dbHelper = ReaderDBHelper(context)
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(FeedEntry.COLUMN_PARITY, 1)
            put(FeedEntry.COLUMN_NAME, "Програмирование")
            put(FeedEntry.COLUMN_CLASSROOM, 216)
            put(FeedEntry.COLUMN_NUMBER, 4)
            put(FeedEntry.COLUMN_TEACHER, "Стасик")
            put(FeedEntry.COLUMN_TYPE, "Лекция")
            put(FeedEntry.COLUMN_DAY, 1)
        }

        val newRowId = db?.insert(FeedEntry.TABLE_NAME, null, values)
    }

    private fun workCursor (db: SQLiteDatabase): MutableList<Feed> {

        val projection = arrayOf(
            BaseColumns._ID,
            FeedEntry.COLUMN_PARITY,
            FeedEntry.COLUMN_NAME,
            FeedEntry.COLUMN_CLASSROOM,
            FeedEntry.COLUMN_NUMBER,
            FeedEntry.COLUMN_TEACHER,
            FeedEntry.COLUMN_TYPE,
            FeedEntry.COLUMN_DAY
        )

        val selection = "${FeedEntry.COLUMN_NAME} = ?"
        val selectionArgs = arrayOf("My Name")
        val sortOrder = "${FeedEntry.COLUMN_PARITY} DESC"

        val cursor = db.query(
            FeedEntry.TABLE_NAME,
            null,null,null,null,null, null
        )

        val items = mutableListOf<Feed>()

        with(cursor) {
            while (moveToNext()) {
                val itemId = getLong(getColumnIndexOrThrow(BaseColumns._ID))
                val parity = getInt(getColumnIndexOrThrow(FeedEntry.COLUMN_PARITY))
                val name = getString(getColumnIndexOrThrow(FeedEntry.COLUMN_NAME))
                val classroom = getInt(getColumnIndexOrThrow(FeedEntry.COLUMN_CLASSROOM))
                val number = getInt(getColumnIndexOrThrow(FeedEntry.COLUMN_NUMBER))
                val teacher = getString(getColumnIndexOrThrow(FeedEntry.COLUMN_TEACHER))
                val type = getString(getColumnIndexOrThrow(FeedEntry.COLUMN_TYPE))
                val day = getInt(getColumnIndexOrThrow(FeedEntry.COLUMN_DAY))
                val feed = Feed(itemId, parity, name, classroom, number, teacher, type, day)
                items.add(feed)
            }
        }
        cursor.close()
        return items
    }
>>>>>>> master
}