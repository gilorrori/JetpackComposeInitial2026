package com.gilorroristore.jetpackcompose2026.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun MyBasicList(modifier: Modifier = Modifier, onItemSelected: (String) -> Unit) {
    val names = listOf(
        "dan",
        "kar",
        "mir",
        "pedro",
        "maria",
        "karla",
        "orlando",
        "guadalupe",
        "dan",
        "kar",
        "mir",
        "pedro",
        "maria",
        "karla",
        "orlando",
    )

    LazyRow {

        items(names) {
            Text(
                text = it, modifier = Modifier
                    .padding(24.dp)
                    .clickable {
                        onItemSelected(it)
                    })
        }
    }
}

@Composable
fun MyAdvanceList(modifier: Modifier = Modifier) {
    var items by remember {
        mutableStateOf(
            List(100) { "Item numero $it" }
        )
    }

    LazyColumn {
        //Creando un elemento manualmente a la misma lista
        item {
            Button(
                onClick = {
                    items = items.toMutableList().apply { add(0, "hola") }
                }
            ) { Text(text = "Añadir item") }
        }

        // Obteniendo el listado junto a su index
        itemsIndexed(items, key = { _, value -> value }) { index, value ->
            Row {
                Text(text = value + " Indice $index")
                Spacer(modifier = Modifier.height(6.dp))
                TextButton(onClick = {
                    items = items.toMutableList().apply {
                        //remove(value)
                        removeAt(index)
                    }
                }) { Text(text = "Borrar") }
                Spacer(modifier = Modifier.width(24.dp))
            }
        }
    }
}

@Composable
fun ScrollList(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 5
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        LazyColumn(state = listState) {
            items(100) {
                Text(
                    "Item $it", modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
        if (showButton) {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        listState.animateScrollToItem(0)
                        //listState.scrollToItem(0)
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Home, contentDescription = null
                )
            }
        }
    }
}

@Composable
fun MyGridList(modifier: Modifier = Modifier) {
    val coroutineScope = rememberCoroutineScope()
    val numbers: MutableState<List<Int>> =
        remember { mutableStateOf(List(50) { Random.nextInt(0, 6) }) }

    val stateList = rememberLazyGridState()
    val showTopButton by remember {
        derivedStateOf {
            stateList.firstVisibleItemIndex > 5
        }
    }

    val colors = listOf(
        Color(0xFFE57373),
        Color(0xFFFFB74D),
        Color(0xFFFFF176),
        Color(0xFF81C784),
        Color(0xFF64B5F6),
        Color(0xFFBA68C8)
    )

    Box(contentAlignment = Alignment.BottomCenter) {
        LazyVerticalGrid (
            columns = GridCells.Adaptive(80.dp),
            //        rows = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize(),
            state = stateList
        ) {
            items(numbers.value) { randomNumber ->
                Box(
                    modifier = Modifier
                        .background(color = colors[randomNumber])
                        .height(80.dp),

                    ) {
                    Text(randomNumber.toString(), color = Color.White, fontSize = 28.sp)
                }
            }
        }

        if (showTopButton) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        stateList.animateScrollToItem(index = 0)
                    }
                }
            ) {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
            }
        }
    }
}