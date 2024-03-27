package com.compose.marvelapp.presentation.screens.comics

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.compose.marvelapp.domain.entities.comics.Comic
import com.compose.marvelapp.presentation.navigation.AppRoutes
import com.compose.marvelapp.presentation.theme.MarvelAppTheme
import com.compose.marvelapp.presentation.viewmodels.comics.SuperheroComicsViewModel
import com.compose.marvelapp.presentation.viewmodels.comics.SuperheroViewModelStatus
import com.compose.marvelapp.presentation.viewmodels.comics.SuperheroViewModelStatus.*
import com.compose.marvelapp.presentation.views.CustomAppBar
import com.compose.marvelapp.presentation.views.CustomCircularProgressBar

@Composable
fun SuperheroComicsScreen(
    navController: NavHostController,
    viewModel: SuperheroComicsViewModel,
    superheroName: String,
) {
    LaunchedEffect(Unit) {
        viewModel.getComics(superheroName)
    }
    val comics by viewModel.comics.observeAsState(emptyList())
    val statusGetComics by viewModel.statusGetComics.observeAsState(INITIAL)

    Scaffold(
        topBar = { CustomAppBar(title = "Superhero Comics") { navController.popBackStack() } }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            ValidateStatusGetComics(
                statusGetComics,
                Modifier.align(Alignment.Center),
                comics,
                navController,
                viewModel,
                superheroName
            )
        }
    }
}

@Composable
private fun ComicsImagesGrid(comics: List<Comic>, navController: NavHostController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp)
    ) {
        itemsIndexed(comics) { index, comic ->
            AsyncImage(
                model = comic.image,
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 6.dp, vertical = 4.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .height(180.dp)
                    .clickable { navController.navigate(route = "${AppRoutes.COMIC_DETAILS}/${index}") },
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Composable
fun ValidateStatusGetComics(
    statusGetComics: SuperheroViewModelStatus,
    modifier: Modifier,
    comics: List<Comic>,
    navController: NavHostController,
    viewModel: SuperheroComicsViewModel,
    superheroName: String,
) {
    when (statusGetComics) {
        INITIAL -> Box(Modifier.fillMaxSize())
        SUCCESS -> ComicsImagesGrid(comics, navController)
        LOADING -> CustomCircularProgressBar(modifier = modifier)
        ERROR -> RetryView(viewModel, modifier, superheroName)
    }
}

@Composable
fun RetryView(viewModel: SuperheroComicsViewModel, modifier: Modifier, superheroName: String) {
    Column(
        modifier = modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "An error occurred while obtaining the comics")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { viewModel.getComics(superheroName) }, modifier.height(40.dp)) {
            Text(text = "Retry")
        }
    }
}


@Preview
@Composable
fun SuperheroComicsScreenPreview() {
    MarvelAppTheme {
        SuperheroComicsScreen(navController = rememberNavController(), viewModel(), "Iron Man")
    }
}