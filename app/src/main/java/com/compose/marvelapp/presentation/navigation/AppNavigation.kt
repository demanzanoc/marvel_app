package com.compose.marvelapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.compose.marvelapp.presentation.screens.ComicDetailScreen
import com.compose.marvelapp.presentation.screens.HomeScreen
import com.compose.marvelapp.presentation.screens.StartingScreen
import com.compose.marvelapp.presentation.screens.SuperheroComicsScreen

@Composable
fun AppNavigator(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppRoutes.STARTING) {
        composable(AppRoutes.STARTING) { StartingScreen(navController) }
        composable(AppRoutes.HOME) { HomeScreen(navController) }
        composable(AppRoutes.SUPERHERO_COMICS) { SuperheroComicsScreen(navController) }
        composable(AppRoutes.COMIC_DETAILS) { ComicDetailScreen(navController) }
    }
}