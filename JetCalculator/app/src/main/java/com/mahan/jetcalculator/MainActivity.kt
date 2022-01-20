package com.mahan.jetcalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahan.jetcalculator.ui.components.NumPad
import com.mahan.jetcalculator.ui.components.OperatorsPad
import com.mahan.jetcalculator.ui.theme.JetCalculatorTheme
import com.mahan.jetcalculator.utils.Operator
import com.mahan.jetcalculator.utils.Utils

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCalculatorTheme {
                MainContent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainContent() {
    // States
    var displayText by remember {
        mutableStateOf("")
    }
    // UI
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround
        ) {

            Box(
                modifier = Modifier
                    .background(Color.DarkGray)
                    .fillMaxSize()
                    .weight(30f),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = displayText,
                    textAlign = TextAlign.Start,
                    color = Color.White,
                    fontSize = 46.sp,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(70f)
            ) {
                NumPad(
                    modifier = Modifier.weight(75f),
                    onClick = {
                        when (it) {
                            -1 -> displayText = Utils.evaluate(displayText).toString()
                            else -> displayText = displayText.plus(it)
                        }
                        Log.d("MainContent", "MainContent: $it")
                    }
                )

                Divider(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.25f),
                    color = Color.White,
                    thickness = 0.5.dp
                )

                OperatorsPad(
                    modifier = Modifier
                        .background(Color(0xff2b2b2b))
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .weight(24f),
                    onClick = {
                        displayText = if (it == Operator.BackSpace.name) {
                            displayText.dropLast(1)
                        } else
                            displayText.plus(it)
                    }
                )
            }
        }
    }
}