package com.project.interin_app.ui.userData.userProfile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.project.interin_app.repository.api.DoctorsRepository

class UserProfileViewModel(application: Application): AndroidViewModel(application) {

    suspend fun getUser() = DoctorsRepository().getUserData()
}