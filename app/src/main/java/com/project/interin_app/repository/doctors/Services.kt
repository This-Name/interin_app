package com.project.interin_app.repository.doctors

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Services(
    @SerialName("ACTIVE")
    val active: Boolean,
    @SerialName("CODE")
    val code: String = "",
    @SerialName("ID")
    val id: String = "",
    @SerialName("LENGTH")
    val length: String = "",
    @SerialName("NAME")
    val name: String = "",
    @SerialName("_RN")
    val rn: Int = 0
) : Parcelable