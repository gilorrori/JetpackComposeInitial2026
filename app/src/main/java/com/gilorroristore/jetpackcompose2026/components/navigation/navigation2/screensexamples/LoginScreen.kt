package com.gilorroristore.jetpackcompose2026.components.navigation.navigation2.screensexamples

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(navigate: () -> Unit) {
    var showView by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red.copy(alpha = 0.2f)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "L O G I N", fontSize = 30.sp)
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                navigate()
                //showView = true
            }
        ) {
            Text(
                text = "Navegar"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }

    if (showView) {
        /**
         * Esto se llamará cuando el usuario quiera ir para atras pero quedandose en la misma
         * pantalla es decir en Login
         *
         * Si se pone el BackHandler vacio en una vista como login (al principio) bloqueara el
         * back para esa pantalla como sobreescribir la función onBackPressed con Java
         */
        BackHandler() {
            showView = false
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green)
        ) {

        }
    }
}