package com.example.bbtvassignments.ui.components.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bbtvassignments.model.ErrorDetail
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor

@Composable
fun ErrorCodeComponent(
    code: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = code,
        modifier = modifier,
        style = MaterialTheme.typography.titleSmall,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun ErrorMessageComponent(
    message: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = message,
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun ErrorComponent(
    error: ErrorDetail,
    modifier: Modifier = Modifier,
) {
    with(error) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center,
        ) {
            Column {
                ErrorCodeComponent(
                    code = code.toString(),
                    modifier = Modifier.fillMaxWidth(),
                )
                ErrorMessageComponent(
                    message = message,
                    modifier =
                        Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                )
            }
        }
    }
}

@Preview
@Composable
fun ErrorComponentPreview() {
    BBTVAssignmentsTheme {
        ErrorComponent(
            error =
                ErrorDetail(
                    500,
                    "Server error!!!",
                ),
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(BackgroundColor),
        )
    }
}
