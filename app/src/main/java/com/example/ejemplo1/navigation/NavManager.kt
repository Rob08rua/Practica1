package com.example.ejemplo1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ejemplo1.view.DetailView
import com.example.ejemplo1.view.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home"){
            HomeView(navController)
        }
        composable("Detail/{id}", arguments = listOf(
            navArgument("id"){type = NavType.IntType},
        )){
            val id : Int = it.arguments?.getInt("id")?:0
            DetailView(navController, id)
        }
    }
}