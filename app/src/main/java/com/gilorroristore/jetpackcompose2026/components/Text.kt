package com.gilorroristore.jetpackcompose2026.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
fun MyTexts(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Daniel s")
        Text(text = "Nombre rojo", color = Color.Red)
        Text(text = "Pepe", fontSize = 25.sp)
        Text(text = "Italic", fontStyle = FontStyle.Italic)
        Text(
            text = "FontWeight",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 25.sp
        )
        Text(
            text = "FontWeight",
            letterSpacing = 4.sp
        )
        Text(
            text = "TextDecoration",
            textDecoration = TextDecoration.Underline + TextDecoration.LineThrough
        )

        Text(
            text = "Texto para prueba de espacios, Aligh, Aligh, Aligh, Aligh, Aligh, Aligh, Aligh, ,Aligh, Aligh",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}