package com.project.interin_app.repository

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Groups(
    @SerialName("_DB")
    val _DB: String = "",
    @SerialName("_TYPE")
    val _TYPE: String = "",
    @SerialName("_ID")
    val _ID: String = "",
    @SerialName("_REV")
    val _REV: Int = 0,
    @SerialName("_STATUS")
    val _STATUS: Int = 0,
    @SerialName("_MODIFIED")
    val _MODIFIED: String = "",
    @SerialName("_AUTHOR")
    val _AUTHOR: String = "",
    @SerialName("STATUS")
    val STATUS: Boolean = false,
    @SerialName("STATUS_TEXT")
    val STATUS_TEXT: String = "",
    @SerialName("DEL_TITLE")
    val DEL_TITLE: String = "",
    @SerialName("NAME")
    val NAME: String = "",
    @SerialName("CODE")
    val CODE: String = "",
    @SerialName("SEQ")
    val SEQ: String = "",
    @SerialName("ID")
    val ID: String = "",
    @SerialName("RESOURCES")
    val RESOURCES: List<Doctor>
)
