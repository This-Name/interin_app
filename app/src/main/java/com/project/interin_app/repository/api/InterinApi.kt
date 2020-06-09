package com.project.interin_app.repository.api

import com.project.interin_app.repository.doctors.AllDoctors
import com.project.interin_app.repository.sheuduleMedInstitution.TestMed
import com.project.interin_app.repository.slotDoctorsAppointment.Slots
import com.project.interin_app.repository.userRecord.Registration
import retrofit2.http.GET
import retrofit2.http.Query

@Suppress("ComplexInterface")
interface InterinApi {
    @GET("wix.registry_api?p_resource=SCHEDULE&p_method=SEARCH&p_params={}")
    suspend fun getMedInstitutions() : TestMed
    @GET("wix.registry_api?p_resource=RESOURCE&p_method=SEARCH&p_params={}")
    suspend fun getAllDoctors() : AllDoctors
    @GET("wix.registry_api?p_resource=SLOT&p_method=SEARCH")
    suspend fun getSlot(@Query("p_params") params: String) : Slots
    @GET("wix.registry_api?p_resource=APPOINTMENT&p_method=CREATE")
    suspend fun makeRecord(@Query("p_params") params: String) : Registration
}