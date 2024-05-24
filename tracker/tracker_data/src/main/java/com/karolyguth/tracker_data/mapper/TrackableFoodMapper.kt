package com.karolyguth.tracker_data.mapper

import com.karolyguth.tracker_data.remote.dto.Product
import com.karolyguth.tracker_domain.model.Ingredient
import kotlin.math.roundToInt

fun Product.toTrackableFood(): Ingredient? {
    val carbsPer100g =  nutriments.carbohydrates100g.roundToInt()
    val proteinPer100g = nutriments.proteins100g.roundToInt()
    val fatPer100g = nutriments.fat100g.roundToInt()
    val caloriesPer100g = nutriments.energyKcal100g.roundToInt()
    return Ingredient(
        name = productName ?: return null,
        carbsPer100g = carbsPer100g,
        proteinPer100g = proteinPer100g,
        fatPer100g = fatPer100g,
        caloriesPer100g = caloriesPer100g,
        imageUrl = imageFrontThumbUrl
    )
}