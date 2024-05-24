package com.karolyguth.core_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.karolyguth.core_ui.components.shapes.ArchedCutoffShape
import com.karolyguth.core_ui.theme.LocalDimens

@Composable
fun CardWithArchedSeparator(
    title: String,
    calories: String,
    imageUrl: String,
    onClick: () -> Unit,
    elevation: CardElevation = CardDefaults.cardElevation(
        defaultElevation = 4.dp
    )
) {
    val dimens = LocalDimens.current

    ElevatedCard(
        onClick = onClick, elevation = elevation, modifier = Modifier
            .size(dimens.cardWidth, dimens.cardHeight)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(dimens.cardWidth)
                    .clip(
                        shape = ArchedCutoffShape
                    )
                    .background(MaterialTheme.colorScheme.primary)
                    .weight(3f)
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    alignment = Alignment.Center
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(2f)
                    .width(dimens.cardWidth)
                    .padding(start = dimens.spaceMedium, end = dimens.spaceMedium)
            ) {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    style = MaterialTheme.typography.bodyMedium,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "calories: $calories",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = dimens.spaceSmall),
                    color = Color.Gray
                )
            }
        }
    }
}


