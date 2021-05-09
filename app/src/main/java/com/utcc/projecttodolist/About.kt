package com.utcc.projecttodolist

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class About:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aboutpage)

        val backBtn = findViewById<ImageButton>(R.id.imageButton4)

        backBtn.setOnClickListener {
            var intent = Intent(this@About,MainActivity::class.java)
            startActivity(intent)
        }
    }
}