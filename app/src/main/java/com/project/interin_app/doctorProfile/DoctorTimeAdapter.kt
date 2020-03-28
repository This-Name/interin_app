package com.project.interin_app.doctorProfile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.Doctor
import com.project.interin_app.DoctorAdapter
import com.project.interin_app.R

class DoctorTimeAdapter(var values: List<String>, val itemClick: Listener): RecyclerView.Adapter<DoctorTimeAdapter.ViewHolder>(){

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_time_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(values[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String) {
            val textViewName = itemView.findViewById<TextView>(R.id.rv_time_doctor)
            textViewName.text = text
            itemView.setOnClickListener{
                if(adapterPosition != RecyclerView.NO_POSITION){
                    itemClick.onItemClick(values[adapterPosition])
                }
            }
        }
    }
    interface Listener{
        fun onItemClick(time: String)
    }
}