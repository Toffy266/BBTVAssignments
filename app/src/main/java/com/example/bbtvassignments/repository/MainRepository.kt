package com.example.bbtvassignments.repository

import com.example.bbtvassignments.model.DramaDetailModel
import com.example.bbtvassignments.model.DramaModel

interface MainRepository {
    suspend fun repoDrama(): DramaModel

    suspend fun repoDramaDetail(): DramaDetailModel
}
