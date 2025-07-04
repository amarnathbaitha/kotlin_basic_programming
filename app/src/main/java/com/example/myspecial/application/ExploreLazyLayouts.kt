package com.example.myspecial.application



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.two.trees.ui.theme.AppTheme

// LazyColumn example
// TODO: LazyListScope DSL
// TODO: item and items

@Composable
fun MyLazyColumn(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
//        item {
//            MyItem()
//        }
//        items(count = 5) {
//            MyItem()
//        }
        items(exampleItems) {
            MyItem()
        }
    }
}

@Preview(showBackground = true, heightDp = 720)
@Composable
private fun MyLazyColumnPreview() {
    AppTheme {
        MyLazyColumn()
    }
}

// LazyRow example
// TODO: Content spacing and padding

@Composable
fun MyLazyRow(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 16.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        items(count = 5) {
            MyItem()
        }
    }
}

@Preview(showBackground = true, widthDp = 600, heightDp = 400)
@Composable
private fun MyLazyRowPreview() {
    AppTheme {
        MyLazyRow()
    }
}

// LazyGrid example
// TODO: LazyGridScope
// TODO: rows with GridCells

@Composable
fun MyLazyGrid(modifier: Modifier = Modifier) {
    LazyHorizontalGrid(
        modifier = modifier.fillMaxSize(),
        //This grid will take dynamically space based on the row size
        rows = GridCells.Adaptive(minSize = 128.dp),
    ) {
        items(count = 8) {
            MyItem()
        }
    }
}

@Preview(showBackground = true, widthDp = 600, heightDp = 400)
@Composable
private fun MyLazyGridPreview() {
    AppTheme {
        MyLazyGrid()
    }
}

// Item example
data class ExampleItemObject(
    val id: Int
)

val exampleItems = (1..5).map { id ->
    ExampleItemObject(id)
}

@Composable
fun MyItem(modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier.padding(16.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .size(80.dp),
                imageVector = ImageVector.vectorResource(R.drawable.olive_branch_vector),
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 200, heightDp = 200)
@Composable
private fun MyItemPreview() {
    AppTheme {
        MyItem()
    }
}