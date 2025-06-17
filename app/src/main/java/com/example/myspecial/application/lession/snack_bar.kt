package com.example.myspecial.application.lession

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.myspecial.application.ui.theme.AppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SnackBar(
    modifier: Modifier = Modifier,
    scope: CoroutineScope,
    snackBarHostState: SnackbarHostState
){
    var email by remember { mutableStateOf("") }
     var pasword by remember { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        TextField(
            value = email,
            onValueChange = { email = it
            },
            label = {Text(text = "email")},
            placeholder = { Text(text = "Enter your email address") }
        )

        TextField(
            value = pasword,
            onValueChange = {pasword = it},
            label = {Text(text = "password")},
            placeholder = {Text(text = "Enter your password")}
            )

        val context = LocalContext.current
        val controller = LocalSoftwareKeyboardController.current
        Button(
            onClick = {
                scope.launch {
                    controller?.hide()
                   val result: SnackbarResult = snackBarHostState.showSnackbar(
                       message = "I'm a snackBar",
                       duration = SnackbarDuration.Indefinite,
                       actionLabel = "View SnackBar"
                   )
                    if(result == SnackbarResult.ActionPerformed){
                        Toast.makeText(context,"Toast Message",Toast.LENGTH_SHORT).show()
                    }
                }

            },

            ) {
            Text(text = "Click me")
        }
    }
}
@Preview(
    showBackground = true,
    device = Devices.NEXUS_5,
    name = "Nexus 5"
)
@Composable
fun SnackBarPreview(){
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember{SnackbarHostState()}
    AppTheme {
        Scaffold (
            modifier = Modifier.fillMaxSize(),
            snackbarHost ={ SnackbarHost(hostState = snackBarHostState)}
        )
        {
            padding->
            SnackBar(
                modifier = Modifier.padding(padding),
                scope = scope,
                snackBarHostState = snackBarHostState
                )
        }

    }
}


