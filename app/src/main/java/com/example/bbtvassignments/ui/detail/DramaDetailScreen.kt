package com.example.bbtvassignments.ui.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Actor
import com.example.bbtvassignments.model.Datas
import com.example.bbtvassignments.ui.components.ActorComponent
import com.example.bbtvassignments.ui.components.common.TitleComponent
import com.example.bbtvassignments.ui.components.detail.DetailComponent
import com.example.bbtvassignments.ui.components.detail.EpisodeItemComponent
import com.example.bbtvassignments.ui.components.detail.HeaderComponent
import com.example.bbtvassignments.ui.components.detail.TopAppBarComponent
import com.example.bbtvassignments.ui.components.util.ErrorComponent
import com.example.bbtvassignments.ui.components.util.LoadingComponent
import com.example.bbtvassignments.ui.components.util.LottieAnimationComponent
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor
import com.example.bbtvassignments.ui.theme.LightPurple
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun DramaDetailScreen(
    dramaId: Long?,
    navController: NavController,
) {
    val viewModel: DramaDetailViewModel = koinViewModel { parametersOf(dramaId) }

    LaunchedEffect(key1 = Unit) {
        viewModel.getDetail()
    }

    with(viewModel.response) {
        if (loading) {
            LoadingComponent()
        } else {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = BackgroundColor,
                topBar = {
                    TopAppBarComponent(
                        onClick = navController.popBackStack(),
                    )
                },
            ) { innerPadding ->
                if (success && (detail != Datas())) {
                    DramaDetailContent(
                        detail = detail,
                        modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(BackgroundColor),
                    )
                } else if (success) {
                    LottieAnimationComponent(
                        modifier =
                            Modifier
                                .background(BackgroundColor),
                    )
                } else {
                    ErrorComponent(
                        error = error,
                        modifier =
                        Modifier
                            .fillMaxSize()
                            .background(BackgroundColor),
                    )
                }
            }
        }
    }
}

@Composable
fun DividerComponent() {
    Divider(color = LightPurple, thickness = 1.dp)
}

@SuppressLint("LogNotTimber")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DramaDetailContent(
    detail: Datas,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        stickyHeader {
            DividerComponent()
        }
        with(detail) {
            item {
                HeaderComponent(
                    datas = detail,
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .background(BackgroundColor)
                        .padding(8.dp),
                )
            }
            item {
                DetailComponent(
                    datas = detail,
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .background(BackgroundColor)
                            .padding(8.dp),
                )
            }
            item {
                ActorComponent(
                    actorList = actors,
                    modifier =
                        Modifier
                            .background(BackgroundColor)
                            .padding(8.dp),
                )
            }
            item {
                TitleComponent(
                    stringResource(
                        id = R.string.all_episode,
                    ),
                    modifier =
                        Modifier
                            .background(BackgroundColor)
                            .padding(8.dp),
                )
            }
            items(episodes) {
                EpisodeItemComponent(
                    episodeItem = it,
                    modifier =
                        Modifier
                            .background(BackgroundColor)
                            .padding(8.dp),
                )
            }
        }
    }
}

@Preview
@Composable
fun DramaDetailContentPreview() {
    BBTVAssignmentsTheme {
        DramaDetailContent(
            Datas(),
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(BackgroundColor),
        )
    }
}
