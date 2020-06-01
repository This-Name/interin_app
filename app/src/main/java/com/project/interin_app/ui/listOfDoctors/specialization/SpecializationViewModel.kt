package com.project.interin_app.ui.listOfDoctors.specialization

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.project.interin_app.repository.api.DoctorsRepository

class SpecializationViewModel(application: Application): AndroidViewModel(application) {

    suspend fun getSpecialization() = DoctorsRepository().getSpecializations()
}