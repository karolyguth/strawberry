package com.karolyguth.core.domain.model

data class UserInfo(
    val gender: Gender,
    val age: Int,
    val weight: Float,
    val height: Int,
    val activityLevel: ActivityLevel,
    val weightGoal: WeightGoal,
    val carbRatio: Float,
    val proteinRatio: Float,
    val fatRatio: Float,
    val fiberRatio: Float
)