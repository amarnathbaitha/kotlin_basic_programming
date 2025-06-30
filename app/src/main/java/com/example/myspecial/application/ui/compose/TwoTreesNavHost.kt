package com.example.myspecial.application.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.two.trees.ui.compose.ShopScreen

@Composable
fun TwoTreesNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable(route = "home") {
            HomeScreen(
                takeTourClick = {
                    navController.navigate("tours")
                }
            )
        }
        composable(route = "tours") {
            ToursScreen()
        }
        composable(route = "shop") {
            ShopScreen()
        }
    }
}
