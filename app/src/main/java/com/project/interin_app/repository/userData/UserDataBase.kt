package com.project.interin_app.repository.userData

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class, Records::class], version = 1)
abstract class UserDataBase : RoomDatabase() {
    abstract fun UserDao() : UserDao
}