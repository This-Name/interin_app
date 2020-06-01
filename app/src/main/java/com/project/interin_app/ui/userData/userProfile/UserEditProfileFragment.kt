package com.project.interin_app.ui.userData.userProfile

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.project.interin_app.R

class UserEditProfileFragment  : Fragment(R.layout.fragment_user_edit_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.feup_save_button).setOnClickListener {
            findNavController().navigate(R.id.action_user_Edit_ProfileFragment_to_user_ProfileFragment)
        }
    }
}