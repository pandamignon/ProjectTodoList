package com.utcc.projecttodolist

import android.content.Context
import android.database.Cursor
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class Adapter(val data: Cursor) : RecyclerView.Adapter<VHolder>() {
    override fun getItemCount(): Int = data.count

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        val holder = VHolder(v)


        return holder
    }


    override fun onBindViewHolder(holder: VHolder, position: Int) {
        data.moveToPosition(position)
        holder.title.text = data.getString(1)
        val time = data.getLong(2)
        val cal = Calendar.getInstance()
        cal.time = Date(time)

        val day = cal.get(Calendar.DAY_OF_MONTH)
        val dayStr = if (day >= 10) "$day" else "0$day"
        //holder.textDate.text = dayStr

        //val m = getMonthName(cal.get(Calendar.MONTH))
        val y = cal.get(Calendar.YEAR) + 543
        //holder.textMonthYear.text = "$m $y"
    }
}