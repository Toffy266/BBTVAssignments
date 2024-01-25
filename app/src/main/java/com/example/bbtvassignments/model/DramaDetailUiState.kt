package com.example.bbtvassignments.model

import androidx.compose.runtime.setValue

data class DramaDetailUiState(
    val loading: Boolean = false,
    val success: Boolean = false,
    val error: ErrorDetail = ErrorDetail(),
    val detail: Datas = Datas(),
)
