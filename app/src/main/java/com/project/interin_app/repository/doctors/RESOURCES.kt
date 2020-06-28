package com.project.interin_app.repository.doctors

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RESOURCES(
    val COMMENTS: String,
    val DEF_LENGTH: String,
    val DEPARTMENT_ID: String,
    val DEPARTMENT_NAME: String,
    val DESCRIPTION: String,
    val DOCTOR_ID: String,
    val DOCTOR_NAME: String,
    val GROUP_ID: String,
    val GROUP_NAME: String,
    val INSTANCE: String,
    val INSTANCE_NAME: String,
    val LIMITED: Boolean,
    val NAME: String,
    val ORGANIZATION: String,
    val ORGANIZATION_ID: String,
    val ORG_ID: String,
    val ORG_NAME: String,
    val PREFIX: String,
    val RASPS_SHOW: String,
    val ROOM_ID: String,
    val ROOM_NAME: String,
    val SEQ: String,
    val SHOW_TERMINAL: Boolean,
    val SHOW_WEB: Boolean,
    val SPECIALITY_ID: String,
    val SPECIALITY_NAME: String,
    val SPEC_ID: String,
    val SPEC_NAME: String,
    val SRVS: List<SRVS>,
    val _AUTHOR: String,
    val _DB: String,
    val _ID: String,
    val _MODIFIED: String,
    val _REV: Int,
    val _STATUS: Int,
    val _TYPE: String
) : Parcelable