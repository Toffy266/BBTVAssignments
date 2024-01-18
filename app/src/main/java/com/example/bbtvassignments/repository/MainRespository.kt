package com.example.bbtvassignments.repository

import com.example.bbtvassignments.service.RetrofitService
import javax.inject.Inject

class MainRepository (
    private val retrofitService: RetrofitService
) {
    suspend fun getAllDrama() = retrofitService.getAllDrama()
    suspend fun getDramaDetail(long: Long) = retrofitService.getDramaDetail(long);

}