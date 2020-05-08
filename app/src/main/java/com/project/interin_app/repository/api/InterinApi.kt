package com.project.interin_app.repository.api

import com.project.interin_app.repository.ApiGroups
import com.project.interin_app.repository.sheuduleMedInstitution.ListMedInstitution
import com.project.interin_app.repository.sheuduleMedInstitution.TestMed
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.GET

@Suppress("ComplexInterface")
interface InterinApi {
    @GET("wix.registry_api?p_resource=RESOURCE&p_method=SEARCH&p_params={}")
    suspend fun getGroups() : ApiGroups
    @GET("wix.registry_api?p_resource=SCHEDULE&p_method=SEARCH&p_params={}")
    suspend fun getMedInstitutions() : TestMed
}