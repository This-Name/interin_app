package com.project.interin_app.repository.api

import androidx.lifecycle.LiveData
import com.project.interin_app.MainApplication
import com.project.interin_app.repository.slotDoctorsAppointment.Slot
import com.project.interin_app.repository.userData.Records
import com.project.interin_app.repository.userData.User

class DoctorsRepository {

    private val doctorApi = MainApplication.api
    private val userDataBase = MainApplication.database.userDao()

    suspend fun getListMedInstitution() = doctorApi.getMedInstitutions()
    suspend fun getListSlot(params: String) = getFreeSlot(doctorApi.getSlot(params).slots)
    private fun getFreeSlot(slot: List<Slot>): List<Slot> {
        val listSlots: MutableList<Slot> = mutableListOf()
        slot.forEach {
            if (it.action == 1) {
                listSlots.add(it)
            }
        }
        return listSlots
    }

    suspend fun getSpecializations(params: String) = doctorApi.getAllDoctors(params).groups
    suspend fun createRecord(params: String) = doctorApi.makeRecord(params)
    suspend fun deleteRecord(params: String) = doctorApi.deleteRecord(params)

    fun getUserData() = userDataBase.getUser()
    suspend fun updateUserData(user: User) = userDataBase.updateUser(user)
    suspend fun insertUserData(user: User) = userDataBase.insertUser(user)
    suspend fun deleteUserData(lastName: String) = userDataBase.deleteUser(lastName)

    fun getUserRecords(): LiveData<List<Records>> = userDataBase.getRecords()
    suspend fun insertUserRecord(record: Records) = userDataBase.insertRecord(record)
    suspend fun deleteUserRecord(doctor: String) = userDataBase.deleteRecord(doctor)
}
