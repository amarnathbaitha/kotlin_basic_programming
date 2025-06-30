package com.example.myspecial.application.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.myspecial.application.MainViewModel
import com.example.myspecial.application.R

import com.example.two.trees.ui.theme.AppTheme
import com.example.two.trees.ui.theme.accent

@Composable
fun ShopScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val quantity by viewModel.quantity.collectAsStateWithLifecycle()
    val totalAmount by viewModel.totalAmount.collectAsStateWithLifecycle()

    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ShopLabel()
        }
        item {
            FreeShipping()
        }
        item {
            QuantityButtons(
                increaseQuantity = { viewModel.increaseQuantity() },
                decreaseQuantity = { viewModel.decreaseQuantity() }
            )
        }
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                text = "Total cans: $quantity",
                style = MaterialTheme.typography.titleLarge
            )
        }
        item {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                text = "Total amount: $$totalAmount.00",
                style = MaterialTheme.typography.titleLarge
            )
        }
        item {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { viewModel.checkout() }
            ) {
                Text(
                    text = "Checkout",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

@Composable
private fun ShopLabel() {
    Text(
        stringResource(R.string.shop_label).uppercase(),
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun QuantityButtons(
    increaseQuantity: () -> Unit,
    decreaseQuantity: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(24.dp),
            imageVector = ImageVector.vectorResource(
                R.drawable.olive_branch_vector
            ),
            contentDescription = null
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            FilledIconButton(
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = accent
                ),
                onClick = increaseQuantity
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowUp,
                    tint = Color.White,
                    contentDescription = "increase quantity"
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            FilledIconButton(
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = accent
                ),
                onClick = decreaseQuantity
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    tint = Color.White,
                    contentDescription = "decrease quantity"
                )
            }
        }
    }
}

@Composable
fun FreeShipping(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiary)
    ) {
        Text(
            stringResource(id = R.string.free_shipping_label).uppercase(),
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 16.dp, horizontal = 4.dp),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onTertiary,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShopScreenPreview() {
    AppTheme {
        ShopScreen(viewModel = MainViewModel())
    }
}