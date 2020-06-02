package com.project.interin_app.repository.api

import com.project.interin_app.MainApplication
import com.project.interin_app.repository.slotDoctorsAppointment.ROWS
import com.project.interin_app.repository.userData.User

class DoctorsRepository {

    private val doctorApi = ApiConnect().getConnect()
    private val userDataBase = MainApplication.database.UserDao()


    suspend fun getListMedInstitution() = doctorApi.getMedInstitutions()
    suspend fun getListSlot(params: String) = getFreeSlot(doctorApi.getSlot(params).ROWS)
    suspend fun getFreeSlot(slot: List<ROWS>): List<ROWS> {
        var listSlots: MutableList<ROWS> = mutableListOf()
        slot.forEach {
            if(it.BOOK == null && it.ACTION == 1){
                listSlots.add(it)
            }
        }
        return listSlots
    }
    suspend fun getSpecializations() = doctorApi.getAllDoctors().GROUPS

    suspend fun getUserData() = userDataBase.getUser()
    suspend fun updateUserData(user: User) = userDataBase.update(user)
    suspend fun insertUserData(user: User) = userDataBase.insert(user)
    suspend fun deleteUserData(LastName: String) = userDataBase.delete(LastName)
}