package com.example.bbtvassignments.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class DramaUiState(
    var loading: Boolean = false,
    var success: Boolean = false,
    var error: ErrorDetail = ErrorDetail(),
    var data: Data = Data(),
    var recommendList: List<Drama> = listOf(),
    var top10List: List<Drama> = listOf(),
    var actorList: List<Actor> = listOf()
)