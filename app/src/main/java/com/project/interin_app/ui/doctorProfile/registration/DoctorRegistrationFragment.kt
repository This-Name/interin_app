package com.project.interin_app.ui.doctorProfile.registration

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.widget.Toast.makeText
import com.project.interin_app.R

class DoctorRegistrationFragment : Fragment(R.layout.fragment_registration_doctor) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.frgd_registration_to_doctor_button).setOnClickListener {
            makeText(this.context, "Вы успешно записаны!", Toast.LENGTH_SHORT).setGravity(
                Gravity.CENTER, 0, 0)
        }
    }
}