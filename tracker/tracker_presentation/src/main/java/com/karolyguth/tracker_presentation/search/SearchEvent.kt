package com.karolyguth.tracker_presentation.search

import com.karolyguth.tracker_domain.model.MealType
import com.karolyguth.tracker_domain.model.Ingredient
import java.time.LocalDate

sealed class SearchEvent {
    data class OnQueryChange(val query: String) : SearchEvent()
    object OnSearch : SearchEvent()
    data class OnToggleTrackableFood(val food: Ingredient) : SearchEvent()
    data class OnAmountForFoodChange(
        val food: Ingredient,
        val amount: String
    ) : SearchEvent()
    data class OnTrackFoodClick(
        val food: Ingredient,
        val mealType: MealType,
        val date: LocalDate
    ): SearchEvent()
    data class OnSearchFocusChange(val isFocused: Boolean): SearchEvent()
}