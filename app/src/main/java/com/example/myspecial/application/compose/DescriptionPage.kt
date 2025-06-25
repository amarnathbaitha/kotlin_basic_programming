package com.example.myspecial.application.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Description(modifier: Modifier = Modifier) {

    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Text(text = "Description")
    }
}