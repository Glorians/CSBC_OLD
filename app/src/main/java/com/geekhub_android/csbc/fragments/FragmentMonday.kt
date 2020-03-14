package com.geekhub_android.csbc.fragments

import android.database.Cursor
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.fragment.app.Fragment
import com.geekhub_android.csbc.DBHelper.DatabaseHelper

import com.geekhub_android.csbc.R
import java.sql.SQLException

class FragmentMonday(): Fragment(){

    var classID: String? = null
    var userAdapter: SimpleCursorAdapter? = null
    var sqlHelper: DatabaseHelper? = null
    var userCursor: Cursor? = null
    var mList: ListView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_monday, container, false)
        val bundle = activity!!.intent.extras
//        classID = bundle!!.getString("classID")
        sqlHelper = DatabaseHelper(activity!!)
        sqlHelper!!.create_db()
        return view

    }

    override fun onResume() {
        super.onResume()
        try {
            sqlHelper!!.open()
            userCursor = sqlHelper!!.database!!.rawQuery(
                "select * from " + DatabaseHelper.TABLE + " where parity=" + "1"/*classID.toString()*/ + " and day=1",
                null
            )
            val headers =
                arrayOf<String>(DatabaseHelper.COLUMN_NAME)
            userAdapter = SimpleCursorAdapter(
                activity,
                R.layout.item_subject,
                userCursor,
                headers,
                intArrayOf(R.id.subject),
                0
            )
            mList!!.adapter = userAdapter
        } catch (ex: SQLException) {
        }
    }

}