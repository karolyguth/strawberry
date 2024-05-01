package com.karolyguth.onboarding_domain.use_case

import com.karolyguth.core.R
import com.karolyguth.core.util.UiText

class ValidateNutrients {

    operator fun invoke (
        carbsRatioText: String,
        proteinRatioText: String,
        fatRatioText: String
    ): Result {
        val carbsRatioNumber = carbsRatioText.toFloatOrNull()
        val proteinRatioNumber = proteinRatioText.toFloatOrNull()
        val fatRatioNumber = fatRatioText.toFloatOrNull()

        if(carbsRatioNumber == null || proteinRatioNumber == null || fatRatioNumber == null){
            return Result.Error(
                message = UiText.StringResource(R.string.error_invalid_values)
            )
        }

        if(carbsRatioNumber  + proteinRatioNumber + fatRatioNumber != 100f){
            return Result.Error(
                message = UiText.StringResource(R.string.error_not_100_percent)
            )
        }

        return Result.Success(
            carbsRatio = carbsRatioNumber / 100f,
            proteinRatio = proteinRatioNumber / 100f,
            fatRatio = fatRatioNumber / 100f
        )
    }

    sealed class Result {
        data class Success(
            val carbsRatio: Float,
            val proteinRatio: Float,
            val fatRatio: Float
        ): Result()
        data class Error(val message: UiText): Result()
    }
}