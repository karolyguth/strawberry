package com.karolyguth.core_ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
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
import coil.compose.AsyncImage
import com.karolyguth.core_ui.components.shapes.ArchedCutoffShape
import com.karolyguth.core_ui.theme.LocalDimens

@Composable
fun CardWithArchedSeparator(
    title: String,
    calories: String,
    imageUrl: String,
    onClick: () -> Unit,
) {
    val dimens = LocalDimens.current

    ElevatedCard(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        onClick = onClick, elevation = CardDefaults.cardElevation(
            defaultElevation = dimens.cardElevation
        ), modifier = Modifier
            .size(width = dimens.cardWidth, height = dimens.cardHeight)
    ) {
        with(dimens) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
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
                        .fillMaxWidth()
                        .padding(start = spaceMedium, end = spaceMedium)
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
                        modifier = Modifier.padding(bottom = spaceSmall),
                        color = Color.Gray
                    )
                }
            }
        }
    }
}



