package com.project.interin_app.ui.listOfDoctors.specialization

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.Doctor
import com.project.interin_app.repository.Groups
import com.project.interin_app.repository.doctors.GROUPS
import com.project.interin_app.repository.sheuduleMedInstitution.MedInstitution
import kotlinx.coroutines.launch

class SpecializationFragment : Fragment(R.layout.fragment__listofdoctors_specialization){
    private lateinit var inputData: ArrayList<String> // здесь лежит все то, что передано с прошлого фрагмента
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inputData = arguments?.getStringArrayList("id_and_name")!! // получаю все с прошлого фрагмента
        activity?.title = inputData[1]
        val usersTest = ArrayList<String>()
        val specializationViewModel by viewModels<SpecializationViewModel>()
//        usersTest.add("Осел")
        usersTest.add("Терапевты")
        usersTest.add("Хирурги")
        val recyclerView: RecyclerView = view.findViewById(R.id.fld_rv_doctors_specialization)
        viewLifecycleOwner.lifecycleScope.launch {
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter =
                DoctorSpecializationAdapter(
                    specializationViewModel.getSpecialization(),
                    object :
                        DoctorSpecializationAdapter.Listener {
                        override fun onItemClick(time: GROUPS) {
                            findNavController().navigate(R.id.action_specialization_doctor_to_list_of_doctors)
                        }

                    })
        }
    }
}