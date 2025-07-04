package com.example.myspecial.application.ui.compose


import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myspecial.application.MainViewModel
import com.example.myspecial.application.data.Products

const val TAG = "TwoTreesNavHost"
@Composable
fun TwoTreesNavHost(
    navController: NavHostController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val products by viewModel.product.collectAsStateWithLifecycle()
    val selectedProduct by viewModel.selectedProduct.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                takeTourClick = {
                    navController.navigate(Screen.Tours.route)
                }
            )
        }
        composable(route = Screen.Tours.route) {
            ToursScreen()
        }
        composable(route = Screen.Shop.route) {
            ShopScreen(
                products = products,
                onProductClick = { product: Products ->
                    Log.i(TAG, "The selected product: $product")
                    viewModel.selectedProduct(product)
                    navController.navigate(Screen.Product.route)
                },
            )
        }
        composable(route = Screen.Product.route) {
            selectedProduct?.let {
            ProductScreen(product = it)
            }
        }
        }

}