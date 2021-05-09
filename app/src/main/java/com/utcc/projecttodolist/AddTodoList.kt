package com.utcc.projecttodolist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddTodoList: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.submitpage)

        val cancel = findViewById<Button>(R.id.button)
        val saveBtn = findViewById<Button>(R.id.button2)
        val title = findViewById<EditText>(R.id.editTextTextPersonName2)
        val detail = findViewById<EditText>(R.id.editTextTextPersonName3)

        cancel.setOnClickListener {
            val intent = Intent(this@AddTodoList,MainActivity::class.java)
            startActivity(intent)
        }
        saveBtn.setOnClickListener {
            val intent = Intent(this@AddTodoList,MainActivity::class.java)
            startActivity(intent)
        }
    }
}