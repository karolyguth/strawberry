package com.karolyguth.core.data.preferences

import android.content.SharedPreferences
import com.karolyguth.core.domain.model.ActivityLevel
import com.karolyguth.core.domain.model.Gender
import com.karolyguth.core.domain.model.WeightGoal
import com.karolyguth.core.domain.model.UserInfo
import com.karolyguth.core.domain.preferences.Preferences

class DefaultPreferences(private val sharedPref: SharedPreferences): Preferences {

    override fun saveGender(gender: Gender) {
        sharedPref
            .edit().putString(Preferences.KEY_GENDER, gender.name)
            .apply()
    }

    override fun saveAge(age: Int) {
        sharedPref
            .edit().putInt(Preferences.KEY_AGE,age)
            .apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPref
            .edit().putFloat(Preferences.KEY_WEIGHT,weight)
            .apply()
    }

    override fun saveHeight(height: Int) {
        sharedPref
            .edit().putInt(Preferences.KEY_HEIGHT,height)
            .apply()
    }

    override fun saveActivityLevel(activityLevel: ActivityLevel) {
        sharedPref
            .edit().putString(Preferences.KEY_ACTIVITY_LEVEL,activityLevel.level)
            .apply()
    }

    override fun saveWeightGoal(weightGoal: WeightGoal) {
        sharedPref
            .edit().putString(Preferences.KEY_WEIGHT_GOAL, weightGoal.type)
            .apply()
    }

    override fun saveCarbRatio(ratio: Float) {
        sharedPref
            .edit().putFloat(Preferences.KEY_CARB_RATIO, ratio)
            .apply()
    }

    override fun saveProteinRatio(ratio: Float) {
        sharedPref
            .edit().putFloat(Preferences.KEY_PROTEIN_RATIO, ratio)
            .apply()
    }

    override fun saveFatRatio(ratio: Float) {
        sharedPref
            .edit().putFloat(Preferences.KEY_FAT_RATIO, ratio)
            .apply()
    }

    override fun saveFiberRatio(ratio: Float) {
        sharedPref
            .edit().putFloat(Preferences.KEY_FIBER_RATIO, ratio)
            .apply()
    }

    override fun loadUserInfo(): UserInfo {
        val genderString = sharedPref.getString(Preferences.KEY_GENDER, "Female")
        val age = sharedPref.getInt(Preferences.KEY_AGE, -1)
        val height = sharedPref.getInt(Preferences.KEY_HEIGHT, -1)
        val weight = sharedPref.getFloat(Preferences.KEY_WEIGHT, -1F)
        val activityLevelString = sharedPref.getString(Preferences.KEY_ACTIVITY_LEVEL, "")
        val goalType = sharedPref.getString(Preferences.KEY_WEIGHT_GOAL, "")
        val carbRatio = sharedPref.getFloat(Preferences.KEY_CARB_RATIO, -1F)
        val proteinRatio = sharedPref.getFloat(Preferences.KEY_PROTEIN_RATIO, -1F)
        val fatRatio = sharedPref.getFloat(Preferences.KEY_FAT_RATIO, -1F)
        val fiberRatio = sharedPref.getFloat(Preferences.KEY_FIBER_RATIO, -1F)

        return UserInfo(
            gender = Gender.fromString(genderString ?: "male"),
            age = age,
            weight = weight,
            height = height,
            activityLevel = ActivityLevel.fromString(activityLevelString ?: "medium"),
            weightGoal = WeightGoal.fromString(goalType ?: "lose_weight"),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio,
            fiberRatio = fiberRatio
            )
    }

    override fun saveShouldShowOnboarding(shouldShow: Boolean) {
        sharedPref
            .edit().putBoolean(Preferences.SHOULD_SHOW_ONBOARDING, shouldShow)
            .apply()    }

    override fun loadShouldShowOnboarding(): Boolean {
        return sharedPref.getBoolean(Preferences.SHOULD_SHOW_ONBOARDING, true)
    }
}