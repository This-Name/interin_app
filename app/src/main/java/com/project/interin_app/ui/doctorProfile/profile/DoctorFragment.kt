package com.project.interin_app.ui.doctorProfile.profile

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.Toast
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

        activity?.title = ""

        val calendar: CalendarView = view.findViewById(R.id.ad_set_date_calendar)
        var currentDate: String = ""
        calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
            currentDate = "$dayOfMonth.$month.$year" // это конкатенация строк
            Toast.makeText(activity, "date changed on $currentDate", Toast.LENGTH_SHORT).show()
        }

        val doctorViewModel by viewModels<DoctorViewModel>()

        viewLifecycleOwner.lifecycleScope.launch {
            val slotList: List<Any>
            // в данный момент сюда кладутся данные сегодняшнего дня и запрос с сегодняшней датой
            if(currentDate == ""){
                val formatted = SimpleDateFormat("dd.MM.yyyy").format(calendar.date)
                slotList = doctorViewModel.getListFreeSlots("{SCHEDULE_ID:\"7FA39CC10D36087CE0530100007F1682\",RESOURCE_ID:\"7FA60CCEEFE36563E0530100007FA9EB\",BDATE:\"$formatted\",EDATE:\"$formatted\"}")
            }else {
                slotList = doctorViewModel.getListFreeSlots(currentDate)
            }
            val recyclerView: RecyclerView = view.findViewById(R.id.ad_rv_time)
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