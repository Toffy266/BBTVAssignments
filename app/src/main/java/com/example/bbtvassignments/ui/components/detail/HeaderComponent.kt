package com.example.bbtvassignments.ui.components.detail

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bbtvassignments.R
import com.example.bbtvassignments.model.Datas
import com.example.bbtvassignments.ui.theme.BBTVAssignmentsTheme
import com.example.bbtvassignments.ui.theme.BackgroundColor
import com.example.bbtvassignments.ui.theme.YellowColor

// ---------------  Image  ---------------
@Composable
fun NotEmptyImageHeaderComponent(
    imageURL: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageURL)
            .crossfade(true)
            .build(),
        contentDescription = null,
        modifier
            .width(200.dp)
            .aspectRatio(2f / 3f),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun EmptyImageHeaderComponent(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.recommend),
        contentDescription =null,
        modifier
            .width(200.dp)
            .aspectRatio(2f / 3f),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ImageHeaderComponent(
    imageURL: String,
    modifier: Modifier = Modifier
) {
    if(imageURL.isNotEmpty()) {
        NotEmptyImageHeaderComponent(imageURL = imageURL)
    } else {
        EmptyImageHeaderComponent()
    }
}

// ---------------  Title  ---------------
@Composable
fun NotEmptyTitleHeaderComponent(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        modifier.padding(8.dp),
        style = MaterialTheme.typography.titleSmall
    )
}

@Composable
fun EmptyTitleHeaderComponent(
    modifier: Modifier = Modifier
) {
    Text(
        text = "แม่โขง",
        modifier.padding(8.dp),
        style = MaterialTheme.typography.titleSmall
    )
}

@Composable
fun TitleHeaderComponent(
    title: String,
    modifier: Modifier = Modifier
) {
    if(title.isNotEmpty()) {
        NotEmptyTitleHeaderComponent(title = title)
    } else {
        EmptyTitleHeaderComponent()
    }
}

// ---------------  Rating  ---------------
@Composable
fun RatingHeaderComponent (
    modifier: Modifier = Modifier
) {
    Row (modifier.padding(8.dp)){
        repeat(5) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = YellowColor
            )
        }
    }
}

// ---------------  Type  ---------------
@Composable
fun NotEmptyTypeHeaderComponent(
    type: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = type,
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Normal,
    )
}

@Composable
fun EmptyTypeHeaderComponent(
    modifier: Modifier = Modifier
) {
    Text(
        text = "แอ็กชัน",
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Normal,
    )
}

@Composable
fun TypeHeaderComponent(
    type: String,
    modifier: Modifier = Modifier
) {
    Row (
        modifier
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
        ){
        Text(
            text = stringResource(id = R.string.type),
            modifier.padding(end = 8.dp),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
        if (type.isNotEmpty()) {
            NotEmptyTypeHeaderComponent(type = type)
        } else {
            EmptyTypeHeaderComponent()
        }
    }
}

// ---------------  Header  ---------------
@Composable
fun HeaderComponent(
    datas: Datas,
    modifier: Modifier = Modifier
) {
    with(datas) {
        Row (
            modifier
                .fillMaxWidth()
                .background(BackgroundColor)
                .padding(8.dp)
        ) {
            ImageHeaderComponent(imageURL = imageURL)
            Column (modifier.padding(start = 8.dp)){
                TitleHeaderComponent(title = title)
                RatingHeaderComponent()
                TypeHeaderComponent(type = type)
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
            datas = Datas()
        )
    }
}
