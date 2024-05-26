package com.karolyguth.core_ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.karolyguth.core_ui.R
import com.karolyguth.core_ui.components.shapes.ArchedCutoffShape
import com.karolyguth.core_ui.theme.LocalDimens
import com.karolyguth.core_ui.theme.LocalTypography

@Composable
fun PageHeading(
    title: String, modifier: Modifier = Modifier, content: @Composable () -> Unit
) {
    val dimens = LocalDimens.current
    val typography = LocalTypography.current

    Box(modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .clip(
                    shape = ArchedCutoffShape
                )        .height(dimens.headingHeight - dimens.spaceLarge)

        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.5f), // Or adjust size as needed
                painter = painterResource(id = R.drawable.strawberries), // Load the drawable
                contentDescription = "Strawberries", // Provide a content description for accessibility
                contentScale = ContentScale.Crop, // Change to ContentScale.Crop
                alignment = Alignment.Center // Or choose another alignment
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = title, style = typography.headlineLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary
                )
            )
            content()
        }
    }
}

@Preview(
    showBackground = true, device = Devices.PIXEL_4, backgroundColor = 0xFFF0EAE2
)
@Composable
fun PageHeadingPreview() {
    val dimens = LocalDimens.current

    PageHeading(
        title = "My Page Heading",
        modifier = Modifier
            .fillMaxWidth()
            .height(dimens.headingHeight)
        ,
        content = {
            SearchTextField(text = "search item", onValueChange = { /*TODO*/ }, onSearch = { /*TODO*/ }) {

            }
        })
}