package com.project.interin_app.repository.userData

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Records"
)
data class Records(
    @ColumnInfo(name = "_ID")
    val idRecord: String,
    @ColumnInfo(name = "BOOK_ID")
    val bookId: String,
    @ColumnInfo(name = "Slot_id")
    val slotId: String,
    @ColumnInfo(name = "Date")
    val date: String,
    @ColumnInfo(name = "Doctor")
    val doctor: String,
    @ColumnInfo(name = "Specialization")
    val specialization: String,
    @ColumnInfo(name = "Time")
    val time: String,

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long = getId(date, doctor, specialization)
) {
    companion object {
        fun getId(date: String?, doctor: String?, specialization: String?): Long =
            (date.hashCode() + doctor.hashCode() + specialization.hashCode()).toLong()
    }
}
