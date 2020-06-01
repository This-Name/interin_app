package com.project.interin_app.ui.userData.userProfile

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.project.interin_app.R

class UserProfileFragment  : Fragment(R.layout.fragment_user_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.fup_edit_button).setOnClickListener {
            findNavController().navigate(R.id.action_user_ProfileFragment_to_user_Edit_ProfileFragment)
        }
    }
}