package com.project.interin_app.doctorProfile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R

class DoctorFragment : Fragment(R.layout.fragment_doctor) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val time = mutableListOf<String>()
        time.add("11:10")
        time.add("11:30")

        val recyclerView: RecyclerView = view.findViewById(R.id.ad_rv_time)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = DoctorTimeAdapter(time)
    }


}