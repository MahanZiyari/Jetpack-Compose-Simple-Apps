package com.mahan.tapcounter.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahan.tapcounter.ui.components.CounterText
import com.mahan.tapcounter.ui.components.TapButton

@ExperimentalMaterialApi
@Composable
fun HomeScreen() {
    var tapCounts by remember {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.primaryVariant
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CounterText(
                tapCount = tapCounts
            )
            Spacer(modifier = Modifier.height(100.dp))
            TapButton(
                modifier = Modifier.size(200.dp),
                tapCount = tapCounts,
                textSize = 35.sp
            ) { newValue ->
                tapCounts = newValue
            }
        }
    }
}

@Preview (showBackground = true)
@ExperimentalMaterialApi
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}