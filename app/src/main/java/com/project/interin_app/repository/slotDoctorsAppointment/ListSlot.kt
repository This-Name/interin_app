package com.project.interin_app.repository.slotDoctorsAppointment

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListSlot(
    @SerialName("ROWS")
    val slots: List<Slot>
)
