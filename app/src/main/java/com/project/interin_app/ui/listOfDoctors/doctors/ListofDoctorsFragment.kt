package com.project.interin_app.ui.listOfDoctors.doctors

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.doctors.RESOURCES

class ListofDoctorsFragment : Fragment(R.layout.fragment_listofdoctors_doctors) {
    private lateinit var institutionData: ArrayList<String>
    private lateinit var resourcesList: List<RESOURCES>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = R.string.doctors.toString()

        val recyclerView = view.findViewById<RecyclerView>(R.id.fld_rv_doctors)
        institutionData = arguments?.getStringArrayList("idAndNameOfInstitution")!!
        resourcesList = arguments?.getParcelableArrayList("ListOfResources")!!

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter =
            DoctorAdapter(
                resourcesList,
                object :
                    DoctorAdapter.Listener {
                    override fun onItemClick(doctor: RESOURCES) {
                        val bundle = Bundle()
                        bundle.putStringArrayList("idAndNameOfInstitution", institutionData)
                        bundle.putString("resourceId", doctor._ID)
                        findNavController().navigate(
                            R.id.action_list_of_doctorsFragment_to_doctorFragment,
                            bundle
                        )
                    }
                })
    }
}
