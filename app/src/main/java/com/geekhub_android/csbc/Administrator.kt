package com.geekhub_android.csbc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class Administrator : AppCompatActivity() {


    companion object {
        private const val COLLECTION = "subject"
        private const val F_ID = "id"
        private const val F_NAME = "name"
        private const val F_SUBGROUP = "subgroup"
    }

    private var docId = ""
    lateinit var db: FirebaseFirestore
    lateinit var alGroup: ArrayList<HashMap<String, Any>>
    lateinit var adapter: SimpleAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_administator)
    }
}
