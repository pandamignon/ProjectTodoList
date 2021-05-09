package com.utcc.projecttodolist

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Profile: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        val btnEditProfile = findViewById<ImageButton>(R.id.imageButton)
        val btnBack = findViewById<ImageButton>(R.id.imageButton4)
        val user = findViewById<TextView>(R.id.textView2)

        user.text = DatabaseHelper.user

        btnEditProfile.setOnClickListener {
            var intent = Intent(this@Profile,EditProfile::class.java)
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            var intent = Intent(this@Profile,MainActivity::class.java)
            startActivity(intent)

        }
    }
}