package com.example.bbtvassignments.service

import com.example.bbtvassignments.model.DramaDetailModel
import com.example.bbtvassignments.model.DramaModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("89fece46-6107-4c0d-a31d-6e44dd8bbb14")
    suspend fun getAllDrama(): DramaModel

    @GET("b9920552-3626-4cbe-a6d9-c43c757933df")
    suspend fun getDramaDetail(): DramaDetailModel

    companion object {
        private const val BaseURL = "https://run.mocky.io/v3/"
        private var retrofitAPI : RetrofitService? = null

        fun getInstance(): RetrofitService {
            if(retrofitAPI == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BaseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitAPI  = retrofit.create(RetrofitService ::class.java)
            }
            return retrofitAPI!!
        }
    }
}