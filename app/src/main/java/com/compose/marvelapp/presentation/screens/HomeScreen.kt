package com.compose.marvelapp.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.compose.marvelapp.domain.entities.superhero.SuperheroList
import com.compose.marvelapp.presentation.navigation.AppRoutes
import com.compose.marvelapp.presentation.theme.MarvelAppTheme
import com.compose.marvelapp.presentation.views.CustomAppBar
import com.compose.marvelapp.presentation.views.NetworkGifImage

@Composable
fun HomeScreen(navController: NavHostController) {
    val superheroList = SuperheroList.superheroes
    Scaffold(
        topBar = { CustomAppBar(title = "Marvel App") { navController.popBackStack() } },
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(10.dp)
            ) {
                items(superheroList.size) { index ->
                    val superhero = superheroList[index]
                    Column {
                        NetworkGifImage(superhero.urlGifImage) {
                            navController.navigate(
                                route = "${AppRoutes.SUPERHERO_COMICS}/${superhero.name}"
                            )
                        }
                        Text(
                            text = superheroList[index].name,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MarvelAppTheme {
        HomeScreen(rememberNavController())
    }
}