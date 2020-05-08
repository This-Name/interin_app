package com.project.interin_app.ui.listOfDoctors.institution

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.project.interin_app.repository.api.DoctorsRepository

class InstitutionViewModel(application: Application): AndroidViewModel(application)  {

    suspend fun getMedInstitution() = DoctorsRepository()
        .getListMedInstitution()
}