package com.example.bbtvassignments.ui.drama

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bbtvassignments.model.Actor
import com.example.bbtvassignments.model.Drama
import com.example.bbtvassignments.model.DramaModel
import com.example.bbtvassignments.model.ErrorModel
import com.example.bbtvassignments.repository.MainRepository
import kotlinx.coroutines.launch
import timber.log.Timber

class DramaViewModel(
    private val mainRepository: MainRepository
) : ViewModel() {

    var loading by mutableStateOf(false)
        private set
    var drama by mutableStateOf(DramaModel())
        private set
    var recommendList by mutableStateOf(listOf(Drama()))
        private set
    var top10List by mutableStateOf(listOf(Drama()))
        private set
    var actorList by mutableStateOf(listOf(Actor()))
        private set
    var error by mutableStateOf(ErrorModel())
        private set
    var response by mutableStateOf(false)
        private set

    init {
        viewModelScope.launch {
            try {
                loading = true
                drama = mainRepository.repoDrama()

                if(drama.status ==  "success") {
                    recommendList = getRecommendList(drama)
                    top10List = getTop10List(drama)
                    actorList = getActorList(drama)
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
