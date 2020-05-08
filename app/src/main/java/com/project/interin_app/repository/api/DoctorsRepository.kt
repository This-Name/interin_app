package com.project.interin_app.repository.api

class DoctorsRepository {

    val doctorApi = ApiConnect().getConnect()

    //suspend fun getGroupsRepository() = doctorApi.getGroups().groups
    suspend fun getListMedInstitution() = doctorApi.getMedInstitutions()
}