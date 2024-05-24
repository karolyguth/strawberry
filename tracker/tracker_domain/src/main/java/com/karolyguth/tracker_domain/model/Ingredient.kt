package com.karolyguth.tracker_domain.model

data class Ingredient(
    val name: String,
    val imageUrl: String?,
    val caloriesPer100g: Int,
    val proteinPer100g: Int,
    val carbsPer100g: Int,
    val fatPer100g: Int,
)