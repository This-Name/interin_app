package com.project.interin_app.ui.listOfDoctors.institution

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.scheduleMedInstitution.MedInstitution

class InstitutionAdapter(var items: List<MedInstitution>, val itemClick: Listener) :
    RecyclerView.Adapter<InstitutionAdapter.InstitutionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstitutionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
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
        fun bind(institution: MedInstitution) {
            val textViewOrganization =
                itemView.findViewById(R.id.rv_institution_ORGANIZATION) as TextView
            val textViewName = itemView.findViewById(R.id.rv_institution_NAME) as TextView
            textViewOrganization.text = institution.organization
            textViewName.text = institution.name
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    itemClick.onItemClick(items[adapterPosition])
                }
            }
        }
    }

    interface Listener {
        fun onItemClick(institution: MedInstitution)
    }
}
