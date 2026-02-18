package com.gilorroristore.jetpackcompose2026.components.navigation.navigation2

import com.gilorroristore.jetpackcompose2026.components.navigation.navigation2.screensexamples.model.SettingModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id: String, val showID: Boolean)

// Pasando objetos completos como parámetro
@Serializable
data class Settings(val settingsModel: SettingModel)