package com.gilorroristore.jetpackcompose2026.components.navigation.navigation2.screensexamples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(navigate: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().background(Color.Red.copy(alpha = 0.2f)), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "L O G I N", fontSize = 30.sp)
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                navigate()
            }
        ) {
            Text(
                text = "Navegar"
            )
        }
        Spacer(modifier = Modifier.weight(1f))

    }
}