package com.compose.marvelapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.compose.marvelapp.presentation.screens.ComicDetailScreen
import com.compose.marvelapp.presentation.screens.HomeScreen
import com.compose.marvelapp.presentation.screens.StartingScreen
import com.compose.marvelapp.presentation.screens.SuperheroComicsScreen

@Composable
fun AppNavigator(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppRoutes.STARTING) {
        composable(AppRoutes.STARTING) { StartingScreen(navController) }
        composable(AppRoutes.HOME) { HomeScreen(navController) }
        composable(
            route = "${AppRoutes.SUPERHERO_COMICS}/{${NavArguments.SUPERHERO_NAME}}",
            arguments = listOf(
                navArgument(NavArguments.SUPERHERO_NAME) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            SuperheroComicsScreen(
                navController = navController,
                superheroName = backStackEntry.arguments?.getString(NavArguments.SUPERHERO_NAME)
                    ?: ""
            )
        }
        composable(AppRoutes.COMIC_DETAILS) { ComicDetailScreen(navController) }
    }
}