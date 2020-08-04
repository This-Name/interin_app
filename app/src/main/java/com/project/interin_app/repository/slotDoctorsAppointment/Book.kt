package com.project.interin_app.repository.slotDoctorsAppointment

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    @SerialName("CHART_ID")
    val chartId: String = "",
    @SerialName("COMMENTS")
    val comments: String = "",
    @SerialName("END")
    val end: String = "",
    @SerialName("INSTANCE")
    val instance: String = "",
    @SerialName("ORGANIZATION_ID")
    val organizationId: String = "",
    @SerialName("PARENT_ID")
    val parentId: String = "",
    @SerialName("PATIENT_BIRTHDAY")
    val patientBirthday: String = "",
    @SerialName("PATIENT_EMAIL")
    val patientEmail: String = "",
    @SerialName("PATIENT_ID")
    val patientId: String = "",
    @SerialName("PATIENT_LASTNAME")
    val patientLastname: String = "",
    @SerialName("PATIENT_NAME")
    val patientName: String = "",
    @SerialName("PATIENT_PHONE")
    val patientPhone: String = "",
    @SerialName("PAYMENT_ID")
    val paymentId: String = "",
    @SerialName("PERSON_ID")
    val personId: String = "",
    @SerialName("RESOURCE_ID")
    val resourceId: String = "",
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
