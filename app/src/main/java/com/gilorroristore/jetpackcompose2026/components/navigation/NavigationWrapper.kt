package com.gilorroristore.jetpackcompose2026.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.gilorroristore.jetpackcompose2026.components.navigation.screensexamples.DetailScreen
import com.gilorroristore.jetpackcompose2026.components.navigation.screensexamples.HomeScreen
import com.gilorroristore.jetpackcompose2026.components.navigation.screensexamples.LoginScreen

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

        composable<Detail> {navBackStackEntry ->
            val detail = navBackStackEntry.toRoute<Detail>()

            DetailScreen(detail.id, detail.showID) {
                navController.navigate(Login)
            }
        }
    }
}