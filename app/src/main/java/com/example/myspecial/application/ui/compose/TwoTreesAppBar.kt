package com.example.myspecial.application.ui.compose

import androidx.annotation.StringRes
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
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TwoTreesAppBar(
    modifier: Modifier = Modifier,
    @StringRes appName: Int,
    shareWithFriends: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(stringResource(appName))
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
        ),
        actions = {
            IconButton(
                onClick = shareWithFriends
            ) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    tint = Color.White,
                    contentDescription = "Share"
                )
            }
        }
    )
}
