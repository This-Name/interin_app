package com.project.interin_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.doctorProfile.DoctorProfile

class ListOfDoctors : AppCompatActivity(R.layout.activity_listofdoctors) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val users = ArrayList<Doctor>()
        users.add(Doctor("Александр", "Пушкин"))
        users.add(Doctor("Александр", "Пушкин"))
        users.add(Doctor("Александр", "Пушкин"))
        users.add(Doctor("Александр", "Пушкин"))
        actionBar?.setTitle("Выбр врача")
        val recyclerView = findViewById<RecyclerView>(R.id.ald_rv_doctors)
        recyclerView.adapter = DoctorAdapter(users, object: DoctorAdapter.Listener{
            override fun onItemClick(doctor: Doctor) {
                startActivity(Intent(this@ListOfDoctors, DoctorProfile::class.java))
            }
        })
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}