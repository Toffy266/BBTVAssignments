package com.example.bbtvassignments.di.module

import com.example.bbtvassignments.service.RetrofitService
import com.example.bbtvassignments.repository.MainRepository
import com.example.bbtvassignments.ui.detail.DramaDetailViewModel
import com.example.bbtvassignments.ui.drama.DramaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { RetrofitService }
    single { MainRepository(get()) }
    viewModel { DramaViewModel(get()) }
    viewModel { DramaDetailViewModel(get()) }
}

