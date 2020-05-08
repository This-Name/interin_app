package com.project.interin_app.ui.listOfDoctors.institution

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.sheuduleMedInstitution.MedInstitution
import com.project.interin_app.repository.sheuduleMedInstitution.ROWS

class InstitutionAdapter(var items: List<ROWS>, val itemClick: Listener) :
RecyclerView.Adapter<InstitutionAdapter.InstitutionViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : InstitutionViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(
            R.layout.rv_list_of_med_institution,
            parent,
            false
        )

        return InstitutionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: InstitutionViewHolder, position: Int) {
        holder.bind(items[position])
    }


    inner class InstitutionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(institution: ROWS) {
            val textViewName = itemView.findViewById(R.id.rv_institution_name) as TextView
            textViewName.text = institution.NAME.toString()

            itemView.setOnClickListener{
                if(adapterPosition != RecyclerView.NO_POSITION){
                    itemClick.onItemClick(items[adapterPosition])
                }
            }
        }
    }

    interface Listener{
        fun onItemClick(institution: ROWS)
    }
}