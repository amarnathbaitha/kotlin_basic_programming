package com.example.myspecial.application.compose

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myspecial.application.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarUI(
    sharedButton:()-> Unit
) {
    var context = LocalContext.current
    TopAppBar(
        title = { Text(text = "Hi") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.brand,),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .size(20.dp)
                    .background(
                        Color.Red
                    ).clickable {
                        Toast.makeText(context,"Hello",Toast.LENGTH_SHORT).show()
                    }
            )
        },
        actions = {
            IconButton(onClick = sharedButton) {
                Icon(imageVector = Icons.Filled.Share, contentDescription = "Share button", tint = Color.White)

            }

        }

        )
}


