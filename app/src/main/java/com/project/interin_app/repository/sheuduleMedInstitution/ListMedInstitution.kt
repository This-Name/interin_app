package com.project.interin_app.repository.sheuduleMedInstitution

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListMedInstitution(
    @SerialName("ROWS")
    val medInstitution: List<MedInstitution>
)
