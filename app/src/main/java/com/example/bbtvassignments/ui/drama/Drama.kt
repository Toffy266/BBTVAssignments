package com.example.bbtvassignments.ui.drama

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Info
import com.example.bbtvassignments.ui.theme.BackgroundColor
import com.example.bbtvassignments.ui.theme.TagColor
import com.example.bbtvassignments.ui.theme.TextColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun Drama(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: DramaViewModel = koinViewModel()

    with(viewModel.drama.data) {
        Column(
            modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(BackgroundColor)
        ) {
            BannerComponent(imageUrl = banner.imageURL, title = banner.title)
            Column {
                infos.forEach { it ->
                    ContentComponent(dramaData = it)
                }
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
fun BannerComponent(
    imageUrl: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Box (
        modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = title,
            modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            color = TextColor,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Composable
fun RecommendComponent(
    id: Long,
    imageUrl: String,
    tag: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .aspectRatio(2f / 3f)
            .padding(8.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Surface (
            modifier
                .align(Alignment.TopStart)
                .padding(8.dp),
            color = TagColor,
            shape = RoundedCornerShape(8.dp),
        ) {
            if(tag.isNotEmpty()) {
                Text(
                    text = tag,
                    modifier.padding(16.dp, 8.dp)
                )
            }
        }
    }
}

@Composable
fun Top10Component(
    id: Long,
    imageUrl: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Box(modifier.aspectRatio(5f / 3f)) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Row (modifier.align(Alignment.BottomStart)){
            Text(
                text = id.toString(),
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 100.sp,
            )
            Text (
                text = title,
                modifier.align(Alignment.Bottom),
                color = Color.White,
                style = MaterialTheme.typography.bodySmall
            )

        }
    }
}

@Composable
fun ActorComponent(
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
fun ContentComponent(
    dramaData: Info,
    modifier: Modifier = Modifier
) {
    with(dramaData) {
        Column(modifier.fillMaxWidth()) {
            TextComponent(title = categoryTitle)
            val recommendCategory = stringResource(id = R.string.recommend)
            val top10Category = stringResource(id = R.string.top10)
            val actorCategory = stringResource(id = R.string.actor)

            LazyRow {
                if(categoryTitle == recommendCategory) {
                    items(dramas) {
                        RecommendComponent(id = it.id, imageUrl = it.imageURL, tag = it.tag )
                    }
                }
                if(categoryTitle == top10Category) {
                    items(dramas) {
                        Top10Component(id = it.id, imageUrl = it.imageURL, title = it.title)
                    }
                }
                if(categoryTitle == actorCategory) {
                    items(actor) {
                        ActorComponent(imageUrl = it.imageURL, actor = it.actorName)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TextComponentPreview() {
    TextComponent(
        title = stringResource(id = R.string.title)
    )
}

@Preview
@Composable
fun BannerComponentPreview() {
    BannerComponent(
        imageUrl = stringResource(id = R.string.image),
        title = stringResource(id = R.string.title)
    )
}

@Preview
@Composable
fun RecommendComponentPreview() {
    RecommendComponent(
        id = 1,
        imageUrl = stringResource(id = R.string.image),
        tag = stringResource(id = R.string.tag)
    )
}

@Preview
@Composable
fun Top10ComponentPreview() {
    Top10Component(
        id = 1,
        imageUrl = stringResource(id = R.string.image),
        title = stringResource(id = R.string.title)
    )
}

@Preview
@Composable
fun ActorComponentPreview() {
    ActorComponent(
        imageUrl = stringResource(id = R.string.image),
        actor = stringResource(id = R.string.actor)
    )
}

