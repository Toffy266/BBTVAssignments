package com.example.bbtvassignments.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bbtvassignments.R

val Sukhumvit =
    FontFamily(
        Font(R.font.sukhumvit, FontWeight.Normal),
        Font(R.font.sukhumvit_bold, FontWeight.Bold),
    )

// Set of Material typography styles to start with
val Typography =
    Typography(
        titleLarge =
            TextStyle(
                fontFamily = Sukhumvit,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                letterSpacing = 0.sp,
                color = Color.White,
            ),
        titleSmall =
            TextStyle(
                fontFamily = Sukhumvit,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                letterSpacing = 0.sp,
                color = TextColor,
            ),
        labelSmall =
            TextStyle(
                fontFamily = Sukhumvit,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                letterSpacing = 0.sp,
                color = Color.Black,
            ),
        displayLarge =
            TextStyle(
                color = Color.White.copy(alpha = 0.7f),
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.sp,
            ),
        displaySmall =
            TextStyle(
                fontFamily = Sukhumvit,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                letterSpacing = 0.sp,
                color = Color.White,
            ),
        bodyLarge =
            TextStyle(
                fontFamily = Sukhumvit,
                fontSize = 18.sp,
                letterSpacing = 0.sp,
                color = TextColor,
            ),
        bodySmall =
            TextStyle(
                fontFamily = Sukhumvit,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                letterSpacing = 0.sp,
                color = TextColor,
            ),
    )
