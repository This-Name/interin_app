package com.project.interin_app.ui.doctorProfile.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.slotDoctorsAppointment.ROWS
import kotlinx.coroutines.launch

class DoctorFragment : Fragment(R.layout.fragment_doctor) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val time = mutableListOf<String>()
        time.add("11:10")
        time.add("11:30")
        time.add("11:10")
        time.add("11:30")
        time.add("11:10")
        time.add("11:30")

        val doctorViewModel by viewModels<DoctorViewModel>()
        activity?.title = ""
        viewLifecycleOwner.lifecycleScope.launch {
            var testttlist = doctorViewModel.getListFreeSlots()
            val recyclerView: RecyclerView = view.findViewById(R.id.ad_rv_time)
            recyclerView.layoutManager = GridLayoutManager(activity, 3)
            recyclerView.adapter =
                DoctorTimeAdapter(
                    testttlist,
                    object :
                        DoctorTimeAdapter.Listener {
                        override fun onItemClick(time: ROWS) {
                            findNavController().navigate(R.id.action_doctorFragment_to_doctorRegistrationFragment)
                        }

                    })
        }
    }


}