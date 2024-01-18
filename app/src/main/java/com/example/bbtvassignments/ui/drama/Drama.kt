package com.example.bbtvassignments.ui.drama

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest


@Composable
fun Drama(navController: NavController) {
    val dramaViewModel: DramaViewModel = viewModel()

//    val dramaData by dramaViewModel.dramaData.observeAsState()
//
//    val imageUrl = dramaData?.data?.banner?.imageURL
//
//    if (imageUrl != null) {
//        Banner(imageUrl)
//    }
}
//
//@Composable
//fun PlayerContent(
//    windowSizeClass: WindowSizeClass,
//    displayFeatures: List<DisplayFeature>,
//    modifier: Modifier = Modifier
//) {
//    PlayerDynamicTheme(uiState.podcastImageUrl) {
//        val foldingFeature = displayFeatures.filterIsInstance<FoldingFeature>().firstOrNull()
//
//        // Use a two pane layout if there is a fold impacting layout (meaning it is separating
//        // or non-flat) or if we have a large enough width to show both.
//        if (
//            windowSizeClass.widthSizeClass == WindowWidthSizeClass.Expanded ||
//            isBookPosture(foldingFeature) ||
//            isTableTopPosture(foldingFeature) ||
//            isSeparatingPosture(foldingFeature)
//        ) {
//            // Determine if we are going to be using a vertical strategy (as if laying out
//            // both sides in a column). We want to do so if we are in a tabletop posture,
//            // or we have an impactful horizontal fold. Otherwise, we'll use a horizontal strategy.
//            val usingVerticalStrategy =
//                isTableTopPosture(foldingFeature) ||
//                        (
//                                isSeparatingPosture(foldingFeature) &&
//                                        foldingFeature.orientation == FoldingFeature.Orientation.HORIZONTAL
//                                )
//
//            if (usingVerticalStrategy) {
//                TwoPane(
//                    first = {
//                        PlayerContentTableTopTop(uiState = uiState)
//                    },
//                    second = {
//                        PlayerContentTableTopBottom(uiState = uiState, onBackPress = onBackPress)
//                    },
//                    strategy = VerticalTwoPaneStrategy(splitFraction = 0.5f),
//                    displayFeatures = displayFeatures,
//                    modifier = modifier,
//                )
//            } else {
//                Column(
//                    modifier = modifier
//                        .fillMaxSize()
//                        .verticalGradientScrim(
//                            color = MaterialTheme.colors.primary.copy(alpha = 0.50f),
//                            startYPercentage = 1f,
//                            endYPercentage = 0f
//                        )
//                        .systemBarsPadding()
//                        .padding(horizontal = 8.dp)
//                ) {
//                    TopAppBar(onBackPress = onBackPress)
//                    TwoPane(
//                        first = {
//                            PlayerContentBookStart(uiState = uiState)
//                        },
//                        second = {
//                            PlayerContentBookEnd(uiState = uiState)
//                        },
//                        strategy = HorizontalTwoPaneStrategy(splitFraction = 0.5f),
//                        displayFeatures = displayFeatures
//                    )
//                }
//            }
//        } else {
//            PlayerContentRegular(uiState, onBackPress, modifier)
//        }
//    }
//}
//
//@Composable
//private fun Banner(
//    imageUrl: String,
//    modifier: Modifier = Modifier
//) {
//    AsyncImage(
//        model = ImageRequest.Builder(LocalContext.current)
//            .data(imageUrl)
//            .crossfade(true)
//            .build(),
//        contentDescription = null,
//        contentScale = ContentScale.Crop,
//        modifier = modifier
//            .sizeIn(maxWidth = 500.dp, maxHeight = 500.dp)
//            .aspectRatio(1f)
//            .clip(MaterialTheme.shapes.medium)
//    )
//}




