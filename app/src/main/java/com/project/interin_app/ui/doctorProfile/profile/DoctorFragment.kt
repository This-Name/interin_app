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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.title = ""

        val calendar: CalendarView = view.findViewById(R.id.ad_set_date_calendar)
        var currentDate = ""
        val recyclerView: RecyclerView = view.findViewById(R.id.ad_rv_time)

        if(currentDate == "")
            loadSlots(SimpleDateFormat("dd.MM.yyyy").format(calendar.date), recyclerView)

        calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            currentDate = if(month + 1 < 10)
                "$dayOfMonth.0" + (month + 1).toString() + ".$year"
            else
                "$dayOfMonth." + (month + 1).toString() + ".$year"
//            Toast.makeText(activity, "date changed on $currentDate", Toast.LENGTH_SHORT).show()

            loadSlots(currentDate, recyclerView)
        }
    }

    private fun loadSlots(currentDate: String, recyclerView: RecyclerView){
        viewLifecycleOwner.lifecycleScope.launch {
            val slotList: List<Any>
//                Toast.makeText(activity, "Coroutine started, date = $currentDate", Toast.LENGTH_SHORT).show()
                slotList = doctorViewModel.getListFreeSlots("{SCHEDULE_ID:\"7FA39CC10D36087CE0530100007F1682\"," +
                        "RESOURCE_ID:\"7FA60CCEEFE36563E0530100007FA9EB\",BDATE:\"$currentDate\",EDATE:\"$currentDate\"}")
//                recyclerView = view.findViewById(R.id.ad_rv_time)
            recyclerView.layoutManager = GridLayoutManager(activity, 3)
            recyclerView.adapter =
                DoctorTimeAdapter(
                    slotList as List<ROWS>,
                    object :
                        DoctorTimeAdapter.Listener {
                        override fun onItemClick(time: ROWS) {
                            findNavController().navigate(R.id.action_doctorFragment_to_doctorRegistrationFragment)
                        }

                    })
        }
    }


}