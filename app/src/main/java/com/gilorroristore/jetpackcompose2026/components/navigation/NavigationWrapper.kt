package com.gilorroristore.jetpackcompose2026.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.gilorroristore.jetpackcompose2026.components.navigation.screensexamples.DetailScreen
import com.gilorroristore.jetpackcompose2026.components.navigation.screensexamples.HomeScreen
import com.gilorroristore.jetpackcompose2026.components.navigation.screensexamples.LoginScreen
import com.gilorroristore.jetpackcompose2026.components.navigation.screensexamples.SettingsScreen
import com.gilorroristore.jetpackcompose2026.components.navigation.screensexamples.model.SettingModel
import com.gilorroristore.jetpackcompose2026.components.navigation.types.createNavType
import com.gilorroristore.jetpackcompose2026.components.navigation.types.settingsModelType
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen() { navController.navigate(Home) }
        }

        composable<Home> {
            HomeScreen(
                navBack = { navController.popBackStack() },
                navToDetail = { id, showID ->
                    navController.navigate(Detail(id = id, showID = showID))
                })
        }

        composable<Detail> { navBackStackEntry ->
            val detail = navBackStackEntry.toRoute<Detail>()

            DetailScreen(
                id = detail.id,
                showID = detail.showID,
                navBack = { navController.navigate(Login) },
                navToSettings = {
                    navController.navigate(Settings(it))
                })
        }

        composable<Settings>(typeMap = mapOf(typeOf<SettingModel>() to createNavType<SettingModel>())) { navBackStackEntry ->
            val setting = navBackStackEntry.toRoute<Settings>()

            SettingsScreen(setting.settingsModel) { }
        }
    }
}