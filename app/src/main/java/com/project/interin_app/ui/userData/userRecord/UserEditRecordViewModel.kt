package com.project.interin_app.ui.userData.userRecord

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.project.interin_app.repository.api.DoctorsRepository

class UserEditRecordViewModel(application: Application) : AndroidViewModel(application) {

    suspend fun deleteRecordAPI(params: String) = DoctorsRepository().deleteRecord(params)
    suspend fun deleteRecordDB(params: String) = DoctorsRepository().deleteUserRecord(params)
}
