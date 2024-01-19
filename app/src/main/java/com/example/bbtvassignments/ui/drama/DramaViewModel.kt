package com.example.bbtvassignments.ui.drama

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bbtvassignments.model.DramaModel
import com.example.bbtvassignments.repository.MainRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class DramaViewModel(
    private val mainRepository: MainRepository
) : ViewModel() {

    var drama by mutableStateOf(DramaModel())
        private set

    init {
        viewModelScope.launch {
            try {
                val newsItems = mainRepository.repoDrama()
                if(newsItems.status ==  "success") {
                    drama = newsItems
                }
            } catch (e: Exception) {
                Timber.d(e.message.toString())
            }
        }
    }

}
