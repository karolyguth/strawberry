package com.karolyguth.strawberry.navigation

import androidx.navigation.NavController
import com.karolyguth.core.util.UiEvent


fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}