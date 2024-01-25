package com.example.bbtvassignments.model

import com.google.gson.annotations.SerializedName

data class Actor(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("image_url")
    val imageURL: String = "",
    @SerializedName("actor_name")
    val actorName: String = "",
)
