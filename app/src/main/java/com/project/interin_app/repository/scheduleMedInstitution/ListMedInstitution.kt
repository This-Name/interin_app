package com.project.interin_app.repository.scheduleMedInstitution

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListMedInstitution(
    @SerialName("ROWS")
    val medInstitution: List<MedInstitution>
)
