package com.project.interin_app.repository.userData

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.OnConflictStrategy
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(account: User)

    @Update
    suspend fun updateUser(account: User)

    @Query("SELECT * FROM User")
    fun getUser(): LiveData<User>

    @Query("DELETE FROM User WHERE LastName = :name")
    suspend fun deleteUser(name: String)

    @Query("SELECT * FROM Records")
    fun getRecords(): LiveData<List<Records>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecord(slot: Records)

    @Query("DELETE FROM Records WHERE Doctor = :name")
    suspend fun deleteRecord(name: String)
}
