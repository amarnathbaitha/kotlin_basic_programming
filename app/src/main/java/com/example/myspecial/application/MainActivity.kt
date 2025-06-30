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
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myspecial.application.ui.compose.TwoTreesAppBar
import com.example.myspecial.application.ui.compose.TwoTreesBottomBar
import com.example.myspecial.application.ui.compose.TwoTreesNavHost
import com.example.two.trees.ui.theme.AppTheme
import androidx.compose.runtime.getValue


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
        val currentBackStack = navBackStackEntry?.destination
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                val context = LocalContext.current
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
                    currentDestination = currentBackStack
                )
            }
        ) { innerPadding ->
            TwoTreesNavHost(
                navController = navController,
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
