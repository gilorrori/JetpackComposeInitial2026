package com.gilorroristore.jetpackcompose2026.components

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.gilorroristore.jetpackcompose2026.R
@Composable
fun MyBadge(modifier: Modifier = Modifier) {
    Badge(
        contentColor = Color.White
    ) {
        Text(
            text = "3"
        )
    }
}

@Preview
@Composable
fun MyBadBox(modifier: Modifier = Modifier) {
    BadgedBox(
        badge = { MyBadge() }
    ) {
        Icon(painter = painterResource(R.drawable.ic_info), contentDescription = "")
    }
}