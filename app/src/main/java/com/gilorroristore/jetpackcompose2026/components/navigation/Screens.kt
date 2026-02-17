package com.gilorroristore.jetpackcompose2026.components.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id: String, val showID: Boolean)