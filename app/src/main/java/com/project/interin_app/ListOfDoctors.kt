package com.project.interin_app

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListOfDoctors : AppCompatActivity(R.layout.activity_listofdoctors) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val users = ArrayList<Doctor>()
        users.add(Doctor("Александр", "Пушкин"))
        users.add(Doctor("Александр", "Пушкин"))
        users.add(Doctor("Александр", "Пушкин"))
        users.add(Doctor("Александр", "Пушкин"))

        val recyclerView = findViewById<RecyclerView>(R.id.ald_rv_doctors)
        recyclerView.adapter = DoctorAdapter(users)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}