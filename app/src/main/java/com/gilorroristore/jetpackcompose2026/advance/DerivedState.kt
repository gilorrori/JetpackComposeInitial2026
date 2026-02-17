package com.gilorroristore.jetpackcompose2026.advance

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyDerivedState(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    //val isFormValid = email.contains("@") && password.length>4

    /**
     * Esto es para cuando se cumplan las caracteristicas que se necesitan de estas vars, se recomponga
     * la vista, para no estarla recomponiendo cada que se escribe en un textfield, debido al on valuechange
     * que se ejecuta al escribir en cada campo.
     *
     * Esto optimiza el rendimiento de la aplicacion.
     */
    val isFormValid by remember(email, password) {
        derivedStateOf {
            email.contains("@") && password.length>4
        }
    }


    Column() {
        TextField(value = email, onValueChange = { email = it })
        Spacer(modifier = Modifier.height(4.dp))
        TextField(value = password, onValueChange = { password = it })
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {},
            enabled = isFormValid
        ) {
            Text(text = "Login")
        }

    }
}