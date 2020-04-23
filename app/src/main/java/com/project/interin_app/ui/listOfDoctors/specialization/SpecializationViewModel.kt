package com.project.interin_app.ui.listOfDoctors.specialization

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class SpecializationViewModel(application: Application): AndroidViewModel(application) {

    fun getSpecialization(): ArrayList<String> {
        val specialization = ArrayList<String>()
        specialization.add("Окулист")
        specialization.add("Терапевт")
        specialization.add("Хирург")
        specialization.add("Невролог")
        return specialization;
    }
}