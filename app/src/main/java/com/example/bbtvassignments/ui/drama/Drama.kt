package com.example.bbtvassignments.ui.drama

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bbtvassignments.R

@Composable
fun Drama(navController: NavController, modifier: Modifier = Modifier) {
    val viewModel: DramaViewModel = viewModel()
    val dramaData by viewModel.dramaData.observeAsState()

    Column(modifier.fillMaxSize()) {

    }
}

@Composable
fun TextComponent(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}

@Composable
fun BannerComponent(imageUrl: String, title: String, modifier: Modifier = Modifier) {
    Box (modifier.fillMaxWidth()) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
        )
        Text(
            text = title,
        )
    }
}

@Composable
fun RecommendComponent(imageUrl: String, title: String, modifier: Modifier = Modifier) {
    Box(modifier.fillMaxWidth()) {
        TextComponent(title = title)
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier
                .aspectRatio(9f / 16f)
                .clip(CircleShape)
        )
    }
}

@Composable
fun Top10Component(imageUrl: String, title: String, modifier: Modifier = Modifier) {
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
fun ActorComponent(imageUrl: String, actor: String, modifier: Modifier = Modifier) {
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


@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(title = stringResource(id = R.string.title))
}

@Preview(showBackground = true)
@Composable
fun BannerComponentPreview() {
    BannerComponent(imageUrl = "https://ott-picture.bugaboo.tv/b09f3a87-b821-41d5-8984-9b81af9885427136364879589484783-l.jpeg", title = stringResource(R.string.title))
}

@Preview(showBackground = true)
@Composable
fun RecommendComponentPreview() {
    RecommendComponent(imageUrl = "https://ott-picture.bugaboo.tv/b09f3a87-b821-41d5-8984-9b81af9885427136364879589484783-l.jpeg", title = stringResource(
        id = R.string.recommend
    ))
}

@Preview(showBackground = true)
@Composable
fun Top10ComponentPreview() {
    Top10Component("https://ott-picture.bugaboo.tv/b09f3a87-b821-41d5-8984-9b81af9885427136364879589484783-l.jpeg", stringResource(
        id = R.string.top10
    ))
}

@Preview(showBackground = true)
@Composable
fun ActorComponentPreview() {
    ActorComponent("https://ott-picture.bugaboo.tv/b09f3a87-b821-41d5-8984-9b81af9885427136364879589484783-l.jpeg", stringResource(
        id = R.string.actor
    ))
}

