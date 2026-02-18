package com.gilorroristore.jetpackcompose2026.components.navigation.screensexamples.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class SettingModel(val id: String, val darkMode: Boolean) : Parcelable