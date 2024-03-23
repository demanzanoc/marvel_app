package com.compose.marvelapp.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.compose.marvelapp.presentation.views.CustomAppBar

@Composable
fun ComicDetailScreen(navController: NavHostController) {
    Scaffold(
        topBar = { CustomAppBar(title = "Comic Detail") { navController.popBackStack() } }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        )
    }
}