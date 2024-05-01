package com.karolyguth.core.domain.model

sealed class ActivityLevel(val level: String) {
    object Low: ActivityLevel("low")
    object Medium: ActivityLevel("medium")
    object High: ActivityLevel("high")


    companion object {
        fun fromString(type: String): ActivityLevel {
            return when(type) {
                "low" -> Low
                "medium" -> Medium
                "high" -> High
                else -> Medium
            }
        }
    }
}