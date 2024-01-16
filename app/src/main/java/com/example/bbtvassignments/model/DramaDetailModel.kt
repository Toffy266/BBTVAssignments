package com.example.bbtvassignments.model

data class DramaDetailModel (
    val status: String,
    val data: List<Datas>
)

data class Datas (
    val id: Long,
    val imageURL: String,
    val title: String,
    val type: String,
    val synopsis: String,
    val actors: List<Actors>,
    val episodes: List<Episode>
)

data class Actors (
    val id: Long,
    val imageURL: String,
    val actorName: String
)

data class Episode (
    val id: Long,
    val imageURL: String,
    val title: String,
    val detail: String
)
