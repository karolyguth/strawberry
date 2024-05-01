package com.karolyguth.core.domain.model

sealed class Gender(val name: String) {
    object Male: Gender("Male")
    object Female: Gender("Female")

    companion object {
        fun fromString(name: String): Gender {
            return when(name) {
                "male" -> Male
                "female" -> Female
                else -> Female
            }
        }
    }
}