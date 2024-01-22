package com.example.bbtvassignments.model

import com.google.gson.annotations.SerializedName

data class ErrorModel (
    @SerializedName("status")
    val status: String = "",
    @SerializedName("error")
    val error: Error = Error()
)

data class Error (
    @SerializedName("code")
    val code: Long = 0,
    @SerializedName("message")
    val message: String = ""
)