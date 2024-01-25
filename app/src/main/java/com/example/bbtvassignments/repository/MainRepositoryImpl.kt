package com.example.bbtvassignments.repository

import com.example.bbtvassignments.model.DramaDetailModel
import com.example.bbtvassignments.model.DramaModel
import com.example.bbtvassignments.service.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepositoryImpl(
    private val retrofitService: RetrofitService,
) : MainRepository {
    override suspend fun repoDrama(): DramaModel {
        return withContext(Dispatchers.IO) {
            retrofitService.getAllDrama()
        }
    }

    override suspend fun repoDramaDetail(): DramaDetailModel {
        return withContext(Dispatchers.IO) {
            retrofitService.getDramaDetail()
        }
    }
}
