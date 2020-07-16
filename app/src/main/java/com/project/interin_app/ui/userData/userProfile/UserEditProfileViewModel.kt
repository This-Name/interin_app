package com.project.interin_app.ui.userData.userProfile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.project.interin_app.repository.api.DoctorsRepository
import com.project.interin_app.repository.userData.User
import kotlinx.coroutines.launch

class UserEditProfileViewModel(application: Application) : AndroidViewModel(application) {

    fun addUser(
        FirstName: String,
        LastName: String,
        Birthday: String,
        Phone: String,
        Email: String,
        Policy: String
    ) = viewModelScope.launch {
        DoctorsRepository().insertUserData(
            User(FirstName, LastName, Birthday, Phone, Email, Policy)
        )
    }
}
