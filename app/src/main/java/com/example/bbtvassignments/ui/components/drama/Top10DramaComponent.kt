package com.example.bbtvassignments.ui.components.drama

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Drama
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor

// ---------------  Text  ---------------
@Composable
fun TitleTop10DramaComponent(
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(id = R.string.top10),
        style = MaterialTheme.typography.titleSmall
    )
}

// ---------------  Image  ---------------
@Composable
fun NotEmptyImageTop10DramaComponent(
    imageURL: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageURL)
            .crossfade(true)
            .build(),
        contentDescription = null,
        modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun EmptyImageTop10DramaComponent(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.top10),
        contentDescription =null,
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun ImageTop10DramaComponent(
    imageURL: String,
    modifier: Modifier = Modifier,
) {
    if (imageURL.isNotEmpty()) {
        NotEmptyImageTop10DramaComponent(imageURL = imageURL)
    } else {
        EmptyImageTop10DramaComponent()
    }
}

// ---------------  TextTitle  ---------------
@Composable
fun NotEmptyTextTitleTop10DramaComponent(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text (
        text = title,
        modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.displaySmall
    )
}

@Composable
fun EmptyTextTitleTop10DramaComponent(
    modifier: Modifier = Modifier,
) {
    Text (
        text = "แม่โขง",
        modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.displaySmall
    )
}

@Composable
fun TextTitleTop10DramaComponent(
    title: String,
    modifier: Modifier = Modifier,
) {
    if (title.isNotEmpty()) {
        NotEmptyTextTitleTop10DramaComponent(title = title)
    } else {
        EmptyTextTitleTop10DramaComponent()
    }
}

// ---------------  Number  ---------------
@Composable
fun NumberTop10DramaComponent(
    id: Long,
    modifier: Modifier = Modifier,
) {
    Text(
        text = id.toString(),
        modifier.offset((-3).dp, 22.dp),
        style = MaterialTheme.typography.displayLarge,
    )
}

// ---------------  Top10Drama  ---------------
@Composable
fun Top10DramaComponent(
    top10List: List<Drama>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column (
        modifier
            .fillMaxWidth()
            .background(BackgroundColor)
            .padding(8.dp)
    ) {
        TitleTop10DramaComponent()
        LazyRow {
            items(top10List) {
                Box (
                    modifier
                        .width(270.dp)
                        .aspectRatio(5f / 3f)
                        .padding(top = 8.dp, end = 8.dp)
                        .clickable(onClick = {
                            navController.navigate("drama_detail/${it.id}")
                        })
                ) {
                    ImageTop10DramaComponent(imageURL = it.imageURL)
                    Row (
                        modifier.align(Alignment.BottomStart),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        NumberTop10DramaComponent(id = it.id)
                        Box {
                            TextTitleTop10DramaComponent(title = it.title)
                        }
                    }
                }
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
            top10List = listOf(
                Drama(id = 1,),
                Drama(id = 2),
                Drama(id = 3),
            ),
            navController = NavController(LocalContext.current)
        )
    }
}