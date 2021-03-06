package com.project.interin_app.repository.doctors

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Specialization(
    @SerialName("CODE")
    val code: String = "",
    @SerialName("DEL_TITLE")
    val delTitle: String = "",
    @SerialName("ID")
    val id: String = "",
    @SerialName("NAME")
    val name: String = "",
    @SerialName("RESOURCES")
    val resources: ArrayList<Doctor>,
    @SerialName("SEQ")
    val seq: String = "",
    @SerialName("STATUS")
    val status: String = "",
    @SerialName("STATUS_TEXT")
    val statusText: String = "",
    @SerialName("_AUTHOR")
    val author: String = "",
    @SerialName("_DB")
    val db: String = "",
    @SerialName("_ID")
    val idSpc: String = "",
    @SerialName("_MODIFIED")
    val modified: String = "",
    @SerialName("_REV")
    val rev: Int = 0,
    @SerialName("_STATUS")
    val statusSpc: Int = 0,
    @SerialName("_TYPE")
    val type: String = ""
)
