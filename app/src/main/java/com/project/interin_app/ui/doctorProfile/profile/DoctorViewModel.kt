package com.project.interin_app.ui.doctorProfile.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.project.interin_app.repository.api.DoctorsRepository

class DoctorViewModel(application: Application): AndroidViewModel(application) {

    suspend fun getListFreeSlots() = DoctorsRepository().getListSlot()
}