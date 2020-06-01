package com.project.interin_app.ui.doctorProfile.profile

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.slotDoctorsAppointment.ROWS
import kotlinx.coroutines.launch

class DoctorFragment : Fragment(R.layout.fragment_doctor) {
    private val doctorViewModel by viewModels<DoctorViewModel>()
    private var slotList: List<Any> = mutableListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = ""

        val calendar: CalendarView = view.findViewById(R.id.ad_set_date_calendar)
        var currentDate = ""
        val recyclerView: RecyclerView = view.findViewById(R.id.ad_rv_time)
        val slotList: List<Any> = mutableListOf()
        recyclerView.layoutManager = GridLayoutManager(activity, 3)

        val adapter =
            DoctorTimeAdapter(
                slotList as List<ROWS>,
                object :
                    DoctorTimeAdapter.Listener {
                    override fun onItemClick(time: ROWS) {
                        findNavController().navigate(R.id.action_doctorFragment_to_doctor_RegistrationFragment)
                    }

                })
        recyclerView.adapter = adapter

        if(currentDate == "")
            loadSlots(SimpleDateFormat("dd.MM.yyyy").format(calendar.date), recyclerView, adapter)

        calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val formattedDay = if(dayOfMonth < 10)
                "0" + (dayOfMonth).toString()
            else
                (dayOfMonth).toString()

            val formattedMonth = if(month + 1 < 10)
                "0" + (month + 1).toString()
            else
                (month + 1).toString()

            currentDate = "$formattedDay.$formattedMonth.$year"

            loadSlots(currentDate, recyclerView, adapter)
        }
    }

    private fun loadSlots(currentDate: String, recyclerView: RecyclerView, adapter: DoctorTimeAdapter){
        viewLifecycleOwner.lifecycleScope.launch {
            slotList = doctorViewModel.getListFreeSlots("{SCHEDULE_ID:\"7FA39CC10D36087CE0530100007F1682\"," +
                    "RESOURCE_ID:\"7FA60CCEEFE36563E0530100007FA9EB\",BDATE:\"$currentDate\",EDATE:\"$currentDate\"}")
            adapter.loadSlots(slotList)
        }
    }


}