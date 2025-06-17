package com.example.myspecial.application.lession

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

@Composable
fun StringPlaceholderComposable(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val message = stringResource(R.string.message_text, email, password)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "Enter your email address")
            }
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(text = "Password")
            },
            placeholder = {
                Text(text = "Enter your password")
            }
        )
        val context = LocalContext.current
        val controller = LocalSoftwareKeyboardController.current
        Button(
            onClick = {
                controller?.hide()
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                Log.i("StringPlaceholderComposable", message)
            }
        ) {
            Text (
                text = "Submit"
            )
        }
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4_XL,
    name = "Pixel 4 XL"
)
@Composable
fun StringPlaceholderComposablePreview() {
    AppTheme {
        StringPlaceholderComposable()
    }
}