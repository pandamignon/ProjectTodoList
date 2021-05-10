package com.utcc.projecttodolist

import android.content.Context
import android.content.Intent
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

        holder.chkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                val pos = holder.adapterPosition
                data.moveToPosition(pos)
                val mainActivity = parent.context as MainActivity
                mainActivity.dbHelper.updateComplete(data.getString(0),1)
                mainActivity.showToday()
            }
        }

        holder.title.setOnClickListener {
            val pos = holder.adapterPosition
            data.moveToPosition(pos)
            val intent = Intent(parent.context,DetailPage::class.java)
            intent.putExtra("id",data.getString(0))
            parent.context.startActivity(intent)
        }

        return holder
    }


    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.title.text = data.getString(1)
        holder.date.text = data.getString(3)

    }

}

