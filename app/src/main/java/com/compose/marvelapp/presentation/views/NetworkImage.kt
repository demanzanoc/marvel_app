package com.compose.marvelapp.presentation.views

import android.os.Build
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.compose.marvelapp.presentation.theme.MarvelAppTheme


@Composable
fun NetworkGifImage(urlGifImage: String) {
    Box(
        modifier = Modifier
            .padding(6.dp)
            .height(160.dp)
    ) {
        Column {
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(urlGifImage)
                    .decoderFactory(getDecoderFactory())
                    .build(),
                contentDescription = "network gif image",
                loading = { CenterCircularProgressBar() },
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Composable
fun CenterCircularProgressBar() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

fun getDecoderFactory() =
    if (Build.VERSION.SDK_INT >= 28) ImageDecoderDecoder.Factory() else GifDecoder.Factory()

@Preview(showBackground = true)
@Composable
fun NetworkGifImagePreview() {
    MarvelAppTheme {
        NetworkGifImage("")
    }
}
