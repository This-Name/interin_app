package com.project.interin_app.ui.listOfDoctors.institution

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.sheuduleMedInstitution.ListMedInstitution
import com.project.interin_app.repository.sheuduleMedInstitution.MedInstitution
import com.project.interin_app.repository.sheuduleMedInstitution.ROWS
import com.project.interin_app.ui.doctorProfile.DoctorProfile
import com.project.interin_app.ui.listOfDoctors.doctors.DoctorAdapter
import com.project.interin_app.ui.listOfDoctors.specialization.SpecializationViewModel
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class InstitutionFragment : Fragment(R.layout.fragment_institution) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val institutionViewModel by viewModels<InstitutionViewModel>()

        viewLifecycleOwner.lifecycleScope.launch {
            var listtest = institutionViewModel.getMedInstitution()

            //view.findViewById<TextView>(R.id.fin_institution).text = listtest.toString()

            activity?.title = ""
            val recyclerView = view.findViewById<RecyclerView>(R.id.fin_rv_med_institution)
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter =
                InstitutionAdapter(
                    listtest.ROWS,
                    object :
                        InstitutionAdapter.Listener {
                        override fun onItemClick(institution: ROWS) {
                            findNavController().navigate(R.id.action_med_institution_to_specialization_doctor)
                        }
                    })
        }
    }
}