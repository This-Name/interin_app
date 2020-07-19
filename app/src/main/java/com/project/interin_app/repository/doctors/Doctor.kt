package com.project.interin_app.repository.doctors

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Doctor(
    @SerialName("COMMENTS")
    val comments: String = "",
    @SerialName("DEF_LENGTH")
    val def_length: String = "",
    @SerialName("DEPARTMENT_ID")
    val department_id: String = "",
    @SerialName("DEPARTMENT_NAME")
    val department_name: String = "",
    @SerialName("DESCRIPTION")
    val description: String = "",
    @SerialName("DOCTOR_ID")
    val doctor_id: String = "",
    @SerialName("DOCTOR_NAME")
    val doctor_name: String = "",
    @SerialName("GROUP_ID")
    val group_id: String = "",
    @SerialName("GROUP_NAME")
    val group_name: String = "",
    @SerialName("INSTANCE")
    val instance: String = "",
    @SerialName("INSTANCE_NAME")
    val instance_name: String = "",
    @SerialName("LIMITED")
    val limited: Boolean,
    @SerialName("NAME")
    val name: String = "",
    @SerialName("ORGANIZATION")
    val organization: String = "",
    @SerialName("ORGANIZATION_ID")
    val organization_id: String = "",
    @SerialName("ORG_ID")
    val org_id: String = "",
    @SerialName("ORG_NAME")
    val org_name: String = "",
    @SerialName("PREFIX")
    val prefix: String = "",
    @SerialName("RASPS_SHOW")
    val rasps_show: String = "",
    @SerialName("ROOM_ID")
    val room_id: String = "",
    @SerialName("ROOM_NAME")
    val room_name: String = "",
    @SerialName("SEQ")
    val seq: String = "",
    @SerialName("SHOW_TERMINAL")
    val show_terminal: Boolean,
    @SerialName("SHOW_WEB")
    val show_web: Boolean,
    @SerialName("SPECIALITY_ID")
    val speciality_id: String = "",
    @SerialName("SPECIALITY_NAME")
    val speciality_name: String = "",
    @SerialName("SPEC_ID")
    val spec_id: String = "",
    @SerialName("SPEC_NAME")
    val spec_name: String = "",
    @SerialName("SRVS")
    val srvs: List<Services> = mutableListOf(),
    @SerialName("_AUTHOR")
    val author: String = "",
    @SerialName("_DB")
    val db: String = "",
    @SerialName("_ID")
    val id: String = "",
    @SerialName("_MODIFIED")
    val modified: String = "",
    @SerialName("_REV")
    val rev: Int = 0,
    @SerialName("_STATUS")
    val status: Int = 0,
    @SerialName("_TYPE")
    val type: String = ""
) : Parcelable
