package com.project.interin_app

import android.app.Application
import androidx.room.Room
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.project.interin_app.repository.api.InterinApi
import com.project.interin_app.repository.userData.UserDataBase
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import net.danlew.android.joda.JodaTimeAndroid
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //JodaTimeAndroid.init(this)
        instance = this
        database = Room.databaseBuilder(this, UserDataBase::class.java, "database").build()
        interinApi = Retrofit.Builder()
            .baseUrl("https://services.interin.ru/")
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(Json(JsonConfiguration(isLenient = true, ignoreUnknownKeys = true)).asConverterFactory(MediaType.get("application/json")))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build().create(InterinApi::class.java)
    }

    companion object {
        lateinit var instance: Application
        lateinit var database: UserDataBase
        lateinit var interinApi: InterinApi
    }
}
