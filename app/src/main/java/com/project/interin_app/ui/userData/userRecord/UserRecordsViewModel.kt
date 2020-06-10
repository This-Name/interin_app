package com.project.interin_app.ui.userData.userRecord

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.project.interin_app.repository.api.DoctorsRepository

class UserRecordsViewModel(application: Application): AndroidViewModel(application) {

    suspend fun getRecords() = DoctorsRepository().getUserRecords()
}