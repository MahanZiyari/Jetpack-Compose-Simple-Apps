package com.mahan.tapcounter.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterialApi
@Composable
fun TapButton(
    modifier: Modifier = Modifier,
    textSize: TextUnit = 40.sp,
    tapCount: Int = 0,
    onClick: (Int) -> Unit = {}
) {
    Card(
        onClick = {
            onClick(tapCount + 1)
        },
        modifier = modifier
            .padding(4.dp),
        shape = CircleShape,
        elevation = 8.dp,
        border = BorderStroke(
            width = 0.5.dp,
            color = Color.LightGray
        )
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "Tap Me",
                style = TextStyle(
                    fontSize = textSize,
                    fontStyle = MaterialTheme.typography.button.fontStyle,
                    fontWeight = MaterialTheme.typography.button.fontWeight
                )
            )
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun TapButtonPreview() {
    TapButton(
        modifier = Modifier.size(200.dp),
        textSize = 35.sp
    )
}