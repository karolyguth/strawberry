package com.karolyguth.tracker_presentation.search

import com.karolyguth.tracker_domain.model.Ingredient

data class IngredientUiState(
    val food: Ingredient,
    val isSelected: Boolean = false,
    val amount: String = ""
)