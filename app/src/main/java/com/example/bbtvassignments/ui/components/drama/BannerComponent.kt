package com.example.bbtvassignments.ui.components.drama

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Banner
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme

// ---------------  Image  ---------------
@Composable
fun NotEmptyImageBannerComponent(
    imageURL: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageURL)
            .crossfade(true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun EmptyImageBannerComponent(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.banner),
        contentDescription = null,
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun ImageBannerComponent(
    imageURL: String,
    modifier: Modifier = Modifier
) {
    if(imageURL.isNotEmpty()) {
        NotEmptyImageBannerComponent(imageURL = imageURL)
    } else {
        EmptyImageBannerComponent()
    }
}

// ---------------  Text  ---------------
@Composable
fun TextBannerComponent(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        modifier.padding(16.dp),
        style = MaterialTheme.typography.titleLarge
    )
}

// ---------------  Banner  ---------------
@Composable
fun BannerComponent(
    banner: Banner,
    modifier: Modifier = Modifier
) {
    BBTVAssignmentsTheme {
        Box (
            modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
        ) {
            ImageBannerComponent(imageURL = banner.imageURL)
            Column (modifier.align(Alignment.BottomCenter)) {
                TextBannerComponent(title = banner.title)
            }
        }
    }
}

// ---------------  Preview  ---------------
@Preview
@Composable
fun BannerComponentPreview() {
    BannerComponent(
        Banner(
            title = "สามีชั่วคืน"
        )
    )
}