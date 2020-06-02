package com.project.interin_app.repository.api

import com.project.interin_app.repository.doctors.AllDoctors
import com.project.interin_app.repository.sheuduleMedInstitution.TestMed
import com.project.interin_app.repository.slotDoctorsAppointment.Slots
import retrofit2.http.GET
import retrofit2.http.Query

@Suppress("ComplexInterface")
interface InterinApi {
    @GET("wix.registry_api?p_resource=SCHEDULE&p_method=SEARCH&p_params={}")
    suspend fun getMedInstitutions() : TestMed
    @GET("wix.registry_api?p_resource=RESOURCE&p_method=SEARCH&p_params={}")
    suspend fun getAllDoctors() : AllDoctors
//    @GET("wix.registry_api?p_resource=SLOT&p_method=SEARCH&p_params={SCHEDULE_ID:\"7FA39CC10D36087CE0530100007F1682\",RESOURCE_ID:\"7FA60CCEEFE36563E0530100007FA9EB\",BDATE:\"20.05.2020\",EDATE:\"20.05.2020\"}")
    @GET("wix.registry_api?p_resource=SLOT&p_method=SEARCH")
    suspend fun getSlot(@Query("p_params") params: String) : Slots
}