package com.example.bbtvassignments.ui.detail

import android.telecom.Call.Details
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Actors
import com.example.bbtvassignments.model.Episode
import com.example.bbtvassignments.model.Info
import com.example.bbtvassignments.ui.drama.BannerComponent
import com.example.bbtvassignments.ui.drama.ContentComponent
import com.example.bbtvassignments.ui.drama.DramaViewModel
import com.example.bbtvassignments.ui.drama.RecommendComponent
import com.example.bbtvassignments.ui.drama.Top10Component
import com.example.bbtvassignments.ui.theme.BackgroundColor
import com.example.bbtvassignments.ui.theme.TextColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun DramaDetail(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: DramaDetailViewModel = koinViewModel()

    with(viewModel.detail) {
        data.forEach { it ->
            Column(
                modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .background(BackgroundColor)
                    .padding(16.dp)
            ) {
                TypeComponent(imageUrl = it.imageURL, title = it.title, type = it.type)
                SynopsisComponent(synopsis = it.synopsis)
                ContentRowComponent(actor = it.actors)
                ContentColumnComponent(episodes = it.episodes)
            }
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
            .padding(8.dp),
        color = TextColor,
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun TypeComponent(
    imageUrl: String,
    title: String,
    type: String,
    modifier: Modifier = Modifier
) {
    Row (modifier.fillMaxWidth()) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
        )
        Column {
            TextComponent(title)
            TextComponent(stringResource(id = R.string.type, type))
        }
    }
}

@Composable
fun SynopsisComponent(
    synopsis: String,
    modifier: Modifier = Modifier
) {
    Column (modifier.fillMaxWidth()) {
        TextComponent(stringResource(id = R.string.synopsis))
        TextComponent(synopsis)
    }
}

@Composable
fun ActorComponent(
    imageUrl: String,
    actor: String,
    modifier: Modifier = Modifier
) {
    Column (modifier.fillMaxWidth()) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier.clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = actor,
            modifier.align(Alignment.CenterHorizontally),
            color = TextColor,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun EpisodeComponent(
    imageUrl: String,
    title: String,
    detail: String,
    modifier: Modifier = Modifier
) {
    Column (modifier.fillMaxWidth()){
        Row {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier.aspectRatio(16f / 9f),
                contentScale = ContentScale.Crop
            )
            TextComponent(title)
        }
        TextComponent(detail)
    }
}

@Composable
fun ContentRowComponent(
    actor: List<Actors>,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxWidth()) {
        TextComponent(title = stringResource(id = R.string.actor))
        LazyRow {
            items(actor) {
                ActorComponent(imageUrl = it.imageURL, actor = it.actorName)
            }
        }
    }
}

@Composable
fun ContentColumnComponent(
    episodes: List<Episode>,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxWidth()) {
        TextComponent(title = stringResource(id = R.string.all_episode))
        LazyColumn {
            items(episodes) {
                EpisodeComponent(imageUrl = it.imageURL, title = it.title, detail = it.detail)
            }
        }
    }
}

@Preview
@Composable
fun TextComponentPreView() {
    TextComponent(stringResource(id = R.string.title))
}

@Preview
@Composable
fun TypeComponentPreview() {
    TypeComponent(
        imageUrl = "test",
        title = stringResource(id = R.string.title),
        type = stringResource(id = R.string.type)
    )
}

@Preview()
@Composable
fun SynopsisComponentPreview() {
    SynopsisComponent(stringResource(id = R.string.synopsis_preview))
}

@Preview
@Composable
fun ActorComponentPreview() {
    com.example.bbtvassignments.ui.drama.ActorComponent(
        imageUrl = stringResource(id = R.string.image),
        actor = stringResource(id = R.string.actor)
    )
}

@Preview
@Composable
fun EpisodeComponentPreview() {
    EpisodeComponent(
        imageUrl = "test",
        title = stringResource(id = R.string.episode),
        detail = stringResource(id = R.string.detail)
    )
}