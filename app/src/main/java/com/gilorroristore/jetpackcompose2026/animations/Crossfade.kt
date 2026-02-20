package com.gilorroristore.jetpackcompose2026.animations

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gilorroristore.jetpackcompose2026.components.navigation.navigation2.screensexamples.DetailScreen
import com.gilorroristore.jetpackcompose2026.components.navigation.navigation2.screensexamples.HomeScreen
import com.gilorroristore.jetpackcompose2026.components.navigation.navigation2.screensexamples.LoginScreen

@Composable
fun MyCrossfade(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf("Home") }

    Column {
        Row(modifier = Modifier.padding(top = 32.dp)) {
            Text(text = "Home", modifier = Modifier.clickable { currentScreen = "Home" })
            Text(text = "Detail", modifier = Modifier.clickable { currentScreen = "Detail" })
            Text(text = "Login", modifier = Modifier.clickable { currentScreen = "Login" })
        }

        Crossfade(targetState = currentScreen) { screen ->
            when (screen) {
                "Home" -> HomeScreen(navBack = {}, navToDetail = { _, _ -> })
                "Login" -> LoginScreen(navigate = {})
                "Detail" -> DetailScreen(
                    id = "123",
                    showID = true,
                    navBack = {},
                    navToSettings = {})
            }
        }
    }
}