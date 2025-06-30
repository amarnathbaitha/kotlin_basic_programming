package com.example.myspecial.application.ui.compose

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController

@Composable
fun TwoTreesBottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    currentDestination: NavDestination?
) {
    NavigationBar(modifier = modifier) {
        screens.forEach { screen ->
            val label = stringResource(id = screen.labelResourceId)
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = label
                    )
                },
                label = {
                    Text(label)
                },
                //To select the bottom navigation to be highlighted
                selected = currentDestination?.hierarchy?.any{
                   it.route == screen.route
                } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        //This will handle the back navigation
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
