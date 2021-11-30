package com.mahan.simplecoilapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.mahan.simplecoilapp.ui.theme.SimpleCoilAppTheme


class MainActivity : ComponentActivity() {
    @ExperimentalCoilApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCoilAppTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CoilImage()
                }
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun CoilImage() {
    // State of Image ID that will pass to api
    var imageIdState by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(enabled = true,
                onClick = {
                    imageIdState = getRandomNumber(0, 1000)
                }
            )
    ) {
        // Box Scope

        // rememberImagePainter is part of coil-kt:coil-compose library
        val painter = rememberImagePainter(
            // api call to receive an image url
            data = "https://picsum.photos/id/$imageIdState/200/300",
            // builder is used for actions like cropping, scaling, add loading placeHolder and etc.
            builder = {
                // error function called when painter gets and http error
                error(R.drawable.ic_baseline_error)
            }
        )

        Image(
            painter = painter,
            contentDescription = "Image",
            modifier = Modifier.fillMaxSize()
        )

        // determines if painter is loading image or not
        val painterState = painter.state
        if (painterState is ImagePainter.State.Loading) {
            CircularProgressIndicator()
        }
    }
}