package com.project.interin_app.ui.userData.userRecord

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.project.interin_app.repository.api.DoctorsRepository
import com.project.interin_app.repository.userData.Records
import kotlinx.coroutines.launch

class UserRecordsViewModel(application: Application) : AndroidViewModel(application) {

    var data: LiveData<List<Records>>? = null

    fun getUserData(): LiveData<List<Records>>? {
        if (data == null) {
            viewModelScope.launch {
                data = getRecords()
            }
        }
        return data
    }

    private suspend fun getRecords() = DoctorsRepository().getUserRecords()
}
