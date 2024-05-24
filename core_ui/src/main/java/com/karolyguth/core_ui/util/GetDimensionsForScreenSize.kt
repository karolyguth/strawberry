package com.karolyguth.core_ui.util

import android.content.Context
import android.content.res.Configuration
import com.karolyguth.core_ui.theme.Dimens
import com.karolyguth.core_ui.theme.largeDimens
import com.karolyguth.core_ui.theme.normalDimens
import com.karolyguth.core_ui.theme.smallDimens
import com.karolyguth.core_ui.theme.xlargeDimens

fun getDimensForScreenSize(context: Context): Dimens {
    return when (context.resources.configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK) {
        Configuration.SCREENLAYOUT_SIZE_SMALL -> smallDimens
        Configuration.SCREENLAYOUT_SIZE_NORMAL -> normalDimens
        Configuration.SCREENLAYOUT_SIZE_LARGE -> largeDimens
        Configuration.SCREENLAYOUT_SIZE_XLARGE -> xlargeDimens
        else -> normalDimens
    }
}