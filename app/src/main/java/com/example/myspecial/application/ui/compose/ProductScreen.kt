package com.example.myspecial.application.ui.compose


import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.myspecial.application.R
import com.example.myspecial.application.data.Products
import com.example.two.trees.ui.theme.AppTheme

@Composable
fun ProductScreen(
    product: Products,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState()
) {
    Column(
        modifier = modifier.fillMaxSize()
            .verticalScroll(scrollState)
            .padding(vertical = 16.dp),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(product.image)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.logo),
            contentDescription = product.title,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            product.title.uppercase(),
            modifier = Modifier.fillMaxSize()
                .padding(16.dp),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            product.description,
            modifier = Modifier.fillMaxSize()
                .padding(16.dp),
            fontSize = 18f.sp,
            lineHeight = 28.sp
        )
        Text(
            text = product.category,
            modifier = Modifier.padding(horizontal = 16.dp),
            style = MaterialTheme.typography.headlineSmall,
        )
        Text(
            "Rs.${product.price}",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {
    AppTheme {
        ProductScreen(
            Products(
                title = "Carla Montoya",
                image = "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                description = "varius",
                id = 7963,
                price = 14.15,
                category = "This is category"
            )
        )
    }
}