package com.project.interin_app.repository.userData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "User"
)
data class User(
    @ColumnInfo(name = "FirstName")
    val FirstName: String = "",
    @ColumnInfo(name = "LastName")
    val LastName: String = "",
    @ColumnInfo(name = "Birthday")
    val Birthday: String = "",
    @ColumnInfo(name = "Phone")
    val Phone: String = "",
    @ColumnInfo(name = "Email")
    val Email: String = "",
    @ColumnInfo(name = "Policy")
    val Policy: String = "",

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long = getId(FirstName, Email, Policy)
) {
    companion object {
        fun getId(FirstName: String?, Email: String?, Policy: String?): Long =
            (FirstName.hashCode() + Email.hashCode() + Policy.hashCode()).toLong()
    }
}