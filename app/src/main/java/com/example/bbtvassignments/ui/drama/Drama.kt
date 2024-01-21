package com.example.bbtvassignments.ui.drama

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Actor
import com.example.bbtvassignments.model.Banner
import com.example.bbtvassignments.model.Drama
import com.example.bbtvassignments.model.Info
import com.example.bbtvassignments.ui.theme.BackgroundColor
import com.example.bbtvassignments.ui.theme.YellowColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun Drama(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: DramaViewModel = koinViewModel()

    with(viewModel.drama.data) {
        LazyColumn(
            modifier
                .fillMaxSize()
                .background(BackgroundColor)
        ) {
            item {
                BannerComponent(banner = banner)
                Column (modifier.padding(0.dp, 0.dp, 0.dp, 16.dp)) {
                    infos.forEach { it ->
                        ContentComponent(info = it, navController = navController)
                    }
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
        style = MaterialTheme.typography.titleSmall
    )
}

@Composable
fun BannerComponent(
    banner: Banner,
    modifier: Modifier = Modifier
) {
    Box (
        modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(banner.imageURL)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Text(
            text = banner.title,
            modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun RecommendComponent(
    dramas: Drama,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier
            .fillMaxWidth()
            .width(160.dp)
            .aspectRatio(2f / 3f)
            .padding(8.dp)
            .clickable(onClick = {
                navController.navigate("drama_detail/${dramas.id}")
            })
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(dramas.imageURL)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Surface (
            modifier
                .align(Alignment.TopStart)
                .padding(8.dp),
            color = YellowColor,
            shape = RoundedCornerShape(4.dp),
        ) {
            if(dramas.tag.isNotEmpty()) {
                Text(
                    text = dramas.tag,
                    modifier.padding(8.dp, 4.dp),
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

@Composable
fun Top10Component(
    dramas: Drama,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier
            .fillMaxWidth()
            .width(270.dp)
            .aspectRatio(5f / 3f)
            .padding(8.dp)
            .clickable(onClick = {
                navController.navigate("drama_detail/${dramas.id}")
            })
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(dramas.imageURL)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Row (modifier.align(Alignment.BottomStart)){
            Text(
                text = dramas.id.toString(),
                modifier.offset((-4).dp, 28.dp),
                style = MaterialTheme.typography.displayLarge,
            )
            Text (
                text = dramas.title,
                modifier
                    .align(Alignment.Bottom)
                    .padding(0.dp, 0.dp, 0.dp, 8.dp),
                style = MaterialTheme.typography.displaySmall
            )
        }
    }
}

@Composable
fun ActorComponent(
    actor: Actor,
    modifier: Modifier = Modifier
) {
    Column (
        modifier
            .padding(8.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(actor.imageURL)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier
                .size(80.dp)
                .clip(CircleShape)
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = actor.actorName,
            modifier
                .width(80.dp)
                .align(Alignment.CenterHorizontally)
                .padding(0.dp, 8.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
fun ContentComponent(
    info: Info,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    with(info) {
        Column(
            modifier
                .fillMaxWidth()
        ) {
            TextComponent(title = categoryTitle)
            val recommendCategory = stringResource(id = R.string.recommend)
            val top10Category = stringResource(id = R.string.top10)
            val actorCategory = stringResource(id = R.string.actor)

            LazyRow {
                if(categoryTitle == recommendCategory) {
                    items(dramas) {
                        RecommendComponent(dramas = it, navController)
                    }
                }
                if(categoryTitle == top10Category) {
                    items(dramas) {
                        Top10Component(it, navController)
                    }
                }
                if(categoryTitle == actorCategory) {
                    items(actor) {
                        ActorComponent(it)
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview() {
    TextComponent(
        title = stringResource(id = R.string.title)
    )
}

@Preview(showBackground = true)
@Composable
fun BannerComponentPreview() {
    BannerComponent(
        Banner(
            title = stringResource(id = R.string.title)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun RecommendComponentPreview() {
    RecommendComponent(
        dramas = Drama(
            tag = stringResource(id = R.string.tag),
            title = stringResource(id = R.string.title)
        ),
        navController = NavController(LocalContext.current)
    )
}

@Preview(showBackground = true)
@Composable
fun Top10ComponentPreview() {
    Top10Component(
        dramas = Drama(
            id = 1,
            title = stringResource(id = R.string.title)
        ),
        navController = NavController(LocalContext.current)
    )
}

@Preview(showBackground = true)
@Composable
fun ActorComponentPreview() {
    ActorComponent(
        Actor(
            actorName = stringResource(id = R.string.actor)
        )
    )
}

