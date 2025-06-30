package com.example.myspecial.application.ui.compose

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.example.myspecial.application.MainViewModel

@Composable
fun TwoTreesBottomBar(
    navController: NavHostController,
    currentDestination: NavDestination?,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        val quantity by viewModel.quantity.collectAsStateWithLifecycle()

        screens.forEach { screen ->
            val label = stringResource(id = screen.labelResourceId)
            NavigationBarItem(
                icon = {
                    BadgedBox(
                        badge = {
                            if (quantity != 0 && screen.route == Screen.Shop.route) {
                                Badge { Text(quantity.toString()) }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = screen.icon,
                            contentDescription = label
                        )
                    }
                },
                label = {
                    Text(label)
                },
                selected = currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}