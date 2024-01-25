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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Datas
import com.example.bbtvassignments.ui.components.common.TitleComponent
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor

@Composable
fun SynopsisComponent(
    synopsis: String,
    modifier: Modifier = Modifier,
) {
    var detail = synopsis
    if (synopsis.isEmpty()) {
        detail = stringResource(
            id = R.string.synopsis_preview
        )
    }

    Text(
        text = detail,
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Normal,
        maxLines = 4,
        overflow = TextOverflow.Ellipsis
    )
}

// ---------------  Component  ---------------
@Composable
fun DetailComponent(
    datas: Datas,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        // ---------------  Title  ---------------
        TitleComponent(
            title = stringResource(
                id = R.string.synopsis
            )
        )
        // ---------------  Detail  ---------------
        SynopsisComponent(
            synopsis = datas.synopsis,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

// ---------------  Preview  ---------------
@Preview
@Composable
fun DetailComponentPreview() {
    BBTVAssignmentsTheme {
        DetailComponent(
            datas = Datas(),
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundColor)
                .padding(8.dp)
        )
    }
}
