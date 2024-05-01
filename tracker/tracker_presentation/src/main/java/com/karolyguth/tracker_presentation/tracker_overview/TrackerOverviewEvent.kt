package com.karolyguth.tracker_presentation.tracker_overview

import com.karolyguth.tracker_domain.model.TrackedFood

sealed class TrackerOverviewEvent {
    object OnNextDayClick: TrackerOverviewEvent()
    object OnPreviousDayClick: TrackerOverviewEvent()
    data class OnToggleMealClick(val meal: Meal): TrackerOverviewEvent()
    data class OnDeleteTrackedFoodClick(val trackedFood: TrackedFood): TrackerOverviewEvent()
    data class OnAddFoodClick(val meal: Meal): TrackerOverviewEvent()
}