package com.mahan.jetdiceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahan.jetdiceroller.ui.theme.JetDiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetDiceRollerTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    // States
    var diceNumber by remember {
        mutableStateOf(1)
    }
    val diceImageId = remember(key1 = diceNumber) {
        when (diceNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1
        }
    }
    // UI
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DiceImage(
                imageId = diceImageId
            )
            Spacer(modifier = Modifier.height(100.dp))
            Button(
                onClick = {
                    diceNumber = rollDice()
                },
                modifier = Modifier.size(120.dp, 50.dp)
            ) {
                Text(
                    text = "Roll",
                    style = TextStyle(
                        color = MaterialTheme.colors.onPrimary,
                        fontSize = 28.sp
                    )
                )
            }
        }
    }
}

fun rollDice(): Int = (1..6).random()

@Preview
@Composable
fun DiceImage(
    imageId: Int = R.drawable.dice_1
) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = "Dice",
        modifier = Modifier.padding(4.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetDiceRollerTheme {
        HomeScreen()
    }
}