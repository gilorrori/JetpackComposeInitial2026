package com.gilorroristore.jetpackcompose2026.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyDivider(modifier: Modifier = Modifier) {
    HorizontalDivider(
        modifier = Modifier.padding(vertical = 8.dp),
        thickness = 2.dp,
        color = Color.Yellow
    )


    Row (modifier = Modifier.height(50.dp)){
        Text(text = "izq")
        VerticalDivider(modifier = Modifier.padding(12.dp))
        Text(text = "der")
    }
}