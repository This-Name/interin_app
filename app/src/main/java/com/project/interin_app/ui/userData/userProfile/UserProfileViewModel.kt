package com.project.interin_app.ui.userData.userProfile

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.project.interin_app.repository.api.DoctorsRepository
import com.project.interin_app.repository.userData.User
import kotlinx.coroutines.launch

class UserProfileViewModel(application: Application) : AndroidViewModel(application) {

    var data: LiveData<User>? = null

    fun getUserData(): LiveData<User>? {
        if (data == null) {
            viewModelScope.launch {
                data = getUser()
                Log.v("UserViewModel", "load data DB")
            }
        }
        Log.v("UserViewModel", "return data")
        return data
    }

    private suspend fun getUser() = DoctorsRepository().getUserData()
}
