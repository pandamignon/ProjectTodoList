package com.utcc.projecttodolist

import android.database.Cursor
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class Adapter(private val data: Cursor) : RecyclerView.Adapter<VHolder>() {
    override fun getItemCount(): Int = data.count

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        val holder = VHolder(v)


        return holder
    }


    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.title.text = data.getString(1)
        holder.date.text = data.getString(3)

    }
}

