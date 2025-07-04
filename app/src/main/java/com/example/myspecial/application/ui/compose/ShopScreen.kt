package com.example.myspecial.application.ui.compose


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.example.myspecial.application.R
import com.example.myspecial.application.data.Products
import com.example.two.trees.ui.theme.AppTheme
import java.text.NumberFormat


@Composable
fun ShopScreen(
    products: List<Products>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ShopLabel()
        }
        item {
            FreeShipping()
        }
        itemsIndexed(products) { index, product ->
            ProductItem(product = product)
        }

    }
}

@Composable
fun ProductItem(
    product: Products,
    modifier: Modifier = Modifier
) {
    ElevatedCard(modifier = modifier) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(product.image),
                contentDescription = product.title,
                modifier = Modifier.size(100.dp)
            )
            Text(
                product.title.uppercase(),
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = product.category,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "₹${product.price}",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    AppTheme {
        ProductItem(
            product = Products(
                title = "Carla Montoya",
                image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                description = "varius",
                id = 7963,
                price = 14.15,
                category ="This is category"
            )
        )
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