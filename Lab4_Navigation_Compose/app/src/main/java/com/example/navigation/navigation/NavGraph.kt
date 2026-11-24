package com.example.navigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigation.screens.UserDetailScreen
import com.example.navigation.screens.UserEditScreen
import com.example.navigation.screens.UserListScreen

/** Создаёт граф навигации приложения. */
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "user_list") {
        composable("user_list") { UserListScreen(navController) }
        composable(
            route = "user_detail/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.IntType })
        ) { entry ->
            val id = entry.arguments?.getInt("userId") ?: -1
            UserDetailScreen(id, navController)
        }
        composable(
            route = "user_edit/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.IntType })
        ) { entry ->
            val id = entry.arguments?.getInt("userId") ?: -1
            UserEditScreen(id, navController)
        }
    }
}
