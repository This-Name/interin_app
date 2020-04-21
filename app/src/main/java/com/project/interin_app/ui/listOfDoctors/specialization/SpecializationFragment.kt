package com.project.interin_app.ui.listOfDoctors.specialization

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R

class SpecializationFragment : Fragment(R.layout.fragment__listofdoctors_specialization){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val specialization = ArrayList<String>()
        specialization.add("Окулист")
        specialization.add("Терапевт")
        specialization.add("Хирург")
        specialization.add("Невролог")

        activity?.title = ""
        val recyclerView: RecyclerView = view.findViewById(R.id.fld_rv_doctors_specialization)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter =
            DoctorSpecializationAdapter(
                specialization,
                object :
                    DoctorSpecializationAdapter.Listener {
                    override fun onItemClick(time: String) {
                        findNavController().navigate(R.id.action_specialization_doctor_to_list_of_doctors)
                    }

                })
    }
}