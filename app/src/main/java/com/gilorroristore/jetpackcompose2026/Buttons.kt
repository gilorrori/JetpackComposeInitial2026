package com.gilorroristore.jetpackcompose2026

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButton(modifier: Modifier) {
    Column(modifier = modifier) {
        Button(
            onClick = {

            },
            enabled = true,
            shape = RoundedCornerShape(30),
            border = BorderStroke(0.7.dp, Color.Blue),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Green,
                containerColor = Color.White,
                disabledContentColor = Color.DarkGray,
                disabledContainerColor = Color.Gray
            )
        ) {
            Text(
                text = "Pulsame"
            )
        }

        OutlinedButton(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Magenta
            )
        ) {
            Text(
                text = "Outlined button"
            )
        }

        TextButton(
            onClick = {},
            colors = ButtonDefaults.textButtonColors(contentColor = Color.Blue)
        ) {
            Text(
                text = "Text button"
            )
        }

        ElevatedButton(
            onClick = {},
            elevation = ButtonDefaults.elevatedButtonElevation(pressedElevation = 12.dp)
        ) {
            Text(
                text = "Elevated button"
            )
        }

        FilledTonalButton(
            onClick = {}
        ) {
            Text(
                text = "FilledTonal button"
            )
        }
    }

}

