package com.karolyguth.tracker_data.mapper

import com.karolyguth.tracker_data.local.entity.TrackedFoodEntity
import com.karolyguth.tracker_domain.model.MealType
import com.karolyguth.tracker_domain.model.Dish
import java.time.LocalDate

fun TrackedFoodEntity.toTrackedFood(): Dish {
    return Dish(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        mealType = MealType.fromString(type),
        amount = amount,
        date = LocalDate.of(year, month, dayOfMonth),
        calories = calories,
        id = id
    )
}

fun Dish.toTrackedFoodEntity(): TrackedFoodEntity {
    return TrackedFoodEntity(
        name = name,
        carbs = carbs,
        protein = protein,
        fat = fat,
        imageUrl = imageUrl,
        type = mealType.name,
        amount = amount,
        dayOfMonth = date.dayOfMonth,
        month = date.monthValue,
        year = date.year,
        calories = calories,
        id = id
    )
}