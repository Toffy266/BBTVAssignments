package com.example.bbtvassignments.di.module

import com.example.bbtvassignments.RetrofitService
import org.koin.dsl.module

// AppModule.kt
val appModule = module {
    single { RetrofitService.Companion }
}

