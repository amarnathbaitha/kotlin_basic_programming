package com.example.myspecial.application

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.example.myspecial.application.compose.TopAppBarUI
import com.example.myspecial.application.ui.theme.MySpecialApplicationTheme

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
    val context = LocalContext.current
    MySpecialApplicationTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { TopAppBarUI(
                sharedButton = {sharedApp(context)}
            ) }
        )
        { innerPadding ->

            val viewModel = viewModel<MainViewModel>()
            val productImageId by viewModel.productImageId.collectAsStateWithLifecycle()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AsyncImage(
                    contentDescription = null,
                    model = ImageRequest.Builder(LocalContext.current).data(productImageId).build(),
                    modifier = Modifier.clickable {
                        viewModel.generateNewImageId()
                    }
                )
            }
        }
    }
}


@Preview(
    showBackground = true,
    device = Devices.NEXUS_5,
    name = "Nexus 5"
)
@Composable
fun MyComposableNexusPreview() {
    MySpecialApplicationTheme {
        TwoTreesApp()
    }
}

// This is the example of implicit Intent
fun sharedApp(context:Context){
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT,"Checkout my page for further implementation")
    }
    context.startActivity(intent)
}