package com.project.interin_app.repository

import kotlinx.serialization.SerialName

data class ApiGroups(
    @SerialName ("GROUPS")
    val groups: List<Groups>,
    @SerialName("RESOURCES")
    val doctor: List<Doctor>
)
