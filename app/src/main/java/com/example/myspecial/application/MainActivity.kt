package com.example.myspecial.application

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myspecial.application.data.ProductRepository
import com.example.myspecial.application.ui.compose.TwoTreesAppBar
import com.example.myspecial.application.ui.compose.TwoTreesBottomBar
import com.example.myspecial.application.ui.compose.TwoTreesNavHost

import com.example.two.trees.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TwoTreesApp()
        }
    }
}

@Composable
fun TwoTreesApp() {
    AppTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        val context = LocalContext.current

        val viewModel: MainViewModel = viewModel(
            factory = MainViewModelFactory(ProductRepository(context = context ))
        )

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {

                TwoTreesAppBar(
                    appName = R.string.app_name,
                    shareWithFriends = {
                        shareWithFriends(context)
                    }
                )
            },
            bottomBar = {
                TwoTreesBottomBar(
                    navController = navController,
                    currentDestination = currentDestination,
                    viewModel = viewModel
                )
            }
        ) { innerPadding ->
            TwoTreesNavHost(
                navController = navController,
                viewModel = viewModel,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

fun shareWithFriends(context: Context) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(
            Intent.EXTRA_TEXT,
            "Check out my favorite olive oil place!"
        )
    }

    context.startActivity(intent)
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_5,
)
@Composable
fun TwoTreesAppPreview() {
    AppTheme {
        TwoTreesApp()
    }
}