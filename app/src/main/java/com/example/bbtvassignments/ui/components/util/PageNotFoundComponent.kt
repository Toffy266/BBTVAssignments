package com.example.bbtvassignments.ui.components.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.bbtvassignments.R
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor

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
        modifier
            .fillMaxSize()
            .background(BackgroundColor),
        contentAlignment = Alignment.Center,
    ){
        LottieAnimation(
            composition = rawComposition,
            progress = progress,
            modifier.width(300.dp)
        )
    }
}

@Preview
@Composable
fun LottieAnimationComponentPreview() {
    BBTVAssignmentsTheme {
        LottieAnimationComponent()
    }
}