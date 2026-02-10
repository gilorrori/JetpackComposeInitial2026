package com.gilorroristore.jetpackcompose2026.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.gilorroristore.jetpackcompose2026.R

@Preview
@Composable
fun Progress(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(140.dp),
            color = Color.Red,
            strokeWidth = 8.dp,
            trackColor = Color.Gray,
            strokeCap = StrokeCap.Round
        )
        Spacer(modifier = modifier.height(24.dp))
        LinearProgressIndicator(
            color = Color.Blue,
            trackColor = Color.Green,
            strokeCap = StrokeCap.Round
        )
    }
}

@Composable
fun ProgressAdvance(modifier: Modifier = Modifier) {
    var progress: Float by remember { mutableFloatStateOf(0.5f) }
    val animatedProgress by animateFloatAsState(targetValue = progress)
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (isLoading) {
            CircularProgressIndicator(
                progress = { animatedProgress },
                modifier = Modifier.size(140.dp),
                color = Color.Red,
                strokeWidth = 8.dp,
                trackColor = Color.Gray,
                strokeCap = StrokeCap.Round
            )
        }

        Spacer(modifier = modifier.height(24.dp))
        LinearProgressIndicator(
            progress = { animatedProgress },
            color = Color.Red,
            trackColor = Color.Gray,
            strokeCap = StrokeCap.Round
        )

        Row(modifier = modifier) {

            Button(onClick = { progress -= 0.08f }
            ) { Text(text = "Disminuir") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { progress += 0.08f }
            ) { Text(text = "Aumentar") }
        }

        Button(onClick = { isLoading = !isLoading }) { Text("Show/hide") }
    }
}

@Composable
fun ProgressLottie(modifier: Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever
        )
    }
}