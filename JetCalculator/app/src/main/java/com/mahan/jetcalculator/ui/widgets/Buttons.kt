package com.mahan.jetcalculator.ui.widgets

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.mahan.jetcalculator.R
import com.mahan.jetcalculator.utils.Operator


@Composable
fun NumberButton(
    modifier: Modifier = Modifier,
    number: Int?,
    onClick: (Int) -> Unit,
    text: String = "",
    textSize: TextUnit = 34.sp
) {
    IconButton(
        onClick = {
            if (number != null)
                onClick(number)
            else if (text == "=")
                onClick(-1)
        },
        modifier = modifier
    ) {
        // if we pass a number as parameter
        number?.let {
            Text(
                text = it.toString(),
                style = TextStyle(
                    color = Color.White,
                    fontSize = textSize,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
        // if we pass a text like "." or "="
        if (text.isNotEmpty()) {
            Text(
                text = text,
                style = TextStyle(
                    color = Color.White,
                    fontSize = textSize,
                    fontWeight = FontWeight.SemiBold
                )
            )
        }
    }
}

@Composable
fun OperatorButton(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit,
    iconId: Int,
    iconTint: Color = MaterialTheme.colors.secondary
) {
    IconButton(
        onClick = {
            when (iconId) {
                R.drawable.ic_baseline_add_24 -> onClick("+")
                R.drawable.ic_baseline_remove_24 -> onClick("-")
                R.drawable.ic_baseline_close_24 -> onClick("x")
                R.drawable.ic_divide_svgrepo_com -> onClick("/")
                else -> onClick(Operator.BackSpace.name)
            }
        },
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = "Operator Button",
            tint = iconTint
        )
    }
}