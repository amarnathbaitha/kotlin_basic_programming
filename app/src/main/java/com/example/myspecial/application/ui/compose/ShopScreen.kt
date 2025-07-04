package com.example.myspecial.application.ui.compose


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.myspecial.application.R
import com.example.myspecial.application.data.Products
import com.example.two.trees.ui.theme.AppTheme

@Composable
fun ShopScreen(
    products: List<Products>,
    onProductClick: (product: Products) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        modifier = modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ShopLabel()
        }
        item {
            FreeShipping()
        }
        items(products) {
            ProductItem(
                product = it,
                onProductClick
            )
        }
    }
}

@Composable
private fun ShopLabel(modifier: Modifier = Modifier) {
    Text(
        stringResource(R.string.shop_label).uppercase(),
        modifier = modifier
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

@Composable
fun ProductItem(
    product: Products,
    onProductClick: (product: Products) -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier,
        onClick = { onProductClick(product) }
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.image)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.logo),
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp) // Set a consistent height
                    .clip(RoundedCornerShape(8.dp)) // Optional: rounded corners
                    .background(Color.Transparent),  // Optional: fallback bg
                contentScale = ContentScale.Fit // Or Fit, FillBounds, etc.
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
                product.category,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )
            Text(
                "Rs.${product.price}",
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
                image = "fabellas",
                description = "varius",
                id = 7963,
                price = 14.15,
                category = "sdf"
            ),
            onProductClick = {}
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
            category = "sdf"
        ),
        Products(
            title = "Carla",
            image = "sdf",
            description = "varius",
            id = 7963,
            price = 14.15,
            category = "sdf"
        )
    )
    AppTheme {
        ShopScreen(
            products = products,
            onProductClick = {}
        )
    }
}