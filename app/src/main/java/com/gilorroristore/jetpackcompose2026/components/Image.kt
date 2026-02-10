package com.gilorroristore.jetpackcompose2026.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.gilorroristore.jetpackcompose2026.R


@Composable
fun MyImage(modifier: Modifier) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.payaso),
            contentDescription = stringResource(R.string.avatar_image_description),
            modifier = Modifier
                .size(300.dp)
                .border(width = 5.dp, shape = CircleShape, brush = Brush.linearGradient(
                    colors = listOf(Color.Red, Color.Blue, Color.Yellow)
                ))
                .clip(RoundedCornerShape(50)),
            contentScale = ContentScale.FillBounds
        )

        AsyncImage(
            model = "https://avatars.githubusercontent.com/u/34010581?v=4",
            contentDescription = stringResource(R.string.coil_image_description),
            modifier = modifier
                .size(200.dp)
                .clip(RoundedCornerShape(50)) ,
            onError = {
                Log.d("COIL", "error ${it.result.throwable.message}")
            }
        )
    }
}

@Preview
@Composable
fun MyIcon() {
    Icon(
        painter = painterResource(R.drawable.ic_personita),
        contentDescription = "",
        modifier = Modifier.size(300.dp),
        tint = Color.Red
    )
}