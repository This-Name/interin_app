package com.project.interin_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class RegistrationFragment : Fragment(R.layout.fragment_registration) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.fr_registration_button).setOnClickListener {
            startActivity(Intent(activity, ListOfDoctors::class.java))
        }
    }
}