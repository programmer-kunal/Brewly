package com.example.brewly.presentation.screens.homescreen


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.brewly.domain.model.Product

@Composable
fun ProductsGrid(
    products: List<Product>,
    navController: NavController,
    topContent: @Composable () -> Unit
    ) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        item{
            topContent()
        }


        items(products.chunked(2)) { rowItems ->

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                // First item
                ProductCard(
                    product = rowItems[0],
                    modifier = Modifier.weight(1f),
                    navController = navController
                )

                // Second item (if exists)
                if (rowItems.size == 2) {
                    ProductCard(
                        product = rowItems[1],
                        modifier = Modifier.weight(1f),
                        navController = navController

                    )
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}