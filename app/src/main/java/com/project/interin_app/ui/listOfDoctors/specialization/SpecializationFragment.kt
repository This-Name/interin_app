package com.project.interin_app.ui.listOfDoctors.specialization

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.doctors.Specialization
import kotlinx.coroutines.launch

class SpecializationFragment : Fragment(R.layout.fragment__listofdoctors_specialization) {
    private val specializationViewModel by viewModels<SpecializationViewModel>()
    private lateinit var inputData: ArrayList<String> // здесь лежит все то, что передано с прошлого фрагмента
    private lateinit var institutionId: String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = getString(R.string.specializations)
        inputData =
            arguments?.getStringArrayList("idAndNameOfInstitution")!! // получаю все с прошлого фрагмента
        val recyclerView: RecyclerView = view.findViewById(R.id.fld_rv_doctors_specialization)
        institutionId = inputData[0]

        viewLifecycleOwner.lifecycleScope.launch {
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter =
                DoctorSpecializationAdapter(
                    specializationViewModel.getSpecialization("{SCHEDULE_ID:\"$institutionId\"}"),
                    object :
                        DoctorSpecializationAdapter.Listener {
                        override fun onItemClick(specialization: Specialization) {
                            val bundle = Bundle()
                            val data = specialization.resources
                            bundle.putParcelableArrayList("ListOfResources", data)
                            bundle.putStringArrayList("idAndNameOfInstitution", inputData)
                            findNavController().navigate(
                                R.id.action_specialization_doctor_to_list_of_doctors,
                                bundle
                            )
                        }
                    })
        }
    }
}
