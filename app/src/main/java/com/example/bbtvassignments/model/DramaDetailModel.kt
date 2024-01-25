package com.example.bbtvassignments.model

import com.google.gson.annotations.SerializedName

data class DramaDetailModel(
    @SerializedName("status")
    val status: String = "",
    @SerializedName("data")
    val data: List<Datas> = listOf(),
    @SerializedName("error")
    val error: ErrorDetail = ErrorDetail(),
)

data class Datas(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("image_url")
    val imageURL: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("type")
    val type: String = "",
    @SerializedName("synopsis")
    val synopsis: String = "",
    @SerializedName("actors")
    val actors: List<Actor> = listOf(),
    @SerializedName("episodes")
    val episodes: List<Episode> = listOf(),
)

data class Episode(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("image_url")
    val imageURL: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("detail")
    val detail: String = "",
)
