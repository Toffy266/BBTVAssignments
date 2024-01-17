package com.example.bbtvassignments.ui.drama

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

@Preview
@Composable
fun Drama() {
    AsyncImage(
        model = "https://example.com/image.jpg",
        contentDescription = null,
    )
}
