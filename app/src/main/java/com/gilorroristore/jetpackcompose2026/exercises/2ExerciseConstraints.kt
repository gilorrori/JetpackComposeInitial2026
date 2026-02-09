package com.gilorroristore.jetpackcompose2026.exercises

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Preview(showBackground = true)
@Composable
fun MyFirstConstraint() {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxCyan, boxBlack, boxDarkGray, boxMagenta, boxGreen, boXYellow, boxGray, boxBlue, boxRed) = createRefs()

        Box(
            modifier = Modifier
                .size(175.dp)
                .background(Color.Cyan)
                .constrainAs(boxCyan) {
                    bottom.linkTo(boxMagenta.top)
                    end.linkTo(boxMagenta.end)
                })

        Box(
            modifier = Modifier
                .size(75.dp)
                .background(Color.Black)
                .constrainAs(boxBlack) {
                    start.linkTo(boxCyan.end)
                    top.linkTo(boxCyan.top)
                    bottom.linkTo(boxCyan.bottom)
                    end.linkTo(boxDarkGray.start)
                })

        Box(
            modifier = Modifier
                .size(175.dp)
                .background(Color.DarkGray)
                .constrainAs(boxDarkGray) {
                    start.linkTo(boxGreen.start)
                    bottom.linkTo(boxGreen.top)
                })

        Box(
            modifier = Modifier
                .size(175.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    top.linkTo(boXYellow.bottom)
                    start.linkTo(boXYellow.start)
                    end.linkTo(boXYellow.end)
                })


        Box(
            modifier = Modifier
                .size(75.dp)
                .background(Color.Gray)
                .constrainAs(boxGray) {
                    end.linkTo(boXYellow.start)
                    top.linkTo(boXYellow.bottom)
                })

        Box(
            modifier = Modifier
                .size(75.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta) {
                    end.linkTo(boXYellow.start)
                    bottom.linkTo(boXYellow.top)
                })

        Box(
            modifier = Modifier
                .size(75.dp)
                .background(Color.Yellow)
                .constrainAs(boXYellow) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                })



        Box(
            modifier = Modifier
                .size(75.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    start.linkTo(boXYellow.end)
                    bottom.linkTo(boXYellow.top)
                })


        Box(
            modifier = Modifier
                .size(75.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    start.linkTo(boXYellow.end)
                    top.linkTo(boXYellow.bottom)
                })

    }
}