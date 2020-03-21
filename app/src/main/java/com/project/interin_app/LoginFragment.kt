package com.project.interin_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment(R.layout.fragment_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.fl_login_button).setOnClickListener {
            startActivity(Intent(activity, ListOfDoctors::class.java))
        }
        activity?.title = "Авторизация"
        view.findViewById<Button>(R.id.fl_registration_button).setOnClickListener{
            activity?.title = "Регистрация"
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }

}