package com.project.interin_app.ui.listOfDoctors.doctors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.doctors.Doctor


class DoctorAdapter(var items: List<Doctor>, val itemClick: Listener) :
    RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_list_of_doctors,
            parent,
            false
        )

        return DoctorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.bind(items[position])
    }


    inner class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(doctor: Doctor) {
            val textViewName = itemView.findViewById(R.id.rv_name_doctor) as TextView
            val textViewAddress = itemView.findViewById(R.id.rv_category_doctor) as TextView
            textViewName.text = doctor.name
            textViewAddress.text = doctor.group_name

            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    itemClick.onItemClick(items[adapterPosition])
                }
            }
        }
    }

    interface Listener {
        fun onItemClick(doctor: Doctor)
    }
}
