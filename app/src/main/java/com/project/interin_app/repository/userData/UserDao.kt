package com.project.interin_app.repository.userData

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(account: User)
    @Update
    suspend fun updateUser(account: User)
    @Query("SELECT * FROM User")
    suspend fun getUser(): User
    @Query("DELETE FROM User WHERE LastName = :name")
    suspend fun deleteUser(name: String)

    @Query("SELECT * FROM Records")
    suspend fun getRecords() : List<Records>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecord(slot: Records)
    @Query("DELETE FROM Records WHERE Doctor = :name")
    suspend fun deleteRecord(name: String)
}