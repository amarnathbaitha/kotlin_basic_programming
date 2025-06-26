package com.example.myspecial.application.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.myspecial.application.R

@Composable
fun HomePage(
    nextDescriptionScreen: ()->Unit,
    modifier: Modifier = Modifier,
               scrollState: ScrollState = rememberScrollState()) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Image(
            painter = painterResource(id = R.drawable.olive_ranch_bg),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier.aspectRatio(16f / 9f),

        )
        Text(
            text = "HomePage",
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = {
                  nextDescriptionScreen()
        }) {
            Text(text = "Next Screen", color = Color.Red)
        }
    }


}


