package com.example.bbtvassignments.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

data class DramaUiState(
    val loading: Boolean = false,
    val success: Boolean = false,
    val error: ErrorDetail = ErrorDetail(),
    val data: Data = Data(),
    val recommendList: List<Drama> = listOf(),
    val top10List: List<Drama> = listOf(),
    val actorList: List<Actor> = listOf(),
)
