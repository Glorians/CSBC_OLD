package com.geekhub_android.csbc

import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {

            val intent = Intent(this, TeacherActivity::class.java)
            startActivity(intent)

//            fun buttonEffect(button: View) {
//                button.setOnTouchListener { v, event ->
//                    when (event.action) {
//                        MotionEvent.ACTION_DOWN -> {
//                            v.background.setColorFilter(-0x1f0b8adf, PorterDuff.Mode.SRC_ATOP)
//                            v.invalidate()
//                        }
//                        MotionEvent.ACTION_UP -> {
//                            v.background.clearColorFilter()
//                            v.invalidate()
//                        }
//                    }
//                    false
//                }
//            }
        }
        button2.setOnClickListener {
            val intent = Intent(this, StudentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.main, menu)
        return true

    }

//var imageView : ImageView = findViewById(R.id.imageView4)

}




