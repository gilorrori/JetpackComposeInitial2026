package com.gilorroristore.jetpackcompose2026.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@Composable
fun MyTextFieldParent(modifier: Modifier) {
    var user by rememberSaveable { mutableStateOf("Dn") }
    var value by rememberSaveable { mutableStateOf("") }
    Column(modifier = modifier) {
        MyTextField(user = user) { user = it }
        MySecondField(value = value) { value = it }
        MyAdvanceTextField(value = value) { value = it }
        MyPasswordTextField(value = value) { value = it }
        Spacer(modifier = Modifier.height(16.dp))
        MyOutlinedTextField(value = value) { value = it }
    }
}

@Composable
fun MyTextField(user: String, onValueChange: (String) -> Unit) {

    TextField(
        value = user,
        onValueChange = {
            onValueChange(it)
        },
        readOnly = user.isEmpty()
    )
}

@Composable
fun MySecondField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },

        label = {
            Text(text = "Texto superior del tf")
        }
    )
}

@Composable
fun MyAdvanceTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = {
            onValueChange(it.replace("a", ""))
        }
    )
}

@Composable
fun MyPasswordTextField(value: String, onValueChange: (String) -> Unit) {
    var passwordHidden by remember { mutableStateOf(true) }

    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text("Introduce tu contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Text(
                text = if (passwordHidden) "Mostrar" else "Ocultar",
                modifier = Modifier.clickable { passwordHidden = !passwordHidden })
        })
}

@Composable
fun MyOutlinedTextField(value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(value = value, onValueChange = { onValueChange(it) })
//    BasicTextField(value = value, onValueChange = { onValueChange(it) })
}