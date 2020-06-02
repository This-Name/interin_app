package com.project.interin_app

import android.app.Application
import androidx.room.Room
import com.project.interin_app.repository.userData.UserDataBase

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, UserDataBase::class.java,"database").build()
    }
    companion object {
        lateinit var instance: Application
        lateinit var database: UserDataBase
    }
}