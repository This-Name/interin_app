package com.project.interin_app.doctorProfile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R

class DoctorTimeAdapter(var values: List<String>): RecyclerView.Adapter<DoctorTimeAdapter.ViewHolder>(){

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_time_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView?.text = values[position]
    }

    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!){
        var textView: TextView? = null
        init {
            textView =  itemView?.findViewById(R.id.rv_time_doctor)
        }
    }
}