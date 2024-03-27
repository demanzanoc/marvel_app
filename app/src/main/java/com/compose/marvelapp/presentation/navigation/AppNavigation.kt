package com.compose.marvelapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.compose.marvelapp.presentation.screens.comics.ComicDetailScreen
import com.compose.marvelapp.presentation.screens.comics.HomeScreen
import com.compose.marvelapp.presentation.screens.comics.StartingScreen
import com.compose.marvelapp.presentation.screens.comics.SuperheroComicsScreen
import com.compose.marvelapp.presentation.viewmodels.comics.SuperheroComicsViewModel

@Composable
fun AppNavigator(navController: NavHostController) {
    val viewModel: SuperheroComicsViewModel = hiltViewModel()
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
                viewModel = viewModel,
                superheroName = backStackEntry.arguments?.getString(NavArguments.SUPERHERO_NAME)
                    ?: ""
            )
        }
        composable(
            route = "${AppRoutes.COMIC_DETAILS}/{${NavArguments.COMIC_ID}}",
            arguments = listOf(
                navArgument(NavArguments.COMIC_ID) { type = NavType.IntType }
            )
        ) { backStackEntry ->
            ComicDetailScreen(
                viewModel = viewModel,
                comicId = backStackEntry.arguments?.getInt(NavArguments.COMIC_ID) ?: 0
            )
        }
    }
}