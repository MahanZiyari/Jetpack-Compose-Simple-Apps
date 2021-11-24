package com.mahan.expandablecard

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
    title: String,
    description: String
) {
    // State of card expansion
    var expanded by remember { mutableStateOf(false) }

    // State of iconButton rotation
    val rotation by animateFloatAsState(targetValue = if (expanded) 180f else 0f)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = MaterialTheme.shapes.medium,
        onClick = { expanded = !expanded },
        elevation = 8.dp,
        border = BorderStroke(width = 2.dp, color = Color.Black)
    ) {
        // Card Scope
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            // Column Scope
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Title of the card
                Text(
                    modifier = Modifier.weight(6f),
                    text = title,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        fontWeight = MaterialTheme.typography.h6.fontWeight,
                        fontStyle = MaterialTheme.typography.h6.fontStyle
                    )
                )

                // Expansion IconButton
                IconButton(
                    onClick = { expanded = !expanded },
                    modifier = Modifier
                        .weight(1f)
                        .size(24.dp)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotation)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-down button"
                    )
                }
            }// End of header Row Scope

            if (expanded) {
                Text(
                    text = description,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.body1.fontSize,
                        fontWeight = MaterialTheme.typography.body1.fontWeight,
                        fontStyle = MaterialTheme.typography.body1.fontStyle
                    )
                )
            }
        }// End of Column Scope
    }
}


@ExperimentalMaterialApi
@Preview
@Composable
fun ExpandableCardPreview() {
    ExpandableCard(title = "My Title", description = "Hello Android")
}