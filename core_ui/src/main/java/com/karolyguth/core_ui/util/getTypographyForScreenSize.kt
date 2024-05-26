package com.karolyguth.core_ui.util

import android.content.Context
import android.content.res.Configuration
import com.karolyguth.core_ui.theme.CompactSmallTypography
import com.karolyguth.core_ui.theme.CompactTypography
import com.karolyguth.core_ui.theme.ExpandedTypography
import com.karolyguth.core_ui.theme.MediumTypography


fun getTypographyForScreenSize(context: Context): androidx.compose.material3.Typography {
    return when (context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK) {
        Configuration.SCREENLAYOUT_SIZE_SMALL -> CompactSmallTypography
        Configuration.SCREENLAYOUT_SIZE_NORMAL -> CompactTypography
        Configuration.SCREENLAYOUT_SIZE_LARGE -> MediumTypography
        Configuration.SCREENLAYOUT_SIZE_XLARGE -> ExpandedTypography
        else -> CompactTypography
    }
}