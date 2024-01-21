package com.example.bbtvassignments.ui.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Actors
import com.example.bbtvassignments.model.Datas
import com.example.bbtvassignments.model.Episode
import com.example.bbtvassignments.ui.theme.BackgroundColor
import com.example.bbtvassignments.ui.theme.LightPurple
import com.example.bbtvassignments.ui.theme.YellowColor
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DramaDetail(
    dramaId: Long?,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val viewModel: DramaDetailViewModel = koinViewModel()

    Scaffold (
        modifier.fillMaxSize(),
        containerColor = BackgroundColor,
        topBar = {
            TopAppBar(
                title = {
                    Text("")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigate("drama")
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults
                    .smallTopAppBarColors(
                        containerColor = BackgroundColor
                    ),
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier
                .fillMaxWidth()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            with(viewModel.detail) {
                data.forEach { it ->
                    if (it.id == dramaId) {
                        item {
                            TypeComponent(datas = it)
                            SynopsisComponent(datas = it)
                            ContentRowComponent(datas = it)
                            TextComponent(title = stringResource(id = R.string.all_episode))
                        }
                        items(it.episodes) {
                            EpisodeComponent(episode = it)
                        }

                    } else {
                        item {
                            Column(modifier.fillParentMaxHeight(1f)) {
                                LottieAnimationComponent()
                            }
                        }
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
fun TypeComponent(
    datas: Datas,
    modifier: Modifier = Modifier
) {
    Row (
        modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(datas.imageURL)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier
                .width(200.dp)
                .aspectRatio(2f / 3f),
            contentScale = ContentScale.Crop
        )
        Column (modifier.padding(start = 8.dp)){
            TextComponent(datas.title)
            RatingBarComponent()
            Row (modifier.padding(8.dp)){
                Text(
                    text = stringResource(id = R.string.type),
                    modifier.padding(end = 8.dp),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = datas.type,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Composable
fun SynopsisComponent(
    datas: Datas,
    modifier: Modifier = Modifier
) {
    Column (
        modifier.fillMaxWidth()
    ) {
        TextComponent(stringResource(id = R.string.synopsis))
        Text(
            text = datas.synopsis,
            modifier.padding(8.dp),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun ActorComponent(
    actors: Actors,
    modifier: Modifier = Modifier
) {
    Column (
        modifier
            .padding(8.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(actors.imageURL)
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
            text = actors.actorName,
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
fun EpisodeComponent(
    episode: Episode,
    modifier: Modifier = Modifier
) {
    Column (
        modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        Row {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(episode.imageURL)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier
                    .width(220.dp)
                    .aspectRatio(16f / 9f),
                contentScale = ContentScale.Crop
            )
            Text(
                text = episode.title,
                modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Normal
            )
        }
        Text(
            text = episode.detail,
            modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Normal,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Composable
fun ContentRowComponent(
    datas: Datas,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxWidth()
    ) {
        TextComponent(title = stringResource(id = R.string.actor))
        LazyRow {
            items(datas.actors) {
                ActorComponent(it)
            }
        }
    }
}

@Composable
fun LottieAnimationComponent(
    modifier: Modifier = Modifier
) {
    val rawComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(
            R.raw.animation_not_found
        )
    )
    val progress by animateLottieCompositionAsState(
        composition = rawComposition,
        iterations = LottieConstants.IterateForever
    )
    Box (
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ){
        LottieAnimation(
            composition = rawComposition,
            progress = progress,
            modifier.width(300.dp)
        )
    }
}

@Composable
fun RatingBarComponent (
    modifier: Modifier = Modifier
) {
    Row (modifier.padding(8.dp)){
        repeat(5) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = YellowColor)
        }
    }
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
       Datas(
           title = stringResource(id = R.string.title),
           type = stringResource(id = R.string.type)
       )
    )
}

@Preview(showBackground = true)
@Composable
fun SynopsisComponentPreview() {
    SynopsisComponent(
        Datas(
            synopsis = stringResource(id = R.string.synopsis_preview)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ActorComponentPreview() {
    ActorComponent(
        Actors(
            actorName = stringResource(id = R.string.actor)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun EpisodeComponentPreview() {
    EpisodeComponent(
        Episode(
            title = stringResource(id = R.string.episode),
            detail = stringResource(id = R.string.detail)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun LottieAnimationComponentPreview() {
    LottieAnimationComponent()
}

@Preview(showBackground = true)
@Composable
fun RatingBarComponentPreview() {
    RatingBarComponent()
}