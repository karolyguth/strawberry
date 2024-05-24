package com.karolyguth.tracker_presentation.tracker_overview

import com.karolyguth.tracker_domain.model.Dish
import java.time.LocalDate

data class TrackerOverViewState(
    val totalProtein: Int = 0,
    val totalCarbs: Int = 0,
    val totalFat: Int = 0,
    val totalCalories: Int = 0,
    val proteinGoal: Int = 0,
    val carbsGoal: Int = 0,
    val fatGoal: Int = 0,
    val caloriesGoal: Int = 0,
    val date: LocalDate = LocalDate.now(),
    val dishes: List<Dish> = emptyList(),
    val meals: List<Meal> = defaultMeals
)