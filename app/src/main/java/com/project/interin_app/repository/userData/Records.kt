package com.project.interin_app.repository.userData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.project.interin_app.repository.userRecord.Registration

@Entity(
    tableName = "Records"
)
data class Records(
    @ColumnInfo(name = "_ID")
    val _ID: String,
    @ColumnInfo(name = "BOOK_ID")
    val BOOK_ID: String,
    @ColumnInfo(name = "Slot_id")
    val Slot_id: String,
    @ColumnInfo(name = "Date")
    val Date: String,
    @ColumnInfo(name = "Doctor")
    val Doctor: String,
    @ColumnInfo(name = "Specialization")
    val Specialization: String,
    @ColumnInfo(name = "Time")
    val Time: String,

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long = getId(Date, Doctor, Specialization)
) {
    companion object {
        fun getId(Date: String?, Doctor: String?, Specialization: String?): Long =
            (Date.hashCode() + Doctor.hashCode() + Specialization.hashCode()).toLong()
    }
}
