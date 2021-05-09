package com.utcc.projecttodolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        val menu = findViewById<Spinner>(R.id.spmenu)

        val addTodo = findViewById<ImageView>(R.id.imageButton6)

        menu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //Toast.makeText(this@MainActivity,"You Click "+position,Toast.LENGTH_LONG).show()
                if(position == 1){
                    val intent = Intent(this@MainActivity,Profile::class.java);
                    startActivity(intent)
                }
                if(position == 3){
                    val intent = Intent(this@MainActivity,About::class.java);
                    startActivity(intent)
                }
            }

        }

        addTodo.setOnClickListener {
            val intent = Intent(this@MainActivity,AddTodoList::class.java)
            startActivity(intent)
        }

    }
}