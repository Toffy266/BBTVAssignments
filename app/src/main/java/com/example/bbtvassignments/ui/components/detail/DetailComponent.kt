package com.example.bbtvassignments.ui.components.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Datas
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor


// ---------------  Title  ---------------
@Composable
fun TitleDetailDramaComponent(
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(id = R.string.synopsis),
        style = MaterialTheme.typography.titleSmall
    )
}

// ---------------  Detail  ---------------
@Composable
fun NotEmptySynopsisDetailDramaComponent(
    synopsis: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = synopsis,
        modifier.padding(top = 8.dp),
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Normal
    )
}

@Composable
fun EmptySynopsisDetailDramaComponent(
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(id = R.string.synopsis_preview),
        modifier.padding(top = 8.dp),
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Normal
    )
}

@Composable
fun SynopsisDetailDramaComponent(
    synopsis: String,
    modifier: Modifier = Modifier,
) {
    if (synopsis.isNotEmpty()) {
        NotEmptySynopsisDetailDramaComponent(synopsis = synopsis)
    } else {
        EmptySynopsisDetailDramaComponent()
    }
}

// ---------------  DetailComponent  ---------------
@Composable
fun DetailComponent(
    datas: Datas,
    modifier: Modifier = Modifier
) {
    Column (
        modifier
            .fillMaxWidth()
            .background(BackgroundColor)
            .padding(8.dp)
    ) {
        TitleDetailDramaComponent()
        SynopsisDetailDramaComponent(synopsis = datas.synopsis)
    }
}

// ---------------  Preview  ---------------
@Preview
@Composable
fun DetailComponentPreview() {
    BBTVAssignmentsTheme {
        DetailComponent(
            Datas()
        )
    }
}
