package com.karolyguth.onboarding_presentation.nutrient_goal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.karolyguth.core.R
import com.karolyguth.core.util.UiEvent
import com.karolyguth.core_ui.LocalSpacing
import com.karolyguth.onboarding_presentation.components.ActionButton
import com.karolyguth.onboarding_presentation.components.UnitTextField
import com.karolyguth.onboarding_presentation.weight.WeightViewModel


@Composable
fun NutrientGoalScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    snackbarHostState: SnackbarHostState,
    viewModel: NutrientGoalViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                is UiEvent.ShowSnackBar -> {
                    snackbarHostState.showSnackbar(message = event.message.asString(context = context))
                }

                else -> Unit
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.what_are_your_nutrient_goals),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = viewModel.state.proteinRatio,
                onValueChange = {
                    viewModel.onEvent(NutrientGoalEvent.OnProteinRatioEnter(it))
                },
                unit = stringResource(
                    id = R.string.percent_proteins
                ),
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = viewModel.state.carbsRatio,
                onValueChange = {
                    viewModel.onEvent(NutrientGoalEvent.OnCarbRatioEnter(it))
                },
                unit = stringResource(
                    id = R.string.percent_carbs
                ),
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = viewModel.state.fatRatio,
                onValueChange = {
                    viewModel.onEvent(NutrientGoalEvent.OnFatRatioEnter(it))
                },
                unit = stringResource(
                    id = R.string.percent_fats
                ),
                modifier = Modifier
            )
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = {
                      viewModel.onEvent(NutrientGoalEvent.OnNextClick)
            },
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}