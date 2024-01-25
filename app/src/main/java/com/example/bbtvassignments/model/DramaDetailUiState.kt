package com.example.bbtvassignments.model

import androidx.compose.runtime.setValue

data class DramaDetailUiState(
    val loading: Boolean = false,
    val success: Datas = Datas(),
    val error: ErrorDetail = ErrorDetail(),
)