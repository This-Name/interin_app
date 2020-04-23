package com.project.interin_app.ui.listOfDoctors.specialization

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R

class SpecializationFragment : Fragment(R.layout.fragment__listofdoctors_specialization){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val specializationViewModel by viewModels<SpecializationViewModel>()
        activity?.title = ""
        val recyclerView: RecyclerView = view.findViewById(R.id.fld_rv_doctors_specialization)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter =
            DoctorSpecializationAdapter(
                specializationViewModel.getSpecialization(),
                object :
                    DoctorSpecializationAdapter.Listener {
                    override fun onItemClick(time: String) {
                        findNavController().navigate(R.id.action_specialization_doctor_to_list_of_doctors)
                    }

                })
    }
}