package com.example.bbtvassignments.ui.detail

import android.telecom.Call.Details
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bbtvassignments.R

@Composable
fun DramaDetail(modifier: Modifier = Modifier) {

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
fun TypeComponent(imageUrl: String, title: String, type: String) {
    Column {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
        )
    }
    Column {
        Row {
            TextComponent(title)
        }
        Row {
            TextComponent(stringResource(id = R.string.type, type))
        }
    }
}

@Composable
fun SynopsisComponent(synopsis: String, modifier: Modifier = Modifier) {
    Column {
        TextComponent(stringResource(id = R.string.synopsis))
        TextComponent(synopsis)
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

@Composable
fun EpisodeComponent(imageUrl: String, title: String, detail: String, modifier: Modifier = Modifier) {
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

@Preview(showBackground = true)
@Composable
fun TextComponentPreView() {
    TextComponent(stringResource(id = R.string.title))
}

@Preview(showBackground = true)
@Composable
fun TypeComponentPreview() {
    TypeComponent(
        "https://ott-picture.bugaboo.tv/b09f3a87-b821-41d5-8984-9b81af9885427136364879z",
        stringResource(id = R.string.title),
        stringResource(id = R.string.type)
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
        "https://ott-picture.bugaboo.tv/b09f3a87-b821-41d5-8984-9b81af9885427136364879589484783-l.jpeg",
        stringResource(
            id = R.string.actor
        )
    )
}

@Preview(showBackground = true)
@Composable
fun EpisodeComponentPreview() {
    EpisodeComponent(
        "https://ott-picture.bugaboo.tv/b09f3a87-b821-41d5-8984-9b81af9885427136364879589484783-l.jpeg",
        stringResource(id = R.string.episode),
        stringResource(id = R.string.detail)
    )
}