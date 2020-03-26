package com.geekhub_android.csbc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import kotlinx.android.synthetic.main.activity_avtorisetion.*

class Avtorisetion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avtorisetion)

        button1.setOnClickListener{
            val intent = Intent (this,MainActivity::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener{
            val intent = Intent (this,MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

}
