package com.example.myspecial.application.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun CustomNavHostController(modifier: Modifier = Modifier,navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        modifier = modifier,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomePage(
               nextDescriptionScreen = {
                    navHostController.navigate(route = "des")
               }
            )
        }
        composable(route = "des") {
            Description()
        }
    }
}