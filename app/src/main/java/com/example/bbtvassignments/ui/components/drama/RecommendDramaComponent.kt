package com.example.bbtvassignments.ui.components.drama

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.bbtvassignments.ui.theme.YellowColor

@Composable
fun ImageRecommendDramaComponent(
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
                    id = R.drawable.recommend,
                ),
        )
    }
}

@Composable
fun EpisodeTagRecommendDramaComponent(
    tag: String,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        color = YellowColor,
        shape = RoundedCornerShape(4.dp),
    ) {
        if (tag.isNotEmpty()) {
            Text(
                text = tag,
                modifier = Modifier.padding(6.dp, 4.dp),
                style = MaterialTheme.typography.labelSmall,
            )
        }
    }
}

@Composable
fun RecommendDramaItemComponent(
    drama: Drama,
    modifier: Modifier = Modifier,
) {
    with(drama) {
        Box(
            modifier = modifier,
        ) {
            // ---------------  Image  ---------------
            ImageRecommendDramaComponent(
                imageURL = imageURL,
                modifier = Modifier.fillMaxSize(),
            )
            // ---------------  Tag  ---------------
            EpisodeTagRecommendDramaComponent(
                tag = tag,
                modifier = Modifier.padding(8.dp),
            )
        }
    }
}

// ---------------  Component  ---------------
@Composable
fun RecommendDramaComponent(
    recommendList: List<Drama>,
    onClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        // ---------------  Title  ---------------
        TitleComponent(
            title =
                stringResource(
                    id = R.string.recommend,
                ),
        )
        LazyRow {
            items(recommendList) {
                RecommendDramaItemComponent(
                    drama = it,
                    modifier =
                        Modifier
                            .width(160.dp)
                            .aspectRatio(2f / 3f)
                            .padding(top = 8.dp, end = 8.dp)
                            .clickable{
                                      onClick(it.id)
                            },
                )
            }
        }
    }
}

// --------------- Preview  ---------------
@Preview
@Composable
fun RecommendDramaComponentPreview() {
    BBTVAssignmentsTheme {
        RecommendDramaComponent(
            recommendList =
                listOf<Drama>(
                    Drama(
                        tag = stringResource(id = R.string.tag),
                    ),
                    Drama(),
                    Drama(),
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
