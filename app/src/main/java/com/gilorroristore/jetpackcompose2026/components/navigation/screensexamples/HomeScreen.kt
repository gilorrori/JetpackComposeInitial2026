package com.gilorroristore.jetpackcompose2026.components.navigation.screensexamples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(navBack: () -> Unit, navToDetail: (String, Boolean) -> Unit) {
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Home", fontSize = 30.sp)
        Spacer(modifier = Modifier.weight(1f))
        Row() {
            TextField(value = text, onValueChange = { text = it }, modifier = Modifier.weight(1f))
            Button(onClick = { navToDetail(text, true) }) { Text(text = "Detail") }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                navBack()
            }
        ) {
            Text(
                text = "Atras"
            )
        }
        Spacer(modifier = Modifier.weight(1f))

    }
}