package com.example.bbtvassignments.service

import com.example.bbtvassignments.model.DramaDetailModel
import com.example.bbtvassignments.model.DramaModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("v3/89fece46-6107-4c0d-a31d-6e44dd8bbb14")
    suspend fun getAllDrama(): DramaModel

    @GET("v3/b9920552-3626-4cbe-a6d9-c43c757933df")
    suspend fun getDramaDetail(): DramaDetailModel

    companion object {
        private const val BASE_URL = "https://run.mocky.io/"
        private var retrofitAPI: RetrofitService? = null

        fun getInstance(): RetrofitService {
            if (retrofitAPI == null) {
                val retrofit =
                    Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                retrofitAPI = retrofit.create(RetrofitService::class.java)
            }
            return retrofitAPI!!
        }
    }
}
