package com.utcc.projecttodolist

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VHolder(v: View) :  RecyclerView.ViewHolder(v) {
    var date = v.findViewById<TextView>(R.id.textView16)
    var title = v.findViewById<TextView>(R.id.textView15)
}