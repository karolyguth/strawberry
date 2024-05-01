package com.karolyguth.tracker_presentation.tracker_overview

import androidx.annotation.DrawableRes
import com.karolyguth.core.util.UiText
import com.karolyguth.tracker_domain.model.MealType
import com.karolyguth.core.R

//Class to represent state of displayed meals (breakfast, lunch, etc)
data class Meal(
    val name: UiText,
    @DrawableRes val drawableRes: Int,
    val mealType: MealType,
    val protein: Int = 0,
    val carbs: Int = 0,
    val fat: Int = 0,
    val calories: Int = 0,
    val isExpanded: Boolean = false
    )

val defaultMeals = listOf(
    Meal(
        name = UiText.StringResource(R.string.breakfast),
        drawableRes = R.drawable.ic_breakfast,
        mealType = MealType.Breakfast
    ),
    Meal(
        name = UiText.StringResource(R.string.lunch),
        drawableRes = R.drawable.ic_lunch,
        mealType = MealType.Lunch
    ),
    Meal(
        name = UiText.StringResource(R.string.dinner),
        drawableRes = R.drawable.ic_dinner,
        mealType = MealType.Dinner
    ),
    Meal(
        name = UiText.StringResource(R.string.other),
        drawableRes = R.drawable.ic_snack,
        mealType = MealType.Other
    ),
    Meal(
        name = UiText.StringResource(R.string.preworkout),
        drawableRes = R.drawable.ic_snack,
        mealType = MealType.PreWorkout
    ),
    Meal(
        name = UiText.StringResource(R.string.postworkout),
        drawableRes = R.drawable.ic_snack,
        mealType = MealType.PostWorkout
    ),
)