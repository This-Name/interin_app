package com.project.interin_app.ui.doctorProfile.registration

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.project.interin_app.R

class DoctorRegistrationFragment : Fragment(R.layout.fragment_registration_doctor) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.frgd_registration_to_doctor_button).setOnClickListener {
            findNavController().navigate(R.id.action_doctor_RegistrationFragment_to_user_RecordsFragment)
        }
    }
}