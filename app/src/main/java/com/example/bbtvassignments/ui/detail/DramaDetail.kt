package com.example.bbtvassignments.ui.detail

import android.telecom.Call.Details
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bbtvassignments.R
import com.example.bbtvassignments.ui.drama.BannerComponent
import com.example.bbtvassignments.ui.drama.DramaViewModel
import com.example.bbtvassignments.ui.drama.RecommendComponent
import com.example.bbtvassignments.ui.theme.TextColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun DramaDetail(modifier: Modifier = Modifier) {
    val viewModel: DramaDetailViewModel = koinViewModel()

    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp, 16.dp)
    ) {
        Column  {

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
fun TypeComponent(
    imageUrl: String,
    title: String,
    type: String,
    modifier: Modifier = Modifier
) {
    Row {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier.aspectRatio(2f / 3f)
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
    Column {
        TextComponent(stringResource(id = R.string.synopsis))
        TextComponent(synopsis)
    }
}

@Composable
fun ActorImageComponent(
    imageUrl: String,
    actor: String,
    modifier: Modifier = Modifier
) {
    Column (){
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

@Composable
fun EpisodeImageComponent(
    imageUrl: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Row {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        TextComponent(title)
    }
}

@Composable
fun EpisodeComponent(
    imageUrl: String,
    title: String,
    detail: String,
    modifier: Modifier = Modifier
) {
    Row {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier.clip(CircleShape)
        )
        TextComponent(title)
    }
    TextComponent(detail)
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

@Preview(showBackground = true)
@Composable
fun SynopsisComponentPreview() {
    SynopsisComponent(stringResource(id = R.string.synopsis_preview))
}

@Preview(showBackground = true)
@Composable
fun ActorComponentPreview() {
    ActorComponent(
        imageUrl = "test",
        actor =  stringResource(id = R.string.actor)
    )
}

@Preview(showBackground = true)
@Composable
fun EpisodeComponentPreview() {
    EpisodeComponent(
        imageUrl = "test",
        title = stringResource(id = R.string.episode),
        detail = stringResource(id = R.string.detail)
    )
}