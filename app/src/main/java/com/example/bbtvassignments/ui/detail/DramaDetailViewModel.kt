package com.example.bbtvassignments.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bbtvassignments.model.DramaDetailModel
import com.example.bbtvassignments.model.DramaModel
import com.example.bbtvassignments.repository.MainRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class DramaDetailViewModel (
    private val mainRepository: MainRepository
) : ViewModel() {
    private val _detail = MutableLiveData<DramaDetailModel>()
    val detailData: LiveData<DramaDetailModel> = _detail

    init {
        viewModelScope.launch {
            try {
                _detail.value = mainRepository.repoDramaDetail()
            } catch (e: Exception) {
                Timber.d(e.message.toString())
            }
        }
    }
}