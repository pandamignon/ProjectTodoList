package com.utcc.projecttodolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    internal var dbHelper = DatabaseHelper(this)
    private lateinit var firstRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        val menu = findViewById<Spinner>(R.id.spmenu)

        val addTodo = findViewById<ImageView>(R.id.imageButton6)
        firstRecycler = findViewById(R.id.firstRecycler)
        firstRecycler.layoutManager = LinearLayoutManager(this)
        val itemDecor = DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        firstRecycler.addItemDecoration(itemDecor)

        showToday()

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
    fun showToday() {
        val res = dbHelper.todayData
        if (res.count == 0) {
            Toast.makeText(this@MainActivity,"No Data",Toast.LENGTH_SHORT).show()
        }else{
            res.moveToFirst()
            val adapter = Adapter(res)
            firstRecycler.adapter = adapter
            Toast.makeText(this,"There is "+res.getString(res.getColumnIndex("NAME")),Toast.LENGTH_SHORT).show()
        }
    }
}