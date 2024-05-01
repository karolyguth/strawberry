package com.karolyguth.tracker_domain.model

sealed class MealType(val name:String) {
    object Breakfast: MealType("breakfast")
    object PreWorkout: MealType("preworkout")
    object PostWorkout: MealType("postworkout")
    object Lunch: MealType("lunch")
    object Dinner: MealType("dinner")
    object Other: MealType("other")

    companion object {
        fun fromString(name: String): MealType {
            return when(name.lowercase()) {
                "breakfast" -> Breakfast
                "preworkout" -> PreWorkout
                "postworkout" -> PostWorkout
                "lunch" -> Lunch
                "dinner" -> Dinner
                "other" -> Other
                else -> Other
            }
        }
    }
}