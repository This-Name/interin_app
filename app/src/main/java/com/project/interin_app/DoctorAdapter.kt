package com.project.interin_app

import android.R.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DoctorAdapter(var items: List<Doctor>) : RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : DoctorAdapter.DoctorViewHolder = DoctorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_list_of_doctors, parent, false))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.bind(items[position])
    }
    inner class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(doctor: Doctor) {
            val textViewName = itemView.findViewById(R.id.rv_name_doctor) as TextView
            val textViewAddress  = itemView.findViewById(R.id.rv_category_doctor) as TextView
            textViewName.text = doctor.name
            textViewAddress.text = doctor.category
        }
    }
}