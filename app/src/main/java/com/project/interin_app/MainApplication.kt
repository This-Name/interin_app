package com.project.interin_app

import android.app.Application
import androidx.room.Room
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.project.interin_app.repository.api.InterinApi
import com.project.interin_app.repository.userData.UserDataBase
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, UserDataBase::class.java, "database").build()
        interinApi = Retrofit.Builder()
            .baseUrl("https://services.interin.ru/")
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build().create(InterinApi::class.java)
    }

    companion object {
        lateinit var instance: Application
        lateinit var database: UserDataBase
        lateinit var interinApi: InterinApi
    }
}
