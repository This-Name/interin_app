package com.project.interin_app.repository.api

import com.project.interin_app.MainApplication
import com.project.interin_app.repository.slotDoctorsAppointment.Slot
import com.project.interin_app.repository.userData.Records
import com.project.interin_app.repository.userData.User

class DoctorsRepository {

    private val doctorApi = MainApplication.interinApi
    private val userDataBase = MainApplication.database.UserDao()


    suspend fun getListMedInstitution() = doctorApi.getMedInstitutions()
    suspend fun getListSlot(params: String) = getFreeSlot(doctorApi.getSlot(params).slots)
    private fun getFreeSlot(slot: List<Slot>): List<Slot> {
        var listSlots: MutableList<Slot> = mutableListOf()
        slot.forEach {
            if (it.book == null && it.action == 1) {
                listSlots.add(it)
            }
        }
        return listSlots
    }

    suspend fun getSpecializations() = doctorApi.getAllDoctors().groups
    suspend fun createRecord(params: String) = doctorApi.makeRecord(params)
    suspend fun deleteRecord(params: String) = doctorApi.deleteRecord(params)

    suspend fun getUserData() = userDataBase.getUser()
    suspend fun updateUserData(user: User) = userDataBase.updateUser(user)
    suspend fun insertUserData(user: User) = userDataBase.insertUser(user)
    suspend fun deleteUserData(LastName: String) = userDataBase.deleteUser(LastName)

    suspend fun getUserRecords(): List<Records> = userDataBase.getRecords()
    suspend fun insertUserRecord(record: Records) = userDataBase.insertRecord(record)
    suspend fun deleteUserRecord(Doctor: String) = userDataBase.deleteRecord(Doctor)
}
