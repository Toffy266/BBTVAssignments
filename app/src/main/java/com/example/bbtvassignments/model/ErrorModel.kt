package com.example.bbtvassignments.model

import com.google.gson.annotations.SerializedName

data class ErrorModel (
    @SerializedName("status")
    val status: String = "",
    @SerializedName("error")
    val error: ErrorDetail = ErrorDetail()
)

data class ErrorDetail (
    @SerializedName("code")
    val code: Long = 0,
    @SerializedName("message")
    val message: String = ""
)