package com.example.bbtvassignments.ui.components.drama

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Drama
import com.example.bbtvassignments.ui.components.common.EmptyImageComponent
import com.example.bbtvassignments.ui.components.common.NotEmptyImageComponent
import com.example.bbtvassignments.ui.components.common.TitleComponent
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor

@Composable
fun ImageTop10DramaComponent(
    imageURL: String,
    modifier: Modifier = Modifier,
) {
    if (imageURL.isNotEmpty()) {
        NotEmptyImageComponent(
            imageURL = imageURL,
            modifier = modifier,
        )
    } else {
        EmptyImageComponent(
            painter =
                painterResource(
                    id = R.drawable.top10,
                ),
            modifier = modifier,
        )
    }
}

@Composable
fun TextTitleTop10DramaComponent(
    title: String,
    modifier: Modifier = Modifier,
) {
    var titleText = title
    if (title.isEmpty()) {
        titleText =
            stringResource(
                id = R.string.title,
            )
    }
    TitleComponent(
        title = titleText,
        modifier = modifier,
    )
}

@Composable
fun NumberTop10DramaComponent(
    id: Long,
    modifier: Modifier = Modifier,
) {
    Text(
        text = id.toString(),
        modifier = modifier,
        style = MaterialTheme.typography.displayLarge,
    )
}

@Composable
fun Top10DramaItemComponent(
    drama: Drama,
    modifier: Modifier = Modifier,
) {
    with(drama) {
        Box(
            modifier = modifier,
        ) {
            // ---------------  Image  ---------------
            ImageTop10DramaComponent(
                imageURL = imageURL,
                modifier = Modifier.fillMaxSize(),
            )
            Row(
                modifier = Modifier.align(Alignment.BottomStart),
                verticalAlignment = Alignment.Bottom,
            ) {
                // ---------------  Number  ---------------
                NumberTop10DramaComponent(
                    id = id,
                    modifier = Modifier.offset((-3).dp, 22.dp),
                )
                // ---------------  TextTitle  ---------------
                TextTitleTop10DramaComponent(
                    title = title,
                    modifier =
                        Modifier
                            .align(Alignment.Bottom),
                )
            }
        }
    }
}

// ---------------  Component  ---------------
@Composable
fun Top10DramaComponent(
    top10List: List<Drama>,
    onClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        // ---------------  Ttle  ---------------
        TitleComponent(
            title =
                stringResource(
                    id = R.string.top10,
                ),
        )
        LazyRow {
            items(top10List) {
                Top10DramaItemComponent(
                    drama = it,
                    modifier =
                        Modifier
                            .width(270.dp)
                            .aspectRatio(5f / 3f)
                            .padding(top = 8.dp, end = 8.dp)
                            .clickable {
                                onClick(it.id)
                            },
                )
            }
        }
    }
}

// ---------------  Preview  ---------------
@Preview
@Composable
fun Top10DramaComponentPreview() {
    BBTVAssignmentsTheme {
        Top10DramaComponent(
            top10List =
                listOf(
                    Drama(id = 1),
                    Drama(id = 2),
                    Drama(id = 3),
                ),
            onClick = {},
            modifier =
                Modifier
                    .fillMaxWidth()
                    .background(BackgroundColor)
                    .padding(8.dp),
        )
    }
}
