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
    val defLength: String = "",
    @SerialName("DEPARTMENT_ID")
    val departmentId: String = "",
    @SerialName("DEPARTMENT_NAME")
    val departmentName: String = "",
    @SerialName("DESCRIPTION")
    val description: String = "",
    @SerialName("DOCTOR_ID")
    val doctorId: String = "",
    @SerialName("DOCTOR_NAME")
    val doctorName: String = "",
    @SerialName("GROUP_ID")
    val groupId: String = "",
    @SerialName("GROUP_NAME")
    val groupName: String = "",
    @SerialName("INSTANCE")
    val instance: String = "",
    @SerialName("INSTANCE_NAME")
    val instanceName: String = "",
    @SerialName("LIMITED")
    val limited: Boolean,
    @SerialName("NAME")
    val name: String = "",
    @SerialName("ORGANIZATION")
    val organization: String = "",
    @SerialName("ORGANIZATION_ID")
    val organizationId: String = "",
    @SerialName("ORG_ID")
    val orgId: String = "",
    @SerialName("ORG_NAME")
    val orgName: String = "",
    @SerialName("PREFIX")
    val prefix: String = "",
    @SerialName("RASPS_SHOW")
    val raspsShow: String = "",
    @SerialName("ROOM_ID")
    val roomId: String = "",
    @SerialName("ROOM_NAME")
    val roomName: String = "",
    @SerialName("SEQ")
    val seq: String = "",
    @SerialName("SHOW_TERMINAL")
    val showTerminal: Boolean,
    @SerialName("SHOW_WEB")
    val showWeb: Boolean,
    @SerialName("SPECIALITY_ID")
    val specialityId: String = "",
    @SerialName("SPECIALITY_NAME")
    val specialityName: String = "",
    @SerialName("SPEC_ID")
    val specId: String = "",
    @SerialName("SPEC_NAME")
    val specName: String = "",
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
