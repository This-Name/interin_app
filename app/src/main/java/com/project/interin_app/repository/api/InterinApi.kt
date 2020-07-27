package com.project.interin_app.repository.api

import com.project.interin_app.repository.doctors.ListSpecializations
import com.project.interin_app.repository.sheuduleMedInstitution.ListMedInstitution
import com.project.interin_app.repository.slotDoctorsAppointment.ListSlot
import com.project.interin_app.repository.userRecord.Registration
import retrofit2.http.GET
import retrofit2.http.Query

@Suppress("ComplexInterface")
interface InterinApi {
    @GET("wix.registry_api?p_resource=SCHEDULE&p_method=SEARCH&p_params={}")
    suspend fun getMedInstitutions(): ListMedInstitution

    @GET("wix.registry_api?p_resource=RESOURCE&p_method=SEARCH")
    suspend fun getAllDoctors(@Query("p_params") params: String): ListSpecializations

    @GET("wix.registry_api?p_resource=SLOT&p_method=SEARCH")
    suspend fun getSlot(@Query("p_params") params: String): ListSlot

    @GET("wix.registry_api?p_resource=APPOINTMENT&p_method=CREATE")
    suspend fun makeRecord(@Query("p_params") params: String): Registration

    @GET("wix.registry_api?p_resource=APPOINTMENT&p_method=DELETE")
    suspend fun deleteRecord(@Query("p_params") params: String)
}
