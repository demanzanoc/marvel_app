package com.compose.marvelapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.compose.marvelapp.presentation.navigation.AppNavigator
import com.compose.marvelapp.presentation.theme.MarvelAppTheme

class HomeActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            MarvelAppTheme {
                AppNavigator(navController)
            }
        }
    }
}