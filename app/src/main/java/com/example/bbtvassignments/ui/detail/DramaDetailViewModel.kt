package com.example.bbtvassignments.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bbtvassignments.repository.MainRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class DramaDetailViewModel (
    private val mainRepository: MainRepository
) : ViewModel() {
    fun fetchDramaDetailData() {
        viewModelScope.launch {
            try {

            } catch (e: Exception) {
                Timber.d(e.message.toString())
            }
        }
    }

}