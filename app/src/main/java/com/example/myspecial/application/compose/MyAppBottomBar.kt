package com.example.myspecial.application.compose

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MyBottomBar(modifier: Modifier = Modifier) {

    NavigationBar {
        NavigationBarItem(onClick = {}, selected = false, label = {
            Text(text = "Home")

        }, icon = {
            Icon(imageVector = Icons.Filled.Home, contentDescription = "home")
        })

        NavigationBarItem(onClick = {}, selected = false, label = {
            Text(text = "Des")

        }, icon = {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Description")
        })
        NavigationBarItem(onClick = {}, selected = false, label = {
            Text(text = "Cart")

        }, icon = {
            Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "ShoppingCart")
        })
    }

}