package com.utcc.projecttodolist

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class EditPage: AppCompatActivity() {

    private lateinit var toDoDate: Triple<Int?, Int?, Int?>
    var dateStr: String = """"""
    internal val database = DatabaseHelper(this@EditPage)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editpage)

        val cancel = findViewById<Button>(R.id.button)
        val saveBtn = findViewById<Button>(R.id.button2)
        val title = findViewById<EditText>(R.id.editTextTextPersonName2)
        val detail = findViewById<EditText>(R.id.editTextTextPersonName3)
        val addDate = findViewById<ImageButton>(R.id.imageButton2)
        val dateText = findViewById<TextView>(R.id.textView11)
        val addTime = findViewById<ImageButton>(R.id.imageButton5)
        val timeText = findViewById<TextView>(R.id.textView12)



        cancel.setOnClickListener {
            val intent = Intent(this@EditPage, DetailPage::class.java)
            startActivity(intent)
        }
        saveBtn.setOnClickListener {

            try {
                database.insertData(
                    title.text.toString(),
                    detail.text.toString(),
                    dateText.text.toString(),
                    timeText.text.toString(),
                    0
                )
            }catch (e: Exception){
                e.printStackTrace()
                showToast(e.message.toString())
            }
            val intent = Intent(this@EditPage, DetailPage::class.java)
            startActivity(intent)
        }
        addDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            toDoDate = Triple(null, null, null)
            val listener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
                toDoDate = Triple(day, month + 1, year)
                dateStr = """${toDoDate.first}/${toDoDate.second}/${toDoDate.third}"""
                //Toast.makeText(this,dateStr,Toast.LENGTH_LONG).show()
                dateText.text = dateStr
            }
            DatePickerDialog(this@EditPage, listener, year, month, day).show()
        }
        addTime.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                timeText.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()

        }
    }
    fun showToast(text: String){
        Toast.makeText(this@EditPage, text, Toast.LENGTH_LONG).show()
    }
}