@file:OptIn(ExperimentalMaterial3Api::class)

package com.gilorroristore.jetpackcompose2026.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.gilorroristore.jetpackcompose2026.R

@Composable
fun MyTopAppBar(onNavSelected: () -> Unit) {

    TopAppBar(
        title = { Text("My Application") },
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_info),
                contentDescription = null,
                modifier = Modifier.clickable{
                    onNavSelected()
                }
            )
        },
        actions = {
            Icon(
                painter = painterResource(R.drawable.ic_personita),
                contentDescription = null,
                tint = Color.Magenta
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.Red,
            scrolledContainerColor = Color.Black
        )
    )
}