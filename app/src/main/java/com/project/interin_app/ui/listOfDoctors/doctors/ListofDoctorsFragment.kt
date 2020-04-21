package com.project.interin_app.ui.listOfDoctors.doctors

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.repository.Doctor
import com.project.interin_app.R
import com.project.interin_app.ui.doctorProfile.DoctorProfile

class ListofDoctorsFragment : Fragment(R.layout.fragment_listofdoctors_doctors) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val users = ArrayList<Doctor>()
        users.add(
            Doctor(
                "Базова Дана",
                "Окулист"
            )
        )
        users.add(
            Doctor(
                "Иванов Иван",
                "Окулист"
            )
        )
        users.add(
            Doctor(
                "Бабаров Бабар",
                "Окулист"
            )
        )
        users.add(
            Doctor(
                "Навинов Навин",
                "Окулист"
            )
        )
        val recyclerView = view.findViewById<RecyclerView>(R.id.fld_rv_doctors)
        recyclerView.adapter =
            DoctorAdapter(
                users,
                object :
                    DoctorAdapter.Listener {
                    override fun onItemClick(doctor: Doctor) {
                        startActivity(Intent(context, DoctorProfile::class.java))
                    }
                })
        recyclerView.layoutManager = LinearLayoutManager(activity)
    }
}