package com.karolyguth.core.domain.model

sealed class WeightGoal(val type: String) {
    object LoseWeight: WeightGoal("lose_weight")
    object GainWeight: WeightGoal("gain_weight")
    object KeepWeight: WeightGoal("keep_weight")


    companion object {
        fun fromString(type: String): WeightGoal {
            return when(type) {
                "lose_weight" -> LoseWeight
                "gain_weight" -> GainWeight
                "keep_weight" -> KeepWeight
                else -> KeepWeight
            }
        }
    }
}