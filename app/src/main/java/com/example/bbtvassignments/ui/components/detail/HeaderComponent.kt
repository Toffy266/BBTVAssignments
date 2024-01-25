package com.example.bbtvassignments.ui.components.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Datas
import com.example.bbtvassignments.ui.components.common.EmptyImageComponent
import com.example.bbtvassignments.ui.components.common.NotEmptyImageComponent
import com.example.bbtvassignments.ui.components.common.TitleComponent
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor
import com.example.bbtvassignments.ui.theme.YellowColor

@Composable
fun ImageHeaderComponent(
    imageURL: String,
    modifier: Modifier = Modifier,
) {
    if (imageURL.isNotEmpty()) {
        NotEmptyImageComponent(
            imageURL = imageURL,
            modifier = modifier
        )
    } else {
        EmptyImageComponent(
            painter = painterResource(
                id = R.drawable.recommend
            ),
            modifier = modifier
        )
    }
}

@Composable
fun TitleHeaderComponent(
    title: String,
    modifier: Modifier = Modifier,
) {
    var titleText = title
    if (title.isEmpty()) {
        titleText = stringResource(
            id = R.string.title
        )
    }
    TitleComponent(
        title = titleText,
        modifier = modifier
    )
}

@Composable
fun RatingHeaderComponent(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        repeat(5) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = YellowColor,
            )
        }
    }
}

@Composable
fun TypeHeaderComponent(
    type: String,
    modifier: Modifier = Modifier,
) {
    var typeText = type
    if (type.isEmpty()) {
        typeText = stringResource(
            id = R.string.type_preview
        )
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(id = R.string.type),
            modifier = Modifier.padding(end = 8.dp),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = typeText,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Normal,
        )
    }
}

// ---------------  Component  ---------------
@Composable
fun HeaderComponent(
    datas: Datas,
    modifier: Modifier = Modifier,
) {
    with(datas) {
        Row(
            modifier = modifier
        ) {
            // ---------------  Image  ---------------
            ImageHeaderComponent(
                imageURL = imageURL,
                modifier = Modifier
                    .width(200.dp)
                    .aspectRatio(2f / 3f)
            )
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                // ---------------  Title  ---------------
                TitleHeaderComponent(
                    title = title,
                    modifier = Modifier.padding(8.dp)
                )
                // ---------------  Rating  ---------------
                RatingHeaderComponent(
                    modifier = Modifier.padding(8.dp)
                )
                // ---------------  Type  ---------------
                TypeHeaderComponent(
                    type = type,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

// ---------------  Preview  ---------------
@Preview(showBackground = true)
@Composable
fun HeaderComponentPreview() {
    BBTVAssignmentsTheme {
        HeaderComponent(
            datas = Datas(),
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundColor)
                .padding(8.dp)
        )
    }
}
