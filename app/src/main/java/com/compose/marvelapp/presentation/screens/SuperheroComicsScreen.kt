package com.compose.marvelapp.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.compose.marvelapp.presentation.theme.MarvelAppTheme
import com.compose.marvelapp.presentation.views.CustomAppBar

@Composable
fun SuperheroComicsScreen(navController: NavHostController, superheroName: String) {
    Scaffold(
        topBar = { CustomAppBar(title = "Superhero Comics") { navController.popBackStack() } }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(text = superheroName)
        }
    }
}

@Preview
@Composable
fun SuperheroComicsScreenPreview() {
    MarvelAppTheme {
        SuperheroComicsScreen(navController = rememberNavController(), superheroName = "Iron Man")
    }
}