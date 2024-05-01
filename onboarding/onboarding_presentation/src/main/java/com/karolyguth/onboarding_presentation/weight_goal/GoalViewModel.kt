package com.karolyguth.onboarding_presentation.weight_goal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karolyguth.core.domain.model.WeightGoal
import com.karolyguth.core.domain.preferences.Preferences
import com.karolyguth.core.navigation.Route
import com.karolyguth.core.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoalViewModel @Inject constructor(
    private val preferences: Preferences
): ViewModel() {
    var selectedGoal by mutableStateOf<WeightGoal>(WeightGoal.KeepWeight)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onGoalTypeClick(weightGoal: WeightGoal) {
        selectedGoal = weightGoal
    }

    fun onNextClick() {
        viewModelScope.launch {
            preferences.saveWeightGoal(selectedGoal)
            _uiEvent.send(UiEvent.Navigate(Route.NUTRIENT_GOAL))
        }
    }
}