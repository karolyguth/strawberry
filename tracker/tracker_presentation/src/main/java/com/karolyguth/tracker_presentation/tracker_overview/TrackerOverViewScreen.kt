package com.karolyguth.tracker_presentation.tracker_overview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.karolyguth.core.util.UiEvent
import com.karolyguth.core_ui.LocalSpacing
import com.karolyguth.core.R
import com.karolyguth.tracker_presentation.components.AddButton
import com.karolyguth.tracker_presentation.components.DaySelector
import com.karolyguth.tracker_presentation.components.ExpandableMeal
import com.karolyguth.tracker_presentation.components.NutrientsHeader
import com.karolyguth.tracker_presentation.components.TrackedFoodItem

@Composable
fun TrackerOverViewScreen(
    onNavigate: (UiEvent.Navigate) -> Unit, viewModel: TrackerOverviewViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    LaunchedEffect(key1 = context) {
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UiEvent.Navigate -> onNavigate(event)
                UiEvent.NavigateUp -> TODO()
                is UiEvent.ShowSnackBar -> TODO()
            }

        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = spacing.spaceMedium)
    ) {
        item {
            NutrientsHeader(state = state, modifier = Modifier.fillMaxSize())
            DaySelector(
                date = state.date,
                onPreviousDayClick = { viewModel.onEvent(TrackerOverviewEvent.OnPreviousDayClick) },
                onNextDayClick = { viewModel.onEvent(TrackerOverviewEvent.OnNextDayClick) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacing.spaceMedium)
            )
        }
        items(state.meals) { meal ->
            ExpandableMeal(meal = meal,
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = spacing.spaceSmall)
                    ) {
                        val foods = state.trackedFoods.filter { it.mealType == meal.mealType }

                        foods.forEach { food ->
                            TrackedFoodItem(
                                trackedFood = food,
                                onDeleteClick = {
                                    viewModel.onEvent(
                                        TrackerOverviewEvent
                                            .OnDeleteTrackedFoodClick(food)
                                    )
                                }
                            )
                            Spacer(modifier = Modifier.height(spacing.spaceMedium))
                        }
                        AddButton(
                            text = stringResource(
                                id = R.string.add_meal,
                                meal.name.asString(context)
                            ),
                            onClick = {
                                viewModel.onEvent(
                                    TrackerOverviewEvent.OnAddFoodClick(meal)
                                )
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                onToggleClick = {
                    viewModel.onEvent(TrackerOverviewEvent.OnToggleMealClick(meal))
                }
            )
        }

    }
}
