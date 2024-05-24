package com.karolyguth.tracker_domain.use_case

import com.karolyguth.tracker_domain.model.MealType
import com.karolyguth.tracker_domain.model.Ingredient
import com.karolyguth.tracker_domain.model.Dish
import com.karolyguth.tracker_domain.repository.TrackerRepository
import java.time.LocalDate
import kotlin.math.roundToInt

class TrackFood (
    private val repository: TrackerRepository
) {
    suspend operator fun invoke (
        food: Ingredient,
        amount: Int,
        mealType: MealType,
        date: LocalDate
    ) {
        repository.insertTrackedFood(
            Dish(
                name = food.name,
                carbs = ((food.carbsPer100g / 100f) * amount).roundToInt(),
                protein = ((food.proteinPer100g / 100f) * amount).roundToInt(),
                fat = ((food.fatPer100g / 100f) * amount).roundToInt(),
                calories = ((food.caloriesPer100g / 100f) * amount).roundToInt(),
                imageUrl = food.imageUrl,
                mealType = mealType,
                amount = amount,
                date = date
            )
        )
    }
}