package com.gilorroristore.jetpackcompose2026.animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyAnimateContent(modifier: Modifier = Modifier) {
    var number by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 40.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = { number++ }
        ) {
            Text(text = "Sumar")
        }

        AnimatedContent(
            targetState = number
        ) {
            when (it) {
                0 -> Box(Modifier
                    .size(50.dp)
                    .background(Color.Red))
                1 -> Box(Modifier
                    .size(20.dp)
                    .background(Color.Green))
                2 -> Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                3 -> Box(Modifier
                    .fillMaxSize()
                    .background(Color.Black))
            }
        }

    }
}