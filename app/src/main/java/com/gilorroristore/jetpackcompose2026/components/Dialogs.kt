package com.gilorroristore.jetpackcompose2026.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.gilorroristore.jetpackcompose2026.R
import java.util.Calendar

@Composable
fun MyDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) }
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = { Button(onClick = { showDialog = false }) { Text(text = "Aceptar") } },
            dismissButton = {
                TextButton(onClick = {
                    showDialog = false
                }) { Text(text = "Cancel") }
            },
            title = { Text("Titulo del dialogo") },
            text = { Text(text = "Estas seguro de cerrar el dialogo?") },
            icon = {
                LottieAnimation(
                    modifier = Modifier.size(70.dp),
                    composition = composition,
                    iterations = LottieConstants.IterateForever
                )
                //Icon(imageVector = Icons.Default.Warning, contentDescription = "")
            },
            shape = RoundedCornerShape(12.dp),
            titleContentColor = Color.Red,
            tonalElevation = 12.dp,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.SecureOn,
                usePlatformDefaultWidth = true,
                decorFitsSystemWindows = true
            )
        )
    }
}

@Composable
fun MyDateDialog(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(true) }
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_WEEK, +1)
    calendar.set(Calendar.MONTH, Calendar.DECEMBER)

    val datePicketState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis,
        initialDisplayedMonthMillis = calendar.timeInMillis,
        yearRange = 2024..2026,
        initialDisplayMode = DisplayMode.Picker,

        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {

                val filterCalendar = Calendar.getInstance().apply {
                    timeInMillis = utcTimeMillis
                }
                val day = filterCalendar.get(Calendar.DAY_OF_MONTH)

                return day != Calendar.SUNDAY
            }
        }
    )

    if (showDialog) {
        DatePickerDialog(
            onDismissRequest = {
                showDialog = false
            },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(text = "Confirmar")
                }
            },
            colors = DatePickerDefaults.colors()
        ) {
            DatePicker(
                state = datePicketState
            )
        }
    }
}