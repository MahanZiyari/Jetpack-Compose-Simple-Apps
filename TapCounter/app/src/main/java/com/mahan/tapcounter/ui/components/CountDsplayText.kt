package com.mahan.tapcounter.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun CounterText(
    tapCount: Int = 0
) {
    Text(
        text = tapCount.toString(),
        style = TextStyle(
            color = Color.White,
            fontSize = 34.sp,
            fontWeight = FontWeight.ExtraBold
        )
    )
}

@Preview
@Composable
fun CounterTextPreview() {
    CounterText(125)
}