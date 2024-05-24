package com.karolyguth.onboarding_presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.karolyguth.core_ui.theme.LocalDimens

@Composable
fun SelectableButton(
    text: String,
    isSelected: Boolean,
    color: Color,
    selectedTextColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.labelLarge
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .border(
                width = 2.dp,
                color = color,
                shape = RoundedCornerShape(100.dp)
            )
            .clickable {
                onClick()
            }
            .padding(LocalDimens.current.spaceSmall)
    ) {

        Text(
            text = text,
            style = textStyle,
            color = if(isSelected) selectedTextColor else color,
            modifier = Modifier.padding(LocalDimens.current.spaceSmall)
        )

    }
}

@Preview
@Composable
fun SelectableButtonPreview() {
    Row {
        SelectableButton(
            "Male",
            true,
            Color.Green,
            selectedTextColor = Color.White,
            {},
            Modifier,
            TextStyle()
        )
        SelectableButton(
            "Female",
            false,
            Color.Green,
            selectedTextColor = Color.White,
            {},
            Modifier,
            TextStyle()
        )
    }
}