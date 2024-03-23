package com.compose.marvelapp.presentation.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    title: String,
    onBackClicked: (() -> Unit)? = null,
) {
    Surface(shadowElevation = 10.dp) {
        TopAppBar(
            title = { Text(text = title) },
            navigationIcon = {
                onBackClicked?.let {
                    IconButton(onClick = { it() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun CustomAppBarPreview() {
    CustomAppBar(title = "Marvel App") {}
}