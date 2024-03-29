package com.example.bbtvassignments.ui.components.detail

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComponent(onClick: () -> Unit) {
    TopAppBar(
        title = {
            Text("")
        },
        navigationIcon = {
            IconButton(
                onClick = onClick,
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.White,
                )
            }
        },
        colors =
            TopAppBarDefaults
                .smallTopAppBarColors(
                    containerColor = BackgroundColor,
                ),
    )
}

@Preview
@Composable
fun TopAppBarComponentPreview() {
    BBTVAssignmentsTheme {
        TopAppBarComponent(
            onClick = {},
        )
    }
}
