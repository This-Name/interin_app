package com.project.interin_app.repository.api

import com.project.interin_app.repository.doctors.GROUPS
import com.project.interin_app.repository.doctors.RESOURCES
import com.project.interin_app.repository.slotDoctorsAppointment.ROWS

class DoctorsRepository {

    val doctorApi = ApiConnect().getConnect()

    //suspend fun getGroupsRepository() = doctorApi.getGroups().groups
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
    /*suspend fun getDoctors() = getOnlyDoctors(doctorApi.getAllDoctors().GROUPS)
    suspend fun getOnlyDoctors(spec: List<GROUPS>) : List<GROUPS> {
        var listSpec: MutableList<GROUPS> = mutableListOf()
        spec.forEach {
            it.RESOURCES.forEach {
                it.
            }
        }
        return listSpec
    }*/
}