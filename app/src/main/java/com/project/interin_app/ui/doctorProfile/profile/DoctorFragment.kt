package com.project.interin_app.ui.doctorProfile.profile

import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.interin_app.R
import com.project.interin_app.repository.slotDoctorsAppointment.Slot
import kotlinx.coroutines.launch
import org.joda.time.format.DateTimeFormat

class DoctorFragment : Fragment(R.layout.fragment_doctor) {
    private val doctorViewModel by viewModels<DoctorViewModel>()
    private var slotList: List<Slot> = mutableListOf()
    private lateinit var institutionData: ArrayList<String>
    private lateinit var resourceInfo: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        institutionData = arguments?.getStringArrayList("idAndNameOfInstitution")!!
        resourceInfo = arguments?.getString("resourceId")!!

        activity?.title = R.string.date_and_time.toString()

        val calendar: CalendarView = view.findViewById(R.id.ad_set_date_calendar)
        var currentDate = ""
        val recyclerView: RecyclerView = view.findViewById(R.id.ad_rv_time)
        val slotList: List<Slot> = mutableListOf()
        recyclerView.layoutManager = GridLayoutManager(activity, 3)

        val adapter =
            DoctorTimeAdapter(
                slotList,
                object :
                    DoctorTimeAdapter.Listener {
                    override fun onItemClick(time: Slot) {
                        val appointmentInfo = ArrayList<String>()
                        appointmentInfo.add(institutionData[1])
                        appointmentInfo.add(time.group)
                        appointmentInfo.add(time.doctor)
                        appointmentInfo.add(time.start)
                        val bundle = Bundle()
                        bundle.putString("slotId", time.id)
                        bundle.putStringArrayList("appointmentInfo", appointmentInfo)
                        findNavController().navigate(
                            R.id.action_doctorFragment_to_doctor_RegistrationFragment,
                            bundle
                        )
                    }
                })
        recyclerView.adapter = adapter

        if (currentDate == "") {
            loadSlots(
                DateTimeFormat.forPattern("dd.MM.yyyy").print(calendar.date),
                institutionData[0],
                resourceInfo,
                adapter
            )
        }
        calendar.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val formattedDay = if (dayOfMonth < 10) {
                "0" + (dayOfMonth).toString()
            } else {
                (dayOfMonth).toString()
            }
            val formattedMonth = if (month + 1 < 10) {
                "0" + (month + 1).toString()
            } else {
                (month + 1).toString()
            }
            currentDate = "$formattedDay.$formattedMonth.$year"
            loadSlots(currentDate, institutionData[0], resourceInfo, adapter)
        }
    }

    private fun loadSlots(
        currentDate: String,
        scheduleId: String,
        resourceId: String,
        adapter: DoctorTimeAdapter
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            slotList = doctorViewModel.getListFreeSlots(
                "{SCHEDULE_ID:\"$scheduleId\"," +
                        "RESOURCE_ID:\"$resourceId\",BDATE:\"$currentDate\",EDATE:\"$currentDate\"}"
            )
            adapter.loadSlots(slotList)
        }
    }
}
