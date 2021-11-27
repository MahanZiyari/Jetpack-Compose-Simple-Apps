package com.mahan.googlebutton

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mahan.googlebutton.ui.theme.GoogleButtonTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleButtonTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // First Button With Surface Color
                    GoogleButton(
                        text = "Sign in With Google",
                        loadingText = "Signing in ...",
                        onClick = {
                            Toast.makeText(
                                this@MainActivity,
                                "First Button Clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    // Second Button With Primary Color
                    GoogleButton(
                        text = "Sign up with Google",
                        loadingText = "Creating Account...",
                        backGroundColor = MaterialTheme.colors.primary,
                        progressIndicatorColor = Color.White,
                        onClick = {
                            Toast.makeText(
                                this@MainActivity,
                                "Second Button Clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GoogleButtonTheme {

    }
}