package com.karolyguth.tracker_presentation.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.karolyguth.core.R
import com.karolyguth.core.util.UiEvent
import com.karolyguth.core_ui.components.CardWithArchedSeparator
import com.karolyguth.core_ui.components.PageHeading
import com.karolyguth.core_ui.components.SearchTextField
import com.karolyguth.core_ui.theme.LocalDimens

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun SearchScreen(
    snackbarHostState: SnackbarHostState,
    mealName: String,
    dayOfMonth: Int,
    month: Int,
    year: Int,
    onNavigateUp: () -> Unit,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val dimens = LocalDimens.current
    val state = viewModel.state
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    LaunchedEffect(key1 = keyboardController) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    snackbarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                    keyboardController?.hide()
                }

                is UiEvent.NavigateUp -> onNavigateUp()
                else -> Unit
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        PageHeading(
            title = stringResource(id = R.string.add_meal, mealName),
            modifier = Modifier
                .fillMaxWidth()
                .height(dimens.headingHeight),
            content = {
                SearchTextField(
                    text = state.query,
                    onValueChange = {
                        viewModel.onEvent(SearchEvent.OnQueryChange(it))
                    },
                    shouldShowHint = state.isHintVisible,
                    onSearch = {
                        keyboardController?.hide()
                        viewModel.onEvent(SearchEvent.OnSearch)
                    },
                    onFocusChanged = {
                        viewModel.onEvent(SearchEvent.OnSearchFocusChange(it.isFocused))
                    }
                )
            })

        Spacer(modifier = Modifier.height(dimens.spaceMedium))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),  // Adjust the number of columns as needed
            contentPadding = PaddingValues(dimens.spaceMedium),
            horizontalArrangement = Arrangement.spacedBy(dimens.spaceMedium),
            verticalArrangement = Arrangement.spacedBy(dimens.spaceMedium)
        ) {
            items(state.trackableFood.size) { index ->
                val item = state.trackableFood[index]
                CardWithArchedSeparator(
                    title = item.food.name,
                    calories = item.food.caloriesPer100g.toString(),
                    imageUrl = item.food.imageUrl ?: "",
                    onClick = { },
                )
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            state.isSearching -> CircularProgressIndicator()
            state.trackableFood.isEmpty() -> {
                Text(
                    text = stringResource(id = R.string.no_results),
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}