package com.project.interin_app.repository.sheuduleMedInstitution

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MedInstitution(
    @SerialName("CODE")
    val CODE: String = "",
    @SerialName("DESCRIPTION")
    val DESCRIPTION: String = "",
    @SerialName("INSTANCE")
    val INSTANCE: String = "",
    @SerialName("INSTANCE_NAME")
    val INSTANCE_NAME: String = "",
    @SerialName("NAME")
    val NAME: String = "",
    @SerialName("ORGANIZATION")
    val ORGANIZATION: String = "",
    @SerialName("ORGANIZATION_ID")
    val ORGANIZATION_ID: String = "",
    @SerialName("ROWS")
    val ROWS: List<Any>,
    @SerialName("_AUTHOR")
    val _AUTHOR: String = "",
    @SerialName("_DB")
    val _DB: String = "",
    @SerialName("_ID")
    val _ID: String = "",
    @SerialName("_MODIFIED")
    val _MODIFIED: String = "",
    @SerialName("_REV")
    val _REV: Int = 0,
    @SerialName("_STATUS")
    val _STATUS: Int = 0,
    @SerialName("_TYPE")
    val _TYPE: String = ""
)
