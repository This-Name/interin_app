package com.project.interin_app.ui.doctorProfile.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.slotDoctorsAppointment.Slot

class DoctorTimeAdapter(var values: List<Slot>, val itemClick: Listener) :
    RecyclerView.Adapter<DoctorTimeAdapter.ViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_time_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(values[position])
    }

    fun loadSlots(data: List<Any>) {
        values = data as List<Slot>
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: Slot) {
            val textViewName = itemView.findViewById<TextView>(R.id.rv_time_doctor)
            textViewName.text = text.timeShow
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    itemClick.onItemClick(values[adapterPosition])
                }
            }
        }
    }

    interface Listener {
        fun onItemClick(time: Slot)
    }
}
