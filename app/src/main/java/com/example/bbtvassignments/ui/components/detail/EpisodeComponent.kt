package com.example.bbtvassignments.ui.components.detail

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Episode
import com.example.bbtvassignments.ui.components.common.EmptyImageComponent
import com.example.bbtvassignments.ui.components.common.NotEmptyImageComponent
import com.example.bbtvassignments.ui.components.common.TitleComponent
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor

@Composable
fun ImageEpisodeComponent(
    imageURL: String,
    modifier: Modifier = Modifier,
) {
    if (imageURL.isNotEmpty()) {
        NotEmptyImageComponent(
            imageURL = imageURL,
            modifier = modifier

        )
    } else {
        EmptyImageComponent(
            painter = painterResource(
                id = R.drawable.episode
            ),
            modifier = modifier
        )
    }
}

@Composable
fun TextTitleEpisodeDramaComponent(
    title: String,
    modifier: Modifier = Modifier,
) {
    var textTitle = title
    if (title.isEmpty()) {
        textTitle = stringResource(
            id = R.string.episode_preview
        )
    }
    Text(
        text = textTitle,
        modifier = modifier,
        style = MaterialTheme.typography.titleSmall,
        fontWeight = FontWeight.Normal,
    )
}

@Composable
fun DetailEpisodeDramaComponent(
    detail: String,
    modifier: Modifier = Modifier,
) {
    var detailText = detail
    if (detail.isEmpty()) {
        detailText = stringResource(
            id = R.string.detail_preview
        )
    }
    Text(
        text = detailText,
        modifier = modifier,
        style = MaterialTheme.typography.displaySmall,
        fontWeight = FontWeight.Normal,
        maxLines = 4,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun EpisodeItemComponent(
    episodeItem: Episode,
    modifier: Modifier = Modifier,
) {
    with(episodeItem) {
        Row (
            modifier = modifier
        ) {
            // ---------------  Image  ---------------
            ImageEpisodeComponent(
                imageURL = imageURL,
                modifier = Modifier
                    .width(220.dp)
                    .aspectRatio(16f / 9f),
            )
            // ---------------  TextTitle  ---------------
            TextTitleEpisodeDramaComponent(
                title = title,
                modifier = Modifier.padding(16.dp)
            )
        }
        // ---------------  Detail  ---------------
        DetailEpisodeDramaComponent(
            detail = detail,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

// ---------------  Component  ---------------
@Composable
fun EpisodeComponent(
    episode: List<Episode>,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier,
    ) {
        // ---------------  Title  ---------------
        TitleComponent(
            title = stringResource(
                id = R.string.all_episode
            )
        )
        LazyColumn {
            items(episode) {
                // ---------------  EpisodeItem  ---------------
                EpisodeItemComponent(
                    episodeItem = it,
                    modifier = Modifier.padding(top = 8.dp)
                )
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
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundColor)
                .padding(8.dp)
        )
    }
}
