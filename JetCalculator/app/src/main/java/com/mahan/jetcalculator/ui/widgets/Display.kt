package com.mahan.jetcalculator.ui.widgets

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun Display(
    modifier: Modifier = Modifier,
    text: String,
    onValueChanged: (String) -> Unit
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.background
    ) {
        TextField(
            value = text,
            onValueChange = {
                onValueChanged(it)
            },
            readOnly = true,
            placeholder = {
                Text(text = "e.g. 54+12")
            },
            singleLine = true
        )
    }
}

@Preview
@Composable
fun DisplayPreview() {
    Display(
        text = "",
        onValueChanged = {}
    )
}