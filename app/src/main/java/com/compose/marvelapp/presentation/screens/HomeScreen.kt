package com.compose.marvelapp.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.compose.marvelapp.presentation.navigation.AppRoutes
import com.compose.marvelapp.presentation.views.CustomAppBar

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = { CustomAppBar(title = "Marvel App") { navController.popBackStack() } }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .clickable { navController.navigate(route = AppRoutes.SUPERHERO_COMICS) }
        )
    }
}