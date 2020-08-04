package com.project.interin_app.repository.userData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "User"
)
data class User(
    @ColumnInfo(name = "FirstName")
    val firstName: String = "",
    @ColumnInfo(name = "LastName")
    val lastName: String = "",
    @ColumnInfo(name = "Birthday")
    val birthday: String = "",
    @ColumnInfo(name = "Phone")
    val phone: String = "",
    @ColumnInfo(name = "Email")
    val email: String = "",
    @ColumnInfo(name = "Policy")
    val policy: String = "",

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long = getId(firstName, email, policy)
) {
    companion object {
        fun getId(firstName: String?, email: String?, policy: String?): Long =
            (firstName.hashCode() + email.hashCode() + policy.hashCode()).toLong()
    }
}
