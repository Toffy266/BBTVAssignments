package com.example.bbtvassignments.ui.components.drama

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Drama
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor
import com.example.bbtvassignments.ui.theme.YellowColor

// ---------------  Title  ---------------
@Composable
fun TitleRecommendDramaComponent(
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(id = R.string.recommend),
        style = MaterialTheme.typography.titleSmall
    )
}

// ---------------  Image  ---------------
@Composable
fun NotEmptyImageRecommendDramaComponent(
    imageURL: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageURL)
            .crossfade(true)
            .build(),
        contentDescription = null,
        modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun EmptyImageRecommendDramaComponent(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.recommend),
        contentDescription =null,
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun ImageRecommendDramaComponent(
    imageURL: String,
    modifier: Modifier = Modifier,
) {
    if (imageURL.isNotEmpty()) {
        NotEmptyImageRecommendDramaComponent(imageURL = imageURL)
    } else {
        EmptyImageRecommendDramaComponent()
    }
}

// ---------------  Tag  ---------------
@Composable
fun EpisodeTagRecommendDramaComponent(
    tag: String,
    modifier: Modifier = Modifier,
) {
    Surface (
        modifier.padding(8.dp),
        color = YellowColor,
        shape = RoundedCornerShape(4.dp),
    ) {
        if(tag.isNotEmpty()) {
            Text(
                text = tag,
                modifier.padding(6.dp, 4.dp),
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

// ---------------  RecommendDrama  ---------------
@Composable
fun RecommendDramaComponent(
    recommendList: List<Drama>,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Column (
        modifier
            .fillMaxWidth()
            .background(BackgroundColor)
            .padding(8.dp)
    ) {
        TitleRecommendDramaComponent()
        LazyRow {
            items(recommendList) {
                Box (
                    modifier
                        .width(160.dp)
                        .aspectRatio(2f / 3f)
                        .padding(top = 8.dp, end = 8.dp)
                        .clickable(onClick = {
                            navController.navigate("drama_detail/${it.id}")
                        })
                ) {
                    ImageRecommendDramaComponent(imageURL = it.imageURL)
                    Column (modifier.align(Alignment.TopStart)) {
                        EpisodeTagRecommendDramaComponent(tag = it.tag)
                    }
                }
            }
        }
    }
}

// --------------- Preview  ---------------
@Preview
@Composable
fun RecommendDramaComponentPreview() {
    BBTVAssignmentsTheme {
        RecommendDramaComponent(
            recommendList = listOf<Drama>(
                Drama(
                    tag = stringResource(id = R.string.tag)
                ),
                Drama(),
                Drama(),
            ),
            navController = NavController(LocalContext.current)
        )
    }
}