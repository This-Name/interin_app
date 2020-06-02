package com.project.interin_app.repository.userData

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(account: User)
    @Update
    suspend fun update(account: User)
    @Query("SELECT * FROM User")
    suspend fun getUser(): User
    @Query("DELETE FROM User WHERE LastName = :name")
    suspend fun delete(name: String)
}