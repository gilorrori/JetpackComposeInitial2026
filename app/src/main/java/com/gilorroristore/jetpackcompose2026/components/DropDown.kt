@file:OptIn(ExperimentalMaterial3Api::class)

package com.gilorroristore.jetpackcompose2026.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.gilorroristore.jetpackcompose2026.R

@Composable
fun MyExposedDropDownMenu(modifier: Modifier = Modifier) {
    var selection by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        TextField(
            value = selection,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = "Idioma") },
            modifier = Modifier
                .menuAnchor(type = ExposedDropdownMenuAnchorType.PrimaryNotEditable, enabled = true)
                .fillMaxWidth(),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded)
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            DropdownMenuItem(
                modifier = modifier.fillMaxWidth(),
                text = { Text(text = "Opcion 1") },
                onClick = {
                    selection = "Opcion 1"
                    expanded = false
                })
            DropdownMenuItem(
                modifier = modifier.fillMaxWidth(),
                text = { Text(text = "Opcion 2") },
                onClick = {
                    selection = "Opcion 2"
                    expanded = false
                })
            DropdownMenuItem(
                modifier = modifier.fillMaxWidth(),
                text = { Text(text = "Opcion 3") },
                onClick = {
                    selection = "Opcion 3"
                    expanded = false
                })
            DropdownMenuItem(
                modifier = modifier.fillMaxWidth(),
                text = { Text(text = "Opcion 4") },
                onClick = {
                    selection = "Opcion 4"
                    expanded = false
                })
        }
    }
}

@Composable
fun MyDropDownMenu(modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        Button(onClick = { expanded = true }) {
            Text(text = "Ver opciones")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(10.dp, 0.dp),
            properties = PopupProperties(
                focusable = true,
                dismissOnClickOutside = false,
                dismissOnBackPress = false,
                // El dropdown no se salga de la vista (pantalla)
                clippingEnabled = true
            )
        ) {
            DropdownMenuItem(
                modifier = modifier.fillMaxWidth(),
                text = { Text(text = "Opcion 1") },
                onClick = { expanded = false })
            DropdownMenuItem(
                modifier = modifier.fillMaxWidth(),
                text = { Text(text = "Opcion 2") },
                onClick = { expanded = false })
            DropdownMenuItem(
                modifier = modifier.fillMaxWidth(),
                text = { Text(text = "Opcion 3") },
                onClick = { expanded = false })
            DropdownMenuItem(
                modifier = modifier.fillMaxWidth(),
                text = { Text(text = "Opcion 4") },
                onClick = { expanded = false })
        }
    }
}

@Composable
fun MyDropDownItem(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
        DropdownMenuItem(
            modifier = modifier.fillMaxWidth(),
            text = {
                Text(text = "Ejemplo 1")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_info),
                    contentDescription = ""
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_personita),
                    contentDescription = ""
                )
            },
            contentPadding = PaddingValues(start = 16.dp),
            colors = MenuDefaults.itemColors(
                textColor = Color.Red,
                leadingIconColor = Color.Blue,
                trailingIconColor = Color.Green,
                disabledTextColor = Color.Yellow,
                disabledLeadingIconColor = Color.Yellow,
                disabledTrailingIconColor = Color.Yellow,
            ),
            onClick = {

            },

            )
    }


}