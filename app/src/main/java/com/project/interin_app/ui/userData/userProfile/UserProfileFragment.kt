package com.project.interin_app.ui.userData.userProfile

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.project.interin_app.R

class UserProfileFragment : Fragment(R.layout.fragment_user_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userProfileViewModel by viewModels<UserProfileViewModel>()

        activity?.title = R.string.profile.toString()

        userProfileViewModel.getUserData()?.observe(viewLifecycleOwner, Observer {
            Log.v("UserFragment", "Get user Data")
            if (it != null) {
                view.findViewById<TextView>(R.id.fup_firstname).text = it.firstName
                view.findViewById<TextView>(R.id.fup_lastname).text = it.lastName
                view.findViewById<TextView>(R.id.fup_birthday).text = it.birthday
                view.findViewById<TextView>(R.id.fup_phone).text = it.phone
                view.findViewById<TextView>(R.id.fup_email).text = it.email
                view.findViewById<TextView>(R.id.fup_policy).text = it.policy
            }
        })

        view.findViewById<Button>(R.id.fup_edit_button).setOnClickListener {
            findNavController().navigate(R.id.action_user_ProfileFragment_to_user_Edit_ProfileFragment)
        }
    }
}
