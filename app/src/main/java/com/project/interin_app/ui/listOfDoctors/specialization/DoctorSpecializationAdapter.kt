package com.project.interin_app.ui.listOfDoctors.specialization

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.doctors.GROUPS

class DoctorSpecializationAdapter(var items: List<GROUPS>, val itemClick: Listener) :
    RecyclerView.Adapter<DoctorSpecializationAdapter.SpecializationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : SpecializationViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(
            R.layout.rv_list_of_specializations,
            parent,
            false
        )

        return SpecializationViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: SpecializationViewHolder, position: Int) {
        holder.bind(items[position])
    }


    inner class SpecializationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(group: GROUPS) {
            val textViewName = itemView.findViewById<TextView>(R.id.rv_specialization_doctor)
            textViewName.text = group.NAME
            itemView.setOnClickListener{
                if(adapterPosition != RecyclerView.NO_POSITION){
                    itemClick.onItemClick(items[adapterPosition])
                }
            }
        }
    }

    interface Listener{
        fun onItemClick(specialization: GROUPS)
    }
}