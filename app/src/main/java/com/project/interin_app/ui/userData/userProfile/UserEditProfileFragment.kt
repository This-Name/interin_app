package com.project.interin_app.ui.userData.userProfile

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.project.interin_app.R

class UserEditProfileFragment : Fragment(R.layout.fragment_user_edit_profile) {
    private val userEditProfileViewModel by viewModels<UserEditProfileViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = getString(R.string.profile)
        view.findViewById<Button>(R.id.feup_save_button).setOnClickListener {
            userEditProfileViewModel.addUser(
                view.findViewById<EditText>(R.id.feup_patient_name).text.toString(),
                view.findViewById<EditText>(R.id.feup_patient_lastname).text.toString(),
                view.findViewById<EditText>(R.id.feup_patient_birthday).text.toString(),
                view.findViewById<EditText>(R.id.feup_patient_phone).text.toString(),
                view.findViewById<EditText>(R.id.feup_patient_email).text.toString(),
                view.findViewById<EditText>(R.id.feup_patient_policy).text.toString()
            )
            findNavController().navigate(R.id.action_user_Edit_ProfileFragment_to_user_ProfileFragment)
        }
    }
}
