package com.project.interin_app.ui.doctorProfile.registration

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.project.interin_app.repository.api.DoctorsRepository
import com.project.interin_app.repository.userData.Records
import com.project.interin_app.repository.userData.User
import com.project.interin_app.repository.userRecord.Registration
import kotlinx.coroutines.launch

class DoctorRegistrationViewModel(application: Application) : AndroidViewModel(application) {

    var data: LiveData<User>? = null

    fun getUserData(): LiveData<User>? {
        if (data == null) {
            viewModelScope.launch {
                data = getUser()
            }
        }
        return data
    }

    suspend fun createRecord(params: String): Registration =
        DoctorsRepository().createRecord(params)

    private suspend fun getUser() = DoctorsRepository().getUserData()
    suspend fun insertUserRecord(record: Records) = DoctorsRepository().insertUserRecord(record)
    suspend fun updateUser(user: User) = DoctorsRepository().updateUserData(user)
}
