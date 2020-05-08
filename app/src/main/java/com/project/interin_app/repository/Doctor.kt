package com.project.interin_app.repository

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Doctor(
    @SerialName("_DB")
    val _DB: String = "",
    @SerialName("_TYPE")
    val _TYPE: String = "",
    @SerialName("_ID")
    val _ID: String = "",
    @SerialName("_REV")
    val _REV: Int = 0,
    @SerialName("_STATUS")
    val _STATUS: Int = 0,
    @SerialName("_MODIFIED")
    val _MODIFIED: String = "",
    @SerialName("_AUTHOR")
    val _AUTHOR: String = "",
    @SerialName("PREFIX")
    val PREFIX: String = "",
    @SerialName("GROUP_ID")
    val GROUP_ID: String = "",
    @SerialName("GROUP_NAME")
    val GROUP_NAME: String = "",
    @SerialName("SPECIALITY_ID")
    val SPECIALITY_ID: String = "",
    @SerialName("SPECIALITY_NAME")
    val SPECIALITY_NAME: String = "",
    @SerialName("DOCTOR_ID")
    val DOCTOR_ID: String = "",
    @SerialName("DOCTOR_NAME")
    val DOCTOR_NAME: String = "",
    @SerialName("INSTANCE")
    val INSTANCE: String = "",
    @SerialName("INSTANCE_NAME")
    val INSTANCE_NAME: String = "",
    @SerialName("DEPARTMENT_ID")
    val DEPARTMENT_ID: String = "",
    @SerialName("DEPARTMENT_NAME")
    val DEPARTMENT_NAME: String = "",
    @SerialName("ROOM_ID")
    val ROOM_ID: String = "",
    @SerialName("ROOM_NAME")
    val ROOM_NAME: String = "",
    @SerialName("DEF_LENGTH")
    val DEF_LENGTH: String = "",
    @SerialName("RASPS_SHOW")
    val RASPS_SHOW: String = "",
    @SerialName("SEQ")
    val SEQ: String = "",
    @SerialName("DESCRIPTION")
    val DESCRIPTION: String = "",
    @SerialName("SHOW_WEB")
    val SHOW_WEB: Boolean = false,
    @SerialName("SHOW_TERMINAL")
    val SHOW_TERMINAL: Boolean = false,
    @SerialName("LIMITED")
    val LIMITED: Boolean = false,
    @SerialName("ORGANIZATION_ID")
    val ORGANIZATION_ID: String = "",
    @SerialName("ORGANIZATION")
    val ORGANIZATION: String = "",
    @SerialName("NAME")
    val NAME: String = ""
)