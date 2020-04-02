package com.project.interin_app.doctorProfile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R

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
        activity?.title = ""
        val recyclerView: RecyclerView = view.findViewById(R.id.ad_rv_time)
        recyclerView.layoutManager = GridLayoutManager(activity, 3)
        recyclerView.adapter = DoctorTimeAdapter(time, object: DoctorTimeAdapter.Listener{
            override fun onItemClick(time: String) {
                findNavController().navigate(R.id.action_doctorFragment_to_doctorRegistrationFragment)
            }

        })
    }


}