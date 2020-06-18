package com.project.interin_app.ui.userData.userProfile

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.project.interin_app.R
import kotlinx.coroutines.launch

class UserProfileFragment  : Fragment(R.layout.fragment_user_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userProfileViewModel by viewModels<UserProfileViewModel>()

        activity?.title = "Профиль"

        viewLifecycleOwner.lifecycleScope.launch {
            val content = userProfileViewModel.getUser()
            if(content != null) {
                view.findViewById<TextView>(R.id.fup_firstname).setText(content.FirstName)
                view.findViewById<TextView>(R.id.fup_lastname).setText(content.LastName)
                view.findViewById<TextView>(R.id.fup_birthday).setText(content.Birthday)
                view.findViewById<TextView>(R.id.fup_phone).setText(content.Phone)
                view.findViewById<TextView>(R.id.fup_email).setText(content.Email)
                view.findViewById<TextView>(R.id.fup_policy).setText(content.Policy)
            }
        }
        view.findViewById<Button>(R.id.fup_edit_button).setOnClickListener {
            findNavController().navigate(R.id.action_user_ProfileFragment_to_user_Edit_ProfileFragment)
        }
    }
}