package com.project.interin_app.repository.doctors

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Specialization(
    @SerialName("CODE")
    val code: String = "",
    @SerialName("DEL_TITLE")
    val del_title: String = "",
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
    val status_text: String = "",
    @SerialName("_AUTHOR")
    val author: String = "",
    @SerialName("_DB")
    val db: String = "",
    @SerialName("_ID")
    val _id: String = "",
    @SerialName("_MODIFIED")
    val modified: String = "",
    @SerialName("_REV")
    val rev: Int = 0,
    @SerialName("_STATUS")
    val _status: Int = 0,
    @SerialName("_TYPE")
    val type: String = ""
)
