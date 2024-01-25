package com.example.bbtvassignments.ui.drama

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bbtvassignments.model.Actor
import com.example.bbtvassignments.model.Drama
import com.example.bbtvassignments.model.DramaModel
import com.example.bbtvassignments.model.DramaUiState
import com.example.bbtvassignments.model.ErrorModel
import com.example.bbtvassignments.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

class DramaViewModel(
    private val mainRepository: MainRepository,
) : ViewModel() {
    var response by mutableStateOf(DramaUiState())
        private set

    fun getDrama() {
        viewModelScope.launch {
            with(response) {
                try {
                    val result = mainRepository.repoDrama()
                    loading = true
                    if (result.status == "success") {
                        success = true
                        data = result.data
                        recommendList = getRecommendList(result)
                        top10List = getTop10List(result)
                        actorList = getActorList(result)
                    } else {
                        error = result.error.detail
                    }
                }
                catch (throwable: Throwable) {
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
                }
                finally {
                    loading = false
                }
            }
        }
    }
}

fun getRecommendList(drama: DramaModel): List<Drama> {
    val recommendCategory = "ละครแนะนำ"
    var recommendList = listOf<Drama>()

    with(drama.data) {
        infos.forEach { it ->
            if (it.categoryTitle == recommendCategory) {
                recommendList = it.dramas
            }
        }
    }
    return recommendList
}

fun getTop10List(drama: DramaModel): List<Drama> {
    val top10Category = "10 อันดับละครดัง กำลังมาแรง"
    var top10List = listOf<Drama>()

    with(drama.data) {
        infos.forEach { it ->
            if (it.categoryTitle == top10Category) {
                top10List = it.dramas
            }
        }
    }
    return top10List
}

fun getActorList(drama: DramaModel): List<Actor> {
    val actorCategory = "นักแสดง"
    var actorList = listOf<Actor>()

    with(drama.data) {
        infos.forEach { it ->
            if (it.categoryTitle == actorCategory) {
                actorList = it.actor
            }
        }
    }
    return actorList
}
