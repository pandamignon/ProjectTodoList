package com.utcc.projecttodolist

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailPage: AppCompatActivity() {
    private lateinit var sqLiteDb: SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailpage)

        val editDetailBtn = findViewById<ImageButton>(R.id.imageButton7)
        val textViewName = findViewById<TextView>(R.id.textView2)
        val textViewDetail = findViewById<TextView>(R.id.editTextTextPersonName2)
        val textDate = findViewById<TextView>(R.id.editTextTextPersonName3)
        val textTime = findViewById<TextView>(R.id.editTextTextPersonName4)


        val bundle = intent.extras
        if(bundle != null){
            val recivedId = bundle.getString("id")
            /*val sql = "SELECT * FROM todolist WHERE ID = '$recivedId'"
            val res = sqLiteDb.rawQuery(sql,null)
            res.moveToFirst()
            textViewName.setText(res.getString(1))
            textViewDetail.setText(res.getString(2))
            textDate.setText(res.getString(3))
            textTime.setText(res.getString(4))*/
        }


        editDetailBtn.setOnClickListener{
            val intent = Intent(this,EditPage::class.java)
            startActivity(intent)
        }

    }
}