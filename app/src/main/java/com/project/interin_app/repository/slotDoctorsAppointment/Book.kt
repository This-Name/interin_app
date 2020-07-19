package com.project.interin_app.repository.slotDoctorsAppointment

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    @SerialName("CHART_ID")
    val chart_id: String = "",
    @SerialName("COMMENTS")
    val comments: String = "",
    @SerialName("END")
    val end: String = "",
    @SerialName("INSTANCE")
    val instance: String = "",
    @SerialName("ORGANIZATION_ID")
    val organization_id: String = "",
    @SerialName("PARENT_ID")
    val parent_id: String = "",
    @SerialName("PATIENT_BIRTHDAY")
    val patient_birthday: String = "",
    @SerialName("PATIENT_EMAIL")
    val patient_email: String = "",
    @SerialName("PATIENT_ID")
    val patient_id: String = "",
    @SerialName("PATIENT_LASTNAME")
    val patient_lastname: String = "",
    @SerialName("PATIENT_NAME")
    val patient_name: String = "",
    @SerialName("PATIENT_PHONE")
    val patient_phone: String = "",
    @SerialName("PAYMENT_ID")
    val payment_id: String = "",
    @SerialName("PERSON_ID")
    val person_id: String = "",
    @SerialName("RESOURCE_ID")
    val resource_id: String = "",
    @SerialName("START")
    val start: String = "",
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
)
