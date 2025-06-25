package com.example.myspecial.application

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myspecial.application.compose.Description
import com.example.myspecial.application.compose.HomePage

@Composable
fun CustomNavHostController(modifier: Modifier = Modifier,navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        modifier = modifier,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomePage()
        }
        composable(route = "des") {
            Description()
        }
    }
}