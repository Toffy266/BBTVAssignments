package com.example.bbtvassignments.ui.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bbtvassignments.ui.components.util.LoadingComponent
import com.example.bbtvassignments.ui.components.detail.ActorDetailComponent
import com.example.bbtvassignments.ui.components.detail.ActorDetailComponentPreview
import com.example.bbtvassignments.ui.components.detail.DetailComponent
import com.example.bbtvassignments.ui.components.detail.DetailComponentPreview
import com.example.bbtvassignments.ui.components.detail.EpisodeComponentPreview
import com.example.bbtvassignments.ui.components.detail.EpisodeItemComponent
import com.example.bbtvassignments.ui.components.detail.HeaderComponent
import com.example.bbtvassignments.ui.components.detail.HeaderComponentPreview
import com.example.bbtvassignments.ui.components.detail.TitleEpisodeDramaComponent
import com.example.bbtvassignments.ui.components.detail.TopAppBarComponent
import com.example.bbtvassignments.ui.components.detail.TopAppBarComponentPreview
import com.example.bbtvassignments.ui.components.util.ErrorComponent
import com.example.bbtvassignments.ui.components.util.LottieAnimationComponent
import com.example.bbtvassignments.ui.theme.BackgroundColor
import com.example.bbtvassignments.ui.theme.LightPurple
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DramaDetail(
    dramaId: Long?,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: DramaDetailViewModel = koinViewModel() { parametersOf(dramaId) }
    
    with(viewModel) {
        if(loading) {
            LoadingComponent()
        } else {
            if (detailById.matchId && response) {
                Scaffold (
                    modifier.fillMaxSize(),
                    containerColor = BackgroundColor,
                    topBar = {
                        TopAppBarComponent(navController = navController)
                    },
                ) { innerPadding ->
                    LazyColumn(
                        modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        stickyHeader {
                            DividerComponent()
                        }
                        with(detailById) {
                            item {
                                HeaderComponent(datas = datas)
                                DetailComponent(datas = datas)
                                ActorDetailComponent(actorList = datas.actors)
                                Column (
                                    modifier
                                        .padding(start = 8.dp, end = 8.dp)
                                ) {
                                    TitleEpisodeDramaComponent()
                                }
                            }
                            items(datas.episodes) {
                                Column (
                                    modifier.padding(8.dp)
                                ) {
                                    EpisodeItemComponent(episodeItem = it)
                                }
                            }
                        }
                    }
                }
            } else if(response) {
                Column(modifier.fillMaxSize()) {
                    TopAppBarComponent(
                        navController = navController
                    )
                    DividerComponent()
                    LottieAnimationComponent()
                }
            } else {
                TopAppBarComponent(
                    navController = navController
                )
                DividerComponent()
                ErrorComponent(error = error.error)
            }

        }
    }
}

@Composable
fun DividerComponent() {
    Divider(color = LightPurple, thickness = 1.dp)
}

@Preview
@Composable
fun DramaDetailPreview() {
    Column {
        TopAppBarComponentPreview()
        HeaderComponentPreview()
        DetailComponentPreview()
        ActorDetailComponentPreview()
        EpisodeComponentPreview()
    }
}