package com.example.bbtvassignments.ui.components.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun NotEmptyImageComponent(
    imageURL: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model =
            ImageRequest.Builder(LocalContext.current)
                .data(imageURL)
                .crossfade(true)
                .build(),
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Crop,
    )
}
