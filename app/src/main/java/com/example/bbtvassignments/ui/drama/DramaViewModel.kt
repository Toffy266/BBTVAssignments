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
    private val _dramas = MutableLiveData<DramaModel>()
    val dramaData: LiveData<DramaModel> = _dramas

    init {
        viewModelScope.launch {
            try {
                _dramas.value = mainRepository.repoDrama()
            } catch (e: Exception) {
                Timber.d(e.message.toString())
            }
        }
    }

}
