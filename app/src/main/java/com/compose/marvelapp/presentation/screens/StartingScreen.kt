package com.compose.marvelapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.compose.marvelapp.R
import com.compose.marvelapp.presentation.navigation.AppRoutes
import com.compose.marvelapp.presentation.theme.MarvelAppTheme

@Composable
fun StartingScreen(navController: NavHostController) {
    Surface(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
        Box(
            Modifier
                .padding(20.dp)
                .fillMaxSize()) {
            Image(
                painterResource(id = R.drawable.marvel_icon_image),
                contentDescription = "marvel image",
                modifier = Modifier.align(Alignment.Center)
            )
            Button(
                onClick = { navController.navigate(AppRoutes.HOME) },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 10.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    MaterialTheme.colorScheme.secondary
                )
            ) {
                Text(text = "Start", Modifier.padding(vertical = 4.dp, horizontal = 16.dp), fontSize = 20.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartingScreenPreview() {
    MarvelAppTheme(darkTheme = false) {
        StartingScreen(navController = rememberNavController())
    }
}