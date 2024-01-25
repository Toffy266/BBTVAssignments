package com.example.bbtvassignments.ui.drama

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bbtvassignments.model.DramaUiState
import com.example.bbtvassignments.ui.components.ActorComponent
import com.example.bbtvassignments.ui.components.drama.BannerComponent
import com.example.bbtvassignments.ui.components.drama.RecommendDramaComponent
import com.example.bbtvassignments.ui.components.drama.Top10DramaComponent
import com.example.bbtvassignments.ui.components.util.ErrorComponent
import com.example.bbtvassignments.ui.components.util.LoadingComponent
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun DramaScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val viewModel: DramaViewModel = koinViewModel()

    with(viewModel.response) {
        if (loading) {
            LoadingComponent()
        } else {
            if (success) {
                DramaContent(
                    response = this,
                    onClick = navController.navigate("drama_detail/${0}"),
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BackgroundColor)
                )
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BackgroundColor),
                ) {
                    ErrorComponent(error = error)
                }
            }
        }
    }
}

@Composable
fun DramaContent(
    response: DramaUiState,
    onClick: Unit,
    modifier: Modifier = Modifier
){
    with(response) {
        LazyColumn(
            modifier = modifier,
        ) {
            item {
                BannerComponent(
                    banner = data.banner,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f / 1f)
                )
            }
            item {
                RecommendDramaComponent(
                    recommendList = recommendList,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BackgroundColor)
                        .padding(8.dp),
                    onClick = onClick
                )
            }
            item {
                Top10DramaComponent(
                    top10List = top10List,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(BackgroundColor)
                        .padding(8.dp),
                    onClick = onClick,
                )
            }
            item {
                ActorComponent(
                    actorList = actorList,
                    modifier = Modifier
                        .background(BackgroundColor)
                        .padding(8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun DramaContentPreview() {
    BBTVAssignmentsTheme {
        DramaContent(
            response = DramaUiState(),
            onClick = Unit)
    }
}
