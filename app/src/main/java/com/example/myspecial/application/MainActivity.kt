package com.example.myspecial.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
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
    MySpecialApplicationTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
        )
        { innerPadding ->
            val imageId:MutableState<Int> = remember { mutableIntStateOf(R.drawable.baby) }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(painter = painterResource(imageId.value), contentDescription = "")
                Button(onClick = {
                   imageId.value =  if(imageId.value == R.drawable.baby)R.drawable.logo else R.drawable.mommy
                }) {
                    Text(text = "Swap Image")
                }
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