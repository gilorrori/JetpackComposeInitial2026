package com.gilorroristore.jetpackcompose2026.components.navigation.navigation2.screensexamples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.gilorroristore.jetpackcompose2026.components.navigation.navigation2.screensexamples.model.SettingModel

@Composable
fun SettingsScreen(settingModel: SettingModel, navBack: () -> Unit) {

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "S E T T I N G S: ${settingModel.id}, ${settingModel.darkMode}",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { navBack() }
        ) {
            Text(text = "Volver al inicio")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}