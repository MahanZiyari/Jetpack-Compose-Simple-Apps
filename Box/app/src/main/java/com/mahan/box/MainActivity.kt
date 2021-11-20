package com.mahan.box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahan.box.ui.theme.BoxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BoxTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        // Scope of Parent Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            // If you put more than one Composable fun in Box it acts like a stack
            // the last Invoked Composable function will be the most top element in the screen


            // this Box will be drawn first
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(20.dp)
                    .background(MaterialTheme.colors.secondary)
            )

            // and then we have this text on the top of the cyan Rectangular Box
            Text(text = "Hello Android!", fontSize = 40.sp)


            // finally this Box will be drawn on top of all element
            // because it's the last element
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .background(Color.White)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BoxTheme {
        Greeting()
    }
}