package com.example.bbtvassignments.model

import com.google.gson.annotations.SerializedName

data class DramaModel (
    @SerializedName("status")
    val status: String = "",
    @SerializedName("data")
    val data: Data = Data()
)

data class Data (
    @SerializedName("banner")
    val banner: Banner = Banner(),
    @SerializedName("infos")
    val infos: List<Info> = listOf()
)

data class Banner (
    @SerializedName("image_url")
    val imageURL: String = "",
    @SerializedName("title")
    val title: String = ""
)

data class Info (
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("category_title")
    val categoryTitle: String = "",
    @SerializedName("dramas")
    val dramas: List<Drama> = listOf(),
    @SerializedName("actor")
    val actor: List<Actor> = listOf()
)

data class Actor (
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("image_url")
    val imageURL: String = "",
    @SerializedName("actor_name")
    val actorName: String = ""
)

data class Drama (
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("image_url")
    val imageURL: String = "",
    @SerializedName("tag")
    val tag: String = "",
    @SerializedName("title")
    val title: String = ""
)