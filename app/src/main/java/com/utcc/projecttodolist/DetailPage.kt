package com.utcc.projecttodolist

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class DetailPage: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailpage)

        val editDetailBtn = findViewById<ImageButton>(R.id.imageButton7)

        editDetailBtn.setOnClickListener{
            val intent = Intent(this,EditPage::class.java)
            startActivity(intent)
        }

    }
}