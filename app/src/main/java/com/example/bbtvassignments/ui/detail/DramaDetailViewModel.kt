package com.example.bbtvassignments.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bbtvassignments.model.Datas
import com.example.bbtvassignments.model.DramaDetailUiState
import com.example.bbtvassignments.repository.MainRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

class DramaDetailViewModel(
    private val dramaId: Long,
    private val mainRepository: MainRepository,
) : ViewModel() {
    var response by mutableStateOf(DramaDetailUiState())
        private set

    fun getDetail() {
        response =
            response.copy(
                loading = true,
            )

        viewModelScope.launch {
            try {
                val result = mainRepository.repoDramaDetail()

                response =
                    if (result.status == "success") {
                        response.copy(
                            success = true,
                            detail =
                                getDetailById(
                                    dramaId = dramaId,
                                    detail = result.data,
                                ),
                        )
                    } else {
                        response.copy(
                            error = result.error,
                        )
                    }
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> {
                        Timber.d("Network Error")
                    }

                    is HttpException -> {
                        val codeError = throwable.code()
                        val errorMessageResponse = throwable.message()
                        Timber.d("Error $errorMessageResponse : $codeError")
                    }

                    else -> {
                        Timber.d(throwable.toString())
                    }
                }
            } finally {
                response =
                    response.copy(
                        loading = false,
                    )
            }
        }
    }
}

fun getDetailById(
    dramaId: Long,
    detail: List<Datas>,
): Datas {
    var detailById: Datas = Datas()

    detail.forEach { it ->
        if (it.id == dramaId) {
            detailById = it
        }
    }
    return detailById
}
