package com.example.bbtvassignments.repository

import com.example.bbtvassignments.model.DramaDetailModel
import com.example.bbtvassignments.model.DramaModel
import com.example.bbtvassignments.model.ErrorModel
import com.example.bbtvassignments.service.RetrofitService

class MainRepositoryImpl (
    private val retrofitService: RetrofitService
) : MainRepository {
    override suspend fun repoDrama(): DramaModel {
        return retrofitService.getAllDrama()
    }
    override suspend fun repoDramaDetail(): DramaDetailModel {
        return retrofitService.getDramaDetail()
    }
    override suspend fun repoError(): ErrorModel {
        return retrofitService.getError()
    }
}