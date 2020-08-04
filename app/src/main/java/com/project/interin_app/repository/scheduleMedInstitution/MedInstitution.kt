package com.project.interin_app.repository.scheduleMedInstitution

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MedInstitution(
    @SerialName("CODE")
    val code: String,
    @SerialName("DESCRIPTION")
    val description: String,
    @SerialName("INSTANCE")
    val instance: String,
    @SerialName("INSTANCE_NAME")
    val instanceName: String,
    @SerialName("NAME")
    val name: String,
    @SerialName("ORGANIZATION")
    val organization: String,
    @SerialName("ORGANIZATION_ID")
    val organizationId: String,
    @SerialName("ROWS")
    val rows: List<String> = mutableListOf(),
    @SerialName("_AUTHOR")
    val author: String,
    @SerialName("_DB")
    val db: String,
    @SerialName("_ID")
    val id: String,
    @SerialName("_MODIFIED")
    val modified: String,
    @SerialName("_REV")
    val rev: Int,
    @SerialName("_STATUS")
    val status: Int,
    @SerialName("_TYPE")
    val type: String
)
