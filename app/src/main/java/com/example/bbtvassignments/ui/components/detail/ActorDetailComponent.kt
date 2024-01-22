package com.example.bbtvassignments.ui.components.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Actors
import com.example.bbtvassignments.ui.components.drama.EmptyTextTitleActorDramaComponent
import com.example.bbtvassignments.ui.components.drama.NotEmptyTextTitleActorDramaComponent
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor

// ---------------  Title  ---------------
@Composable
fun TitleActorDramaComponent(
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(id = R.string.actor),
        style = MaterialTheme.typography.titleSmall
    )
}

// ---------------  Image  ---------------
@Composable
fun NotEmptyImageActorDramaComponent(
    imageURL: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageURL)
            .crossfade(true)
            .build(),
        contentDescription = null,
        modifier
            .size(80.dp)
            .clip(CircleShape)
            .fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun EmptyImageActorDramaComponent(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.actor),
        contentDescription =null,
        modifier
            .size(80.dp)
            .clip(CircleShape)
            .fillMaxSize(),
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun ImageActorDramaComponent(
    imageURL: String,
    modifier: Modifier = Modifier,
) {
    if(imageURL.isNotEmpty()) {
        NotEmptyImageActorDramaComponent(imageURL = imageURL)
    } else {
        EmptyImageActorDramaComponent()
    }
}

// ---------------  TextTitle  ---------------
@Composable
fun NotEmptyTextTitleActorDramaComponent(
    actorName: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = actorName,
        modifier
            .width(80.dp)
            .padding(0.dp, 8.dp),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodySmall,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun EmptyTextTitleActorDramaComponent(
    modifier: Modifier = Modifier,
) {
    Text(
        text = "พิ้งค์พลอย ปภาวดี",
        modifier
            .width(80.dp)
            .padding(0.dp, 8.dp),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodySmall,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun TextTitleActorDramaComponent(
    actorName: String,
    modifier: Modifier = Modifier,
) {
    if(actorName.isNotEmpty()) {
        NotEmptyTextTitleActorDramaComponent(actorName = actorName)
    } else {
        EmptyTextTitleActorDramaComponent()
    }
}

// ---------------  ActorDetail  ---------------
@Composable
fun ActorDetailComponent(
    actorList: List<Actors>,
    modifier: Modifier = Modifier
) {
    Column (
        modifier
            .fillMaxWidth()
            .background(BackgroundColor)
            .padding(8.dp)
    ) {
        TitleActorDramaComponent()
        LazyRow {
            items(actorList) {
                Column(
                    modifier.padding(top = 8.dp, end = 8.dp)
                ) {
                    ImageActorDramaComponent(imageURL = it.imageURL)
                    Column (modifier.align(Alignment.CenterHorizontally)) {
                        TextTitleActorDramaComponent(actorName = it.actorName)
                    }
                }
            }
        }
    }
}

// ---------------  Preview  ---------------
@Preview
@Composable
fun ActorDetailComponentPreview() {
    BBTVAssignmentsTheme {
        ActorDetailComponent(
            actorList = listOf(
                Actors(),
                Actors(),
                Actors(),
                Actors()
            )
        )
    }
}