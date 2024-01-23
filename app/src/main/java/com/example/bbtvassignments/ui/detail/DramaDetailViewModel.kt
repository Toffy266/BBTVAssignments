package com.example.bbtvassignments.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bbtvassignments.model.DetailByIdModel
import com.example.bbtvassignments.model.DramaDetailModel
import com.example.bbtvassignments.model.ErrorModel
import com.example.bbtvassignments.repository.MainRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class DramaDetailViewModel (
    private val dramaId: Long,
    private val mainRepository: MainRepository
) : ViewModel() {

    var loading by mutableStateOf(false)
        private set
    var detailById by mutableStateOf(DetailByIdModel())
        private set
    var error by mutableStateOf(ErrorModel())
        private set
    var response by mutableStateOf(false)
        private set

    init {
        viewModelScope.launch {
            try {
                loading = true
                val detail = mainRepository.repoDramaDetail()

                if(detail.status ==  "success") {
                    detailById = getDetailById(detail, dramaId)
                    response = true
                } else {
                    error = mainRepository.repoError()
                }

            } catch (e: Exception) {
                Timber.d(e.message.toString())
            } finally {
                loading = false
            }
        }
    }
}

fun getDetailById(
    detail: DramaDetailModel,
    dramaId: Long
): DetailByIdModel {
    var detailById = DetailByIdModel()

    detail.data.forEach { it ->
        if (it.id == dramaId) {
            detailById = DetailByIdModel(true, it)
        }
    }
    return detailById
}