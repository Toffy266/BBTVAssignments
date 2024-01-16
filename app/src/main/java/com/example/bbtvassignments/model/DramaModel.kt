package com.example.bbtvassignments.model

data class DramaModel (
    val status: String,
    val data: Data
)

data class Data (
    val banner: Banner,
    val infos: List<Info>
)

data class Banner (
    val imageURL: String,
    val title: String
)

data class Info (
    val id: Long,
    val categoryTitle: String,
    val dramas: List<Drama>? = null,
    val actor: List<Actor>? = null
)

data class Actor (
    val id: Long,
    val imageURL: String,
    val actorName: String
)

data class Drama (
    val id: Long,
    val imageURL: String,
    val tag: String? = null,
    val title: String? = null
)