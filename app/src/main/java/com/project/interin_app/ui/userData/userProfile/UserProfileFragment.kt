package com.project.interin_app.ui.userData.userProfile

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.project.interin_app.R
import com.project.interin_app.repository.userData.User
import kotlinx.coroutines.launch

class UserProfileFragment : Fragment(R.layout.fragment_user_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userProfileViewModel by viewModels<UserProfileViewModel>()

        activity?.title = R.string.profile.toString()

        //val content = userProfileViewModel.getUser()
        userProfileViewModel.getUserData()?.observe(viewLifecycleOwner, Observer {
            Log.v("UserFragment", "Get user Data")
            if (it != null) {
                view.findViewById<TextView>(R.id.fup_firstname).text = it.FirstName
                view.findViewById<TextView>(R.id.fup_lastname).text = it.LastName
                view.findViewById<TextView>(R.id.fup_birthday).text = it.Birthday
                view.findViewById<TextView>(R.id.fup_phone).text = it.Phone
                view.findViewById<TextView>(R.id.fup_email).text = it.Email
                view.findViewById<TextView>(R.id.fup_policy).text = it.Policy
            }
        })

        /*if (content != null) {
            view.findViewById<TextView>(R.id.fup_firstname).text = content.FirstName
            view.findViewById<TextView>(R.id.fup_lastname).text = content.LastName
            view.findViewById<TextView>(R.id.fup_birthday).text = content.Birthday
            view.findViewById<TextView>(R.id.fup_phone).text = content.Phone
            view.findViewById<TextView>(R.id.fup_email).text = content.Email
            view.findViewById<TextView>(R.id.fup_policy).text = content.Policy
        }*/

        view.findViewById<Button>(R.id.fup_edit_button).setOnClickListener {
            findNavController().navigate(R.id.action_user_ProfileFragment_to_user_Edit_ProfileFragment)
        }
    }
}
