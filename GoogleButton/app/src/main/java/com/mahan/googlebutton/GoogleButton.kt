package com.mahan.googlebutton

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mahan.googlebutton.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun GoogleButton(
    text: String,
    loadingText: String,
    icon: Painter = painterResource(id = R.drawable.ic_google),
    shape: Shape = Shapes.medium,
    borderColor: Color = Color.LightGray,
    backGroundColor: Color = MaterialTheme.colors.surface,
    progressIndicatorColor: Color = MaterialTheme.colors.primary,
    onClick: () -> Unit
) {
    // state of progressIndicator
    var clicked by remember { mutableStateOf(false) }


    Surface(
        onClick = { clicked = !clicked },
        shape = shape,
        color = backGroundColor,
        border = BorderStroke(width = 1.dp, color = borderColor),
        elevation = 12.dp
    ) {
        // Surface or Custom Button Scope
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
        ) {
            // Content Row Scope
            Icon(
                painter = icon,
                contentDescription = "Google Button",
                // For showing Default Color of Icon
                tint = Color.Unspecified
            )
            // Space for Logo and Button Text
            Spacer(modifier = Modifier.width(8.dp))
            // Text of Button that changes by changing the clicked State
            Text(text = if (clicked) loadingText else text)

            if (clicked) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )
                onClick()
            }

        } // End of Content Row Scope

    } // End of Surface Scope
}


@ExperimentalMaterialApi
@Preview
@Composable
private fun GoogleButtonPreview() {
    GoogleButton(
        text = "Sign in With Google",
        loadingText = "Signing in ...",
        onClick = {}
    )
}