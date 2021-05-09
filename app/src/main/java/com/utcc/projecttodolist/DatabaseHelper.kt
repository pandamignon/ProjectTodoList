package com.utcc.projecttodolist

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.net.Uri

class DatabaseHelper  (context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase){
            db.execSQL("CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "NAME TEXT,DETAIL TEXT,TODODATE TEXT,TODOTIME TEXT,COMPLETE INTEGER)");
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun insertData(name: String, detail: String, toDoDate: String, toDoTime: Int, complete: Int) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2, name)
        contentValues.put(COL_3, detail)
        contentValues.put(COL_4, toDoDate)
        contentValues.put(COL_5, toDoTime)
        contentValues.put(COL_6, complete)
        db.insert(TABLE_NAME, null, contentValues)
    }

    fun updateData(id: String, name: String, detail: String, toDoDate: String, toDoTime: Int, complete: Int):
            Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, id)
        contentValues.put(COL_2, name)
        contentValues.put(COL_3, detail)
        contentValues.put(COL_4, toDoDate)
        contentValues.put(COL_5, toDoTime)
        contentValues.put(COL_6, complete)
        db.update(TABLE_NAME, contentValues, "ID = ?", arrayOf(id))
        return true
    }

    fun deleteData(id : String) : Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME,"ID = ?", arrayOf(id))
    }

    val allData : Cursor
        get() {
            val db = this.writableDatabase
            val res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null)
            return res
        }

    companion object {
        val DATABASE_NAME = "todo.db"
        val TABLE_NAME = "todolist"
        val COL_1 = "ID"
        val COL_2 = "NAME"
        val COL_3 = "DETAIL"
        val COL_4 = "DATE"
        val COL_5 = "TIME"
        val COL_6 = "COMPLETE"
        var user = "User"
        var link = ""
    }



}