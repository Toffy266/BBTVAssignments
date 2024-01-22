package com.example.bbtvassignments.ui.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.bbtvassignments.R
import com.example.bbtvassignments.ui.components.detail.ActorDetailComponent
import com.example.bbtvassignments.ui.components.detail.ActorDetailComponentPreview
import com.example.bbtvassignments.ui.components.detail.DetailComponent
import com.example.bbtvassignments.ui.components.detail.DetailComponentPreview
import com.example.bbtvassignments.ui.components.detail.EpisodeComponentPreview
import com.example.bbtvassignments.ui.components.detail.HeaderComponent
import com.example.bbtvassignments.ui.components.detail.HeaderComponentPreview
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor
import com.example.bbtvassignments.ui.theme.LightPurple
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun DramaDetail(
    dramaId: Long?,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: DramaDetailViewModel = koinViewModel()

    Scaffold (
        modifier.fillMaxSize(),
        containerColor = BackgroundColor,
        topBar = {
            TopAppBarComponent(navController = navController)
        },
    ) { innerPadding ->
        LazyColumn(
            modifier
                .fillMaxWidth()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            stickyHeader {
                Divider(color = LightPurple, thickness = 1.dp)
            }
            with(viewModel.detailById) {
                if (matchId) {
                    item {
                        HeaderComponent(datas = datas)
                        DetailComponent(datas = datas)
                        ActorDetailComponent(actorList = datas.actors)
//                        EpisodeComponent(episode = datas.episodes)
                    }
                } else {
                    item {
                        Column(modifier.fillParentMaxHeight(1f)) {
                            LottieAnimationComponent()
                        }
                    }
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(
    navController: NavController
) {
    TopAppBar(
        title = {
            Text("")
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.navigate("drama")
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults
            .smallTopAppBarColors(
                containerColor = BackgroundColor
            ),
    )
}

@Preview
@Composable
fun TopAppBarComponentPreview() {
    BBTVAssignmentsTheme {
        TopAppBarComponent(
            navController = NavController(LocalContext.current)
        )
    }
}

@Preview
@Composable
fun DramaDetailPreview() {
    Column {
        HeaderComponentPreview()
        DetailComponentPreview()
        ActorDetailComponentPreview()
        EpisodeComponentPreview()
    }
}

@Composable
fun LottieAnimationComponent(
    modifier: Modifier = Modifier
) {
    val rawComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(
            R.raw.animation_not_found
        )
    )
    val progress by animateLottieCompositionAsState(
        composition = rawComposition,
        iterations = LottieConstants.IterateForever
    )
    Box (
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ){
        LottieAnimation(
            composition = rawComposition,
            progress = progress,
            modifier.width(300.dp)
        )
    }
}