package com.karolyguth.onboarding_presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.karolyguth.core_ui.LocalSpacing

@Composable
fun UnitTextField(
    value: String,
    onValueChange: (String) -> Unit,
    unit: String,
    modifier: Modifier,
    textStyle: TextStyle = TextStyle(color = MaterialTheme.colorScheme.secondary, fontSize = 70.sp)
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = textStyle,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .alignBy(LastBaseline)
        )
        Spacer(modifier = Modifier.width(spacing.spaceSmall))
    }
}

@Preview
@Composable
fun UnitTextFieldPreview() {
    UnitTextField(
        value = "42",
        onValueChange = { /*TODO*/ },
        unit = "kg",
        modifier = Modifier
    )
}