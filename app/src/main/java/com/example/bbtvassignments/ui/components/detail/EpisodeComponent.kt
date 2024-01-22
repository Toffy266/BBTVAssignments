package com.example.bbtvassignments.ui.components.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Episode
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor


// ---------------  Title  ---------------
@Composable
fun TitleEpisodeDramaComponent(
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(id = R.string.all_episode),
        style = MaterialTheme.typography.titleSmall
    )
}

// ---------------  Image  ---------------
@Composable
fun NotEmptyImageEpisodeComponent(
    imageURL: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageURL)
            .crossfade(true)
            .build(),
        contentDescription = null,
        modifier
            .width(220.dp)
            .aspectRatio(16f / 9f),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun EmptyImageEpisodeComponent(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.episode),
        contentDescription = null,
        modifier
            .width(220.dp)
            .aspectRatio(16f / 9f),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ImageEpisodeComponent(
    imageURL: String,
    modifier: Modifier = Modifier
) {
    if(imageURL.isNotEmpty()) {
        NotEmptyImageEpisodeComponent(imageURL = imageURL)
    } else {
        EmptyImageEpisodeComponent()
    }
}

// ---------------  TextTitle  ---------------
@Composable
fun NotEmptyTextTitleEpisodeDramaComponent(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = title,
        modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.Normal
    )
}

@Composable
fun EmptyTextTitleEpisodeDramaComponent(
    modifier: Modifier = Modifier,
) {
    Text(
        text = "ตอนที่ 1",
        modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.Normal
    )
}

@Composable
fun TextTitleEpisodeDramaComponent(
    title: String,
    modifier: Modifier = Modifier,
) {
    if (title.isNotEmpty()) {
        NotEmptyTextTitleEpisodeDramaComponent(title = title)
    } else {
        EmptyTextTitleEpisodeDramaComponent()
    }
}

// ---------------  Detail  ---------------
@Composable
fun NotEmptyDetailEpisodeDramaComponent(
    detail: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = detail,
        modifier.padding(top = 16.dp),
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Normal,
        maxLines = 4,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun EmptyDetailEpisodeDramaComponent(
    modifier: Modifier = Modifier,
) {
    Text(
        text = "บลาๆๆๆๆๆ",
        modifier.padding(top = 16.dp),
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Normal,
        maxLines = 4,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun DetailEpisodeDramaComponent(
    detail: String,
    modifier: Modifier = Modifier,
) {
    if (detail.isNotEmpty()) {
        NotEmptyDetailEpisodeDramaComponent(detail = detail)
    } else {
        EmptyDetailEpisodeDramaComponent()
    }
}

// ---------------  Episode  ---------------
@Composable
fun EpisodeComponent(
    episode: List<Episode>,
    modifier: Modifier = Modifier
) {
    with(episode) {
        Column (
            modifier
                .fillMaxWidth()
                .background(BackgroundColor)
                .padding(8.dp)
        ) {
            TitleEpisodeDramaComponent()
            LazyColumn {
                items(episode) {
                    Row (modifier.padding(top = 8.dp)) {
                        ImageEpisodeComponent(imageURL = it.imageURL)
                        TextTitleEpisodeDramaComponent(title = it.title)
                    }
                    DetailEpisodeDramaComponent(detail = it.detail)
                }
            }
        }
    }
}

// ---------------  Preview  ---------------
@Preview(showBackground = true)
@Composable
fun EpisodeComponentPreview() {
    BBTVAssignmentsTheme {
        EpisodeComponent(
            episode = listOf(
                Episode(),
                Episode()
            )
        )
    }
}