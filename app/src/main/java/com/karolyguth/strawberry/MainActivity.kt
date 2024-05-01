package com.karolyguth.strawberry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.karolyguth.core.domain.preferences.Preferences
import com.karolyguth.core.navigation.Route
import com.karolyguth.onboarding_presentation.activity.ActivityScreen
import com.karolyguth.onboarding_presentation.age.AgeScreen
import com.karolyguth.onboarding_presentation.gender.GenderScreen
import com.karolyguth.onboarding_presentation.weight_goal.WeightGoalScreen
import com.karolyguth.onboarding_presentation.height.HeightScreen
import com.karolyguth.onboarding_presentation.nutrient_goal.NutrientGoalScreen
import com.karolyguth.onboarding_presentation.weight.WeightScreen
import com.karolyguth.onboarding_presentation.welcome.WelcomeScreen
import com.karolyguth.core_ui.theme.StrawberryTheme
import com.karolyguth.strawberry.navigation.navigate
import com.karolyguth.tracker_presentation.search.SearchScreen
import com.karolyguth.tracker_presentation.tracker_overview.TrackerOverViewScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val shouldShowOnboarding = preferences.loadShouldShowOnboarding()

        setContent {
            StrawberryTheme {
                val navController = rememberNavController()
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackbarHostState) },
                    content = { padding ->
                        NavHost(
                            navController = navController,
                            startDestination = if(shouldShowOnboarding) {
                                Route.WELCOME
                            } else Route.TRACKER_OVERVIEW

                        ) {
                            composable(Route.WELCOME) { WelcomeScreen(onNavigate = navController::navigate) }
                            composable(Route.AGE) {
                                AgeScreen(
                                    onNavigate = navController::navigate,
                                    snackbarHostState
                                )
                            }
                            composable(Route.GENDER) { GenderScreen(onNavigate = navController::navigate) }
                            composable(Route.HEIGHT) {
                                HeightScreen(
                                    onNavigate = navController::navigate,
                                    snackbarHostState
                                )
                            }
                            composable(Route.WEIGHT) {
                                WeightScreen(
                                    onNavigate = navController::navigate,
                                    snackbarHostState
                                )
                            }
                            composable(Route.ACTIVITY) { ActivityScreen(onNavigate = navController::navigate) }
                            composable(Route.WEIGHT_GOAL) { WeightGoalScreen(onNavigate = navController::navigate) }
                            composable(Route.NUTRIENT_GOAL) {
                                NutrientGoalScreen(
                                    onNavigate = navController::navigate,
                                    snackbarHostState
                                )
                            }
                            composable(Route.TRACKER_OVERVIEW) { TrackerOverViewScreen(onNavigate = navController::navigate) }
                            composable(
                                route = Route.SEARCH + "/{mealName}/{dayOfMonth}/{month}/{year}",
                                arguments = listOf(
                                    navArgument("mealName") {
                                        type = NavType.StringType
                                    },
                                    navArgument("dayOfMonth") {
                                        type = NavType.IntType
                                    },
                                    navArgument("month") {
                                        type = NavType.IntType
                                    },
                                    navArgument("year") {
                                        type = NavType.IntType
                                    },

                                )
                            ) {
                                val mealName = it.arguments?.getString("mealName")!!
                                val dayOfMonth = it.arguments?.getInt("dayOfMonth")!!
                                val month = it.arguments?.getInt("month")!!
                                val year = it.arguments?.getInt("year")!!
                                SearchScreen(
                                    snackbarHostState = snackbarHostState,
                                    mealName = mealName,
                                    dayOfMonth = dayOfMonth,
                                    month = month,
                                    year = year,
                                    onNavigateUp = {
                                        navController.navigateUp()
                                    }
                                )
                            }
                        }
                        Column(modifier = Modifier.padding(padding)) {
                        }
                    }
                )
            }//THEME
        }
    }
}

