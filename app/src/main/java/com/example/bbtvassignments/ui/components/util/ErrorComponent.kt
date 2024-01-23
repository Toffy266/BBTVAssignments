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
    modifier: Modifier = Modifier
) {
    Text(
        text = code,
        modifier.fillMaxWidth(),
        style = MaterialTheme.typography.titleSmall,
        textAlign = TextAlign.Center
    )
}

@Composable
fun ErrorMessageComponent(
    message: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = message,
        modifier
            .padding(top = 8.dp)
            .fillMaxWidth(),
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center
    )
}

@Composable
fun ErrorComponent(
    error: ErrorDetail,
    modifier: Modifier = Modifier
) {
    Box (
        modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            ErrorCodeComponent(code = error.code.toString())
            ErrorMessageComponent(message = error.message)
        }
    }
}

@Preview
@Composable
fun ErrorComponentPreview() {
    BBTVAssignmentsTheme {
        ErrorComponent(
            error = ErrorDetail(
                500,
                "Server error!!!"
            )
        )
    }
}