package com.project.interin_app.ui.doctorProfile.registration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.project.interin_app.repository.api.DoctorsRepository
import com.project.interin_app.repository.userData.Records
import com.project.interin_app.repository.userData.User
import com.project.interin_app.repository.userRecord.Registration

class DoctorRegistrationViewModel(application: Application): AndroidViewModel(application)  {

    suspend fun createRecord(params: String) : Registration = DoctorsRepository().createRecord(params)
    suspend fun getUser() = DoctorsRepository().getUserData()
    suspend fun insertUserRecord(record: Records) = DoctorsRepository().insertUserRecord(record)
    suspend fun updateUser(user: User) = DoctorsRepository().updateUserData(user)
}