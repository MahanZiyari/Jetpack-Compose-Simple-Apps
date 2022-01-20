package com.mahan.jetcalculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mahan.jetcalculator.R
import com.mahan.jetcalculator.ui.widgets.NumberButton
import com.mahan.jetcalculator.ui.widgets.OperatorButton

@Composable
fun NumPad(
    modifier: Modifier = Modifier,
    onClick: (Int) -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxHeight()
            .background(Color(0xff2b2b2b))
    ) {
        // 7 8 9
        NumPadRow(
            numbers = intArrayOf(7, 8, 9),
            modifier = Modifier
                .weight(25f)
                .fillMaxHeight(),
            onClick = {
                onClick(it)
            }
        )
        // 4 5 6
        NumPadRow(
            numbers = intArrayOf(4, 5, 6),
            modifier = Modifier
                .weight(25f)
                .fillMaxHeight(),
            onClick = {
                onClick(it)
            }
        )
        // 1 2 3
        NumPadRow(
            numbers = intArrayOf(1, 2, 3),
            modifier = Modifier
                .weight(25f)
                .fillMaxHeight(),
            onClick = {
                onClick(it)
            }
        )
        // 0 . =
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .weight(25f)
        ) {
            NumberButton(
                number = 0,
                modifier = Modifier
                    .weight(25f)
                    .fillMaxHeight(),
                onClick = {
                    onClick(it)
                }
            )
            NumberButton(
                number = null,
                text = ".",
                modifier = Modifier
                    .weight(25f)
                    .fillMaxHeight(),
                onClick = {}
            )
            NumberButton(
                number = null,
                text = "=",
                modifier = Modifier
                    .weight(25f)
                    .fillMaxHeight(),
                onClick = {
                    onClick(it)
                }
            )
        }
    }
}

@Preview
@Composable
fun NumPadPreview() {
    NumPad()
}


@Composable
fun NumPadRow(
    modifier: Modifier = Modifier,
    vararg numbers: Int,
    onClick: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        NumberButton(
            number = numbers.first(),
            modifier = Modifier
                .weight(25f)
                .fillMaxHeight(),
            onClick = {
                onClick(it)
            }
        )
        NumberButton(
            number = numbers[1],
            modifier = Modifier
                .weight(25f)
                .fillMaxHeight(),
            onClick = {
                onClick(it)
            }
        )
        NumberButton(
            number = numbers.last(),
            modifier = Modifier
                .weight(25f)
                .fillMaxHeight(),
            onClick = {
                onClick(it)
            }
        )
    }
}

@Composable
fun OperatorsPad(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OperatorButton(
            iconId = R.drawable.ic_outline_backspace_24,
            modifier = Modifier
                .fillMaxSize()
                .weight(20f),
            onClick = {
                onClick(it)
            }
        )
        OperatorButton(
            iconId = R.drawable.ic_baseline_add_24,
            modifier = Modifier
                .fillMaxSize()
                .weight(20f),
            onClick = {
                onClick(it)
            }
        )
        OperatorButton(
            iconId = R.drawable.ic_baseline_close_24,
            modifier = Modifier
                .fillMaxWidth()
                .weight(20f),
            onClick = {
                onClick(it)
            }
        )
        OperatorButton(
            iconId = R.drawable.ic_baseline_remove_24,
            modifier = Modifier
                .fillMaxWidth()
                .weight(20f),
            onClick = {
                onClick(it)
            }
        )
        OperatorButton(
            iconId = R.drawable.ic_divide_svgrepo_com,
            modifier = Modifier
                .fillMaxWidth()
                .weight(20f),
            onClick = {
                onClick(it)
            }
        )
    }
}