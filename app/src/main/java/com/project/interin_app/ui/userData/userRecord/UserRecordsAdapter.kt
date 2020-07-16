package com.project.interin_app.ui.userData.userRecord

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.userData.Records

class UserRecordsAdapter(var items: List<Records>, val itemClick: Listener) :
    RecyclerView.Adapter<UserRecordsAdapter.RecordsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.rv_list_of_user_records,
            parent,
            false
        )
        return RecordsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecordsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class RecordsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(record: Records) {
            val textViewName = itemView.findViewById(R.id.rv_records_name) as TextView
            val textViewDate = itemView.findViewById(R.id.rv_records_date) as TextView
            textViewName.text = record.Doctor
            textViewDate.text = record.Date
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    itemClick.onItemClick(items[adapterPosition])
                }
            }
        }
    }

    interface Listener {
        fun onItemClick(record: Records)
    }
}
