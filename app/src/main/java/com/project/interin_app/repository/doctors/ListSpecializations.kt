package com.project.interin_app.repository.doctors

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListSpecializations(
    @SerialName("GROUPS")
    val groups: List<Specialization>,
    @SerialName("ID")
    val id: String = ""
)
