package com.project.interin_app.ui.doctorProfile.registration

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.project.interin_app.R

class DoctorRegistrationFragment : Fragment(R.layout.fragment_registration_doctor) {
    // slot ID
    lateinit var slotId: String
    // информация о записи по порядку: место, специальность, врач, датавремя
    lateinit var appointmentInfo: ArrayList<String>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activity?.title = "Запись на прием"

        slotId = arguments?.getString("slotId")!!
        appointmentInfo = arguments?.getStringArrayList("appointmentInfo")!!
        view.findViewById<Button>(R.id.frgd_registration_to_doctor_button).setOnClickListener {
            findNavController().navigate(R.id.action_doctor_RegistrationFragment_to_user_RecordsFragment)
        }
    }
}