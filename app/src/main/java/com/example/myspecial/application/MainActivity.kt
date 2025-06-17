package com.example.myspecial.application

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myspecial.application.lession.SnackBar
import com.example.myspecial.application.ui.theme.AppTheme
import com.example.myspecial.application.ui.theme.MySpecialApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MySpecialApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Amar",
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.height(400.dp).width(220.dp)
    ) {
        Text(
            text = "Hello $name!",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = "Having fun",

            )
        val context = LocalContext.current
        Button(onClick = {

            Toast.makeText(context,"Toast checking",Toast.LENGTH_SHORT).show()
        }) {
            Text("Click Me")
        }
    }

}

@Preview(
    showBackground = true,
    device = "spec:width=720dp,height=1080dp,dpi=420"
)
@Preview(
    showBackground = true,
    device = Devices.NEXUS_5,
    name = "Nexus 5"
)
@Composable
fun GreetingPreview() {
    AppTheme  {
        Greeting("Android")
    }
}