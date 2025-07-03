package com.example.myspecial.application.ui.compose


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myspecial.application.R
import com.example.myspecial.application.data.Products
import com.example.two.trees.ui.theme.AppTheme

@Composable
fun ShopScreen(
    products: List<Products>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ShopLabel()
        }
        item {
            FreeShipping()
        }
        item(
            span = { GridItemSpan(currentLineSpan = 2) }
        ) {
            Text(
                text = products.joinToString(separator = "\n"),
            )
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
    val products = listOf(
        Products(
            title = "Carla Montoya",
            image = "fabellas",
            description = "varius",
            id = 7963,
            price = 14.15,
            category ="This is category"
        ),
        Products(
            title = "Julia McCormick",
            image = "tristique",
            description = "alterum",
            id = 7143,
            price = 18.19,
            category = "This is another category"
        )
    )
    AppTheme {
        ShopScreen(products = products)
    }
}