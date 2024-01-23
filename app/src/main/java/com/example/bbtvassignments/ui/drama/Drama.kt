package com.example.bbtvassignments.ui.drama

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.bbtvassignments.ui.components.util.LoadingComponent
import com.example.bbtvassignments.ui.components.drama.ActorDramComponentPreview
import com.example.bbtvassignments.ui.components.drama.ActorDramaComponent
import com.example.bbtvassignments.ui.components.drama.BannerComponent
import com.example.bbtvassignments.ui.components.drama.BannerComponentPreview
import com.example.bbtvassignments.ui.components.drama.RecommendDramaComponent
import com.example.bbtvassignments.ui.components.drama.RecommendDramaComponentPreview
import com.example.bbtvassignments.ui.components.drama.Top10DramaComponent
import com.example.bbtvassignments.ui.components.drama.Top10DramaComponentPreview
import com.example.bbtvassignments.ui.components.util.ErrorComponent
import com.example.bbtvassignments.ui.theme.BackgroundColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun Drama(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: DramaViewModel = koinViewModel()

    with(viewModel) {
        if(loading) {
            LoadingComponent()
        } else {
            if(response) {
                with(drama.data) {
                    Column (
                        modifier
                            .fillMaxSize()
                            .background(BackgroundColor)
                            .verticalScroll(rememberScrollState())
                    ){
                        BannerComponent(banner = banner)
                        RecommendDramaComponent(
                            recommendList = recommendList,
                            navController = navController
                        )
                        Top10DramaComponent(
                            top10List = top10List,
                            navController = navController
                        )
                        ActorDramaComponent(actorList = actorList)
                    }
                }
            } else {
                Column (
                    modifier
                        .fillMaxSize()
                        .background(BackgroundColor)
                ){
                    ErrorComponent(error = error.error)
                }
            }
        }
    }
}

@Preview
@Composable
fun DramaPreview() {
    Column {
        BannerComponentPreview()
        RecommendDramaComponentPreview()
        Top10DramaComponentPreview()
        ActorDramComponentPreview()
    }
}



