package com.example.bbtvassignments.repository

import com.example.bbtvassignments.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getDrama() = retrofitService.getAllDrama();
    fun getDramaDetail() = retrofitService.getDramaDetail();

}