package com.example.myspecial.application.lession

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myspecial.application.R
import com.example.myspecial.application.ui.theme.AppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Challenges(
    modifier: Modifier = Modifier,
    scope: CoroutineScope,
    snackBarHostState: SnackbarHostState
){
    var firstName by remember { mutableStateOf("") }
     var favouriteColor by remember { mutableStateOf("") }
    var favouriteSnack by remember { mutableStateOf("") }
    val message = stringResource(R.string.form_data,firstName,favouriteColor,favouriteSnack)
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
       // verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        TextField(
            value = firstName,
            onValueChange = { firstName = it
            },
            label = {Text(text = "firstName")},
            placeholder = { Text(text = "Enter your FirstName") }
        )
       Spacer(modifier = Modifier.padding(16.dp))
        TextField(
            value = favouriteColor,
            onValueChange = {favouriteColor = it},
            label = {Text(text = "color")},
            placeholder = {Text(text = "Favourite color")}
            )
        Spacer(modifier = Modifier.padding(16.dp))
        TextField(
            value = favouriteSnack,
            onValueChange = {favouriteSnack = it},
            label = {Text(text = "snack")},
            placeholder = { Text(text = "Favourite snacks") }

        )
        Spacer(modifier = Modifier.padding(16.dp))
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
                        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
                    }
                }

            },

            ) {
            Text(text = "Submit")
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
            Challenges(
                modifier = Modifier.padding(padding),
                scope = scope,
                snackBarHostState = snackBarHostState
                )
        }

    }
}


