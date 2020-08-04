package com.project.interin_app.repository.userData

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "Records"
)
data class Records(
    @PrimaryKey
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
    @ColumnInfo(name = "Institution")
    val institution: String

) : Parcelable
