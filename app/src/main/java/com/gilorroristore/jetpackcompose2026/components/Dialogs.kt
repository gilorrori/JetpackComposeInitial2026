@file:OptIn(ExperimentalMaterial3Api::class)

package com.gilorroristore.jetpackcompose2026.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.gilorroristore.jetpackcompose2026.R
import com.gilorroristore.jetpackcompose2026.model.PokemonCombat
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
                val filterCalendar = Calendar.getInstance().apply { timeInMillis = utcTimeMillis }
                val day = filterCalendar.get(Calendar.DAY_OF_MONTH)
                return day % 2 == 0
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

@Composable
fun MyTimePicker(modifier: Modifier = Modifier) {
    var showTimePicker by remember { mutableStateOf(true) }
    val timePickerState = rememberTimePickerState(
        initialHour = 7,
        initialMinute = 33,
        is24Hour = false
    )

    if (showTimePicker) {
        Dialog(onDismissRequest = { showTimePicker = false }
        ) {
            Column(modifier = Modifier.background(Color.White)) {
                TimePicker(
                    state = timePickerState,
                    layoutType = TimePickerLayoutType.Vertical,
                    colors = TimePickerDefaults.colors(
                        clockDialColor = Color.Red,
                        clockDialSelectedContentColor = Color.Red,
                        selectorColor = Color.White,
                        clockDialUnselectedContentColor = Color.White,
                        containerColor = Color.White,
                        periodSelectorBorderColor = Color.Red,
                        periodSelectorUnselectedContentColor = Color.Red,
                        periodSelectorUnselectedContainerColor = Color.White,
                        periodSelectorSelectedContainerColor = Color.Red,
                        periodSelectorSelectedContentColor = Color.White,
                        timeSelectorUnselectedContentColor = Color.Red,
                        timeSelectorUnselectedContainerColor = Color.White,
                        timeSelectorSelectedContainerColor = Color.Red,
                        timeSelectorSelectedContentColor = Color.White
                    )
                )
            }
        }
    }
}

@Composable
fun MyCustomDialog(
    modifier: Modifier = Modifier,
    pokemonCombat: PokemonCombat,
    showDialog: Boolean,
    onStartCombat: () -> Unit,
    onDismissDialog: () -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = { onDismissDialog() }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(24))
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Center
                )
                {
                    Text(
                        text = pokemonCombat.pokemonA,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "VS")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = pokemonCombat.pokemonB,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
                Button(
                    onClick = { onStartCombat() }
                ) {
                    Text(text = "A luchar")
                }


                TextButton (
                    onClick = { onDismissDialog() }
                ) {
                    Text(text = "Cancelar")
                }
            }
        }
    }
}