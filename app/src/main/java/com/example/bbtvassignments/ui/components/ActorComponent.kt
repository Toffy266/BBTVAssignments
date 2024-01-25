package com.example.bbtvassignments.ui.components

import androidx.compose.foundation.background
import com.example.bbtvassignments.ui.components.common.TitleComponent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Actor
import com.example.bbtvassignments.ui.components.common.EmptyImageComponent
import com.example.bbtvassignments.ui.components.common.NotEmptyImageComponent
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor

@Composable
fun ImageActorDramaComponent(
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
                id = R.drawable.actor
            ),
            modifier = modifier
        )
    }
}

@Composable
fun TextTitleActorComponent(
    actorName: String,
    modifier: Modifier = Modifier,
) {
    var actor = actorName
    if (actorName.isEmpty()) {
        actor = stringResource(
            id = R.string.actor_preview
        )
    }

    Text(
        text = actor,
        modifier = modifier,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodySmall,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

// ---------------  Component  ---------------
@Composable
fun ActorComponent(
    actorList: List<Actor>,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        // ---------------  Title  ---------------
        TitleComponent(
            title = stringResource(
                id = R.string.actor
            )
        )
        LazyRow {
            items(actorList) {
                Column(
                    modifier = Modifier.padding(top = 8.dp, end = 8.dp),
                ) {
                    // ---------------  Image  ---------------
                    ImageActorDramaComponent(
                        imageURL = it.imageURL,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .fillMaxSize()
                        )
                    Column(
                        modifier = Modifier.align(
                            Alignment.CenterHorizontally
                        )
                    ) {
                        // ---------------  TextTitle  ---------------
                        TextTitleActorComponent(
                            actorName = it.actorName,
                            modifier = Modifier
                                .width(80.dp)
                                .padding(0.dp, 8.dp)
                        )
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
        ActorComponent(
            actorList = listOf(
                Actor(),
                Actor(),
                Actor(),
                Actor(),
            ),
            modifier = Modifier
                .background(BackgroundColor)
                .padding(8.dp)
        )
    }
}
