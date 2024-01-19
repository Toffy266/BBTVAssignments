package com.example.bbtvassignments.ui.drama

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Info
import com.example.bbtvassignments.ui.theme.TextColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun Drama(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: DramaViewModel = koinViewModel()
    val dramaData by viewModel.dramaData.observeAsState()

    with(dramaData!!.data) {
        Column(modifier.fillMaxSize()) {
            BannerComponent(imageUrl = banner.imageURL, title = banner.title)

        }
    }
}

@Composable
fun TextComponent(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        modifier
            .fillMaxWidth()
            .padding(8.dp) ,
        color = TextColor,
        style = MaterialTheme.typography.titleLarge
    )
}


@Composable
fun BannerComponent(
    imageUrl: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Box (
        modifier
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier
                .aspectRatio(4f / 3f)
        )
        Text(
            text = title,
            modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            color = TextColor,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

//@Composable
//fun RecommendComponent(
//    dramaList: List<Info>,
//    modifier: Modifier = Modifier
//) {
//    Box(modifier.fillMaxWidth()) {
//        TextComponent(title = stringResource(id = R.string.title))
//        LazyRow(content = )
//        AsyncImage(
//            model = ImageRequest.Builder(LocalContext.current)
//                .data(imageUrl)
//                .crossfade(true)
//                .build(),
//            contentDescription = null,
//            modifier
//                .aspectRatio(9f / 16f)
//                .clip(CircleShape)
//        )
//    }
//}

@Composable
fun Top10Component(
    imageUrl: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Box(modifier.aspectRatio(16f / 9f)) {
        TextComponent(title = title)
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
        )
    }
}

@Composable
fun ActorComponent(
    imageUrl: String,
    actor: String,
    modifier: Modifier = Modifier
) {
    Box(modifier.fillMaxWidth()) {
        TextComponent(title = actor)
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier.clip(CircleShape)
        )
    }
}


@Preview()
@Composable
fun TextComponentPreview() {
    TextComponent(
        title = stringResource(id = R.string.title)
    )
}

@Preview
@Composable
fun BannerComponentPreview() {
    BannerComponent(
        imageUrl = "test",
        title = stringResource(R.string.title)
    )
}

//@Preview
//@Composable
//fun RecommendComponentPreview() {
//
//    RecommendComponent(
//
//    )
//}

@Preview
@Composable
fun Top10ComponentPreview() {
    Top10Component(
        imageUrl = "test",
        title = stringResource(id = R.string.top10)
    )
}

@Preview
@Composable
fun ActorComponentPreview() {
    ActorComponent(
        imageUrl = "test",
        actor = stringResource(id = R.string.actor)
    )
}

