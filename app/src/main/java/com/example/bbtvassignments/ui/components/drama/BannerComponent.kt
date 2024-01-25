package com.example.bbtvassignments.ui.components.drama

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Banner
import com.example.bbtvassignments.ui.components.common.EmptyImageComponent
import com.example.bbtvassignments.ui.components.common.NotEmptyImageComponent
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme

@Composable
fun ImageBannerComponent(
    imageURL: String,
    modifier: Modifier = Modifier,
) {
    Box {
        if (imageURL.isNotEmpty()) {
            NotEmptyImageComponent(
                imageURL = imageURL,
                modifier = modifier
            )
        } else {
            EmptyImageComponent(
                painter = painterResource(
                    id = R.drawable.banner
                ),
                modifier = modifier
            )
        }
    }

}

@Composable
fun TextBannerComponent(
    title: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = title,
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge,
    )
}

// ---------------  Component  ---------------
@Composable
fun BannerComponent(
    banner: Banner,
    modifier: Modifier = Modifier,
) {
    BBTVAssignmentsTheme {
        Box(
            modifier = modifier,
        ) {
            // ---------------  Image  ---------------
            ImageBannerComponent(
                imageURL = banner.imageURL,
                modifier = Modifier.fillMaxSize()
            )
            // ---------------  Text  ---------------
            TextBannerComponent(
                title = banner.title,
                modifier = Modifier
                    .padding(32.dp)
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

// ---------------  Preview  ---------------
@Preview
@Composable
fun BannerComponentPreview() {
    BannerComponent(
        Banner(
            title = "สามีชั่วคืน",
        ),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f / 1f)
    )
}
