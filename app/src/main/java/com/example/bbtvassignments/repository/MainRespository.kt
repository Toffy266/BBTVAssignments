package com.example.bbtvassignments.repository

import com.example.bbtvassignments.service.RetrofitService
import javax.inject.Inject

class MainRepository (
    private val retrofitService: RetrofitService
) {
    suspend fun repoDrama() = retrofitService.getAllDrama()
    suspend fun repoDramaDetail() = retrofitService.getDramaDetail()
}