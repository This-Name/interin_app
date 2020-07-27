package com.project.interin_app.repository.slotDoctorsAppointment

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Slot(
    @SerialName("ACTION")
    val action: Int = 0,
    @SerialName("ACTION_CSS")
    val actionCss: String = "",
    @SerialName("ACTION_NAME")
    val actionName: String = "",
    @SerialName("BOOK")
    val book: Book = Book(),
    @SerialName("DATE_SHOW")
    val dateShow: String = "",
    @SerialName("DEPARTMENT")
    val department: String = "",
    @SerialName("DOCTOR")
    val doctor: String = "",
    @SerialName("END")
    val end: String = "",
    @SerialName("GROUP")
    val group: String = "",
    @SerialName("ID")
    val id: String = "",
    @SerialName("INSTANCE")
    val instance: String = "",
    @SerialName("INSTANCE_NAME")
    val instanceName: String = "",
    @SerialName("ORGANIZATION_ID")
    val organizationId: String = "",
    @SerialName("RESOURCE_ID")
    val resourceId: String = "",
    @SerialName("ROOM")
    val room: String = "",
    @SerialName("SPECIALITY")
    val speciality: String = "",
    @SerialName("START")
    val start: String = "",
    @SerialName("STATE")
    val state: Int = 0,
    @SerialName("STATE_NAME")
    val stateName: String = "",
    @SerialName("TIME_SHOW")
    val timeShow: String = "",
    @SerialName("TYPE")
    val type: String = ""
)
