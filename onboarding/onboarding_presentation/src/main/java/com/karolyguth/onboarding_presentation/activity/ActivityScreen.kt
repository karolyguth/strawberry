package com.karolyguth.onboarding_presentation.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.karolyguth.core.R
import com.karolyguth.core.domain.model.ActivityLevel
import com.karolyguth.core.domain.model.Gender
import com.karolyguth.core.util.UiEvent
import com.karolyguth.core_ui.LocalSpacing
import com.karolyguth.onboarding_presentation.components.ActionButton
import com.karolyguth.onboarding_presentation.components.SelectableButton

@Composable
fun ActivityScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: ActivityViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    //Launch collector to listen to UI events
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
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
                text = stringResource(id = R.string.whats_your_activity_level),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row(horizontalArrangement = Arrangement.Center) {

                SelectableButton(
                    text = stringResource(id = R.string.low),
                    onClick = { viewModel.onActivityLevelClick(ActivityLevel.Low) },
                    isSelected = viewModel.selectedActivity is ActivityLevel.Low,
                    color = MaterialTheme.colorScheme.secondary,
                    selectedTextColor = Color.White,
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.medium),
                    onClick = { viewModel.onActivityLevelClick(ActivityLevel.Medium) },
                    isSelected = viewModel.selectedActivity is ActivityLevel.Medium,
                    color = MaterialTheme.colorScheme.secondary,
                    selectedTextColor = Color.White
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.high),
                    onClick = { viewModel.onActivityLevelClick(ActivityLevel.High) },
                    isSelected = viewModel.selectedActivity is ActivityLevel.High,
                    color = MaterialTheme.colorScheme.secondary,
                    selectedTextColor = Color.White
                )
            }
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = viewModel::onNextClick,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

@Preview
@Composable
fun ActivityScreenPreview() {
    ActivityScreen(
        onNavigate = { /* handle navigation event */ }
    )
}
