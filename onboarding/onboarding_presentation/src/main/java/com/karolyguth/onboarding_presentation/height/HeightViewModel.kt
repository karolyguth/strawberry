package com.karolyguth.onboarding_presentation.height

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karolyguth.core.domain.preferences.Preferences
import com.karolyguth.core.domain.use_case.FilterOutDigits
import com.karolyguth.core.navigation.Route
import com.karolyguth.core.util.UiEvent
import com.karolyguth.core.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeightViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigits: FilterOutDigits
) : ViewModel() {
    var height by mutableStateOf("0")
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onHeightEnter(enteredHeight: String) {
        if (enteredHeight.length <= 3)
            this.height = filterOutDigits(enteredHeight)
    }

    fun onNextClick() {
        viewModelScope.launch {
            val heightNumber = height.toIntOrNull() ?: kotlin.run {
                _uiEvent.send(
                    UiEvent.ShowSnackBar(
                        UiText.StringResource(com.karolyguth.core.R.string.error_height_cant_be_empty)
                    )
                )
                return@launch
            }
            preferences.saveHeight(heightNumber)
            _uiEvent.send(UiEvent.Navigate(Route.WEIGHT))
        }
    }
}