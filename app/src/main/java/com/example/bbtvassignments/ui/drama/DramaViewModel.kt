package com.example.bbtvassignments.ui.drama

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

    private val _dramaData = MutableLiveData<DramaModel>()
    val dramaData: LiveData<DramaModel> = _dramaData

    fun fetchDramaData() {
        viewModelScope.launch {
            try {
                val dramas = mainRepository.getAllDrama()
                _dramaData.value = dramas
            } catch (e: Exception) {
                Timber.d(e.message.toString())
            }
        }
    }

}
