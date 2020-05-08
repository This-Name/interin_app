package com.project.interin_app.repository.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiConnect() {

     fun getConnect():InterinApi = Retrofit.Builder()
            .baseUrl("https://services.interin.ru/")
            .client(OkHttpClient.Builder().addInterceptor(ResponseInterceptor()).build())
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build().create(InterinApi::class.java)
}