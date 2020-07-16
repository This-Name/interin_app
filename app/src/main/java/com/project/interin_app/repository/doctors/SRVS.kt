package com.project.interin_app.repository.doctors

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SRVS(
    val ACTIVE: Boolean,
    val CODE: String,
    val ID: String,
    val LENGTH: String,
    val NAME: String,
    val _RN: Int
) : Parcelable
