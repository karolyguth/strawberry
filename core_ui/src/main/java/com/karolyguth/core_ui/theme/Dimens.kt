package com.karolyguth.core_ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
    val default: Dp,
    val spaceExtraSmall: Dp,
    val spaceSmall: Dp,
    val spaceMedium: Dp,
    val spaceLarge: Dp,
    val spaceExtraLarge: Dp,
    val cardWidth: Dp,
    val cardHeight: Dp,
    val paddingSmall: Int,
    val paddingMedium: Int,
    val paddingLarge: Int,
    val marginSmall: Int,
    val marginMedium: Int,
    val marginLarge: Int,
    val textSizeSmall: Int,
    val textSizeMedium: Int,
    val textSizeLarge: Int,
    val headingHeight: Dp,
    val cornerShape: RoundedCornerShape = RoundedCornerShape(25.dp),
    val cardElevation: Dp = 4.dp
)

val smallDimens = Dimens(
    default = 0.dp,
    spaceExtraSmall = 4.dp,
    spaceSmall = 8.dp,
    spaceMedium = 12.dp,
    spaceLarge = 24.dp,
    spaceExtraLarge = 48.dp,
    cardWidth = 160.dp,
    cardHeight = 200.dp,
    paddingSmall = 8,
    paddingMedium = 12,
    paddingLarge = 16,
    marginSmall = 4,
    marginMedium = 8,
    marginLarge = 12,
    textSizeSmall = 12,
    textSizeMedium = 14,
    textSizeLarge = 16,
    headingHeight = 100.dp
)

// Normal Screen Dimensions
val normalDimens = Dimens(
    default = 0.dp,
    spaceExtraSmall = 4.dp,
    spaceSmall = 8.dp,
    spaceMedium = 16.dp,
    spaceLarge = 32.dp,
    spaceExtraLarge = 64.dp,
    cardWidth = 112.dp,
    cardHeight = 192.dp,
    paddingSmall = 12,
    paddingMedium = 16,
    paddingLarge = 20,
    marginSmall = 8,
    marginMedium = 12,
    marginLarge = 16,
    textSizeSmall = 14,
    textSizeMedium = 16,
    textSizeLarge = 18,
    headingHeight = 120.dp
)

// Large Screen Dimensions
val largeDimens = Dimens(
    default = 0.dp,
    spaceExtraSmall = 4.dp,
    spaceSmall = 10.dp,
    spaceMedium = 20.dp,
    spaceLarge = 40.dp,
    spaceExtraLarge = 80.dp,
    cardWidth = 112.dp,
    cardHeight = 280.dp,
    paddingSmall = 16,
    paddingMedium = 20,
    paddingLarge = 24,
    marginSmall = 12,
    marginMedium = 16,
    marginLarge = 20,
    textSizeSmall = 16,
    textSizeMedium = 18,
    textSizeLarge = 20,
    headingHeight = 120.dp
)

// XLarge Screen Dimensions
val xlargeDimens = Dimens(
    default = 0.dp,
    spaceExtraSmall = 4.dp,
    spaceSmall = 12.dp,
    spaceMedium = 24.dp,
    spaceLarge = 48.dp,
    spaceExtraLarge = 96.dp,
    cardWidth = 280.dp,
    cardHeight = 320.dp,
    paddingSmall = 20,
    paddingMedium = 24,
    paddingLarge = 28,
    marginSmall = 16,
    marginMedium = 20,
    marginLarge = 24,
    textSizeSmall = 18,
    textSizeMedium = 20,
    textSizeLarge = 22,
    headingHeight = 220.dp
)


val LocalDimens = staticCompositionLocalOf { normalDimens }
