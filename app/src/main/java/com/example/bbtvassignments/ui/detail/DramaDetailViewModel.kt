package com.example.bbtvassignments.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bbtvassignments.model.DramaDetailModel
import com.example.bbtvassignments.repository.MainRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class DramaDetailViewModel (
    private val mainRepository: MainRepository
) : ViewModel() {

    var detail by mutableStateOf(DramaDetailModel())
        private set

    init {
        viewModelScope.launch {
            try {
                val newsItems = mainRepository.repoDramaDetail()
                if(newsItems.status ==  "success") {
                    detail = newsItems
                }
            } catch (e: Exception) {
                Timber.d(e.message.toString())
            }
        }
    }
}