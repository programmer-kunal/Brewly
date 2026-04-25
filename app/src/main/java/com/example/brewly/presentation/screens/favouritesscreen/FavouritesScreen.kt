package com.example.brewly.presentation.screens.favouritesscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.brewly.R
import com.example.brewly.domain.model.Product
import com.example.brewly.presentation.ui_components.MyBottomNavBar
import kotlin.collections.listOf

@Composable
fun FavouritesScreen(navController: NavController) {
    var favouritesItems by remember {
        mutableStateOf(
        listOf(
            Product(1, "Espresso", "Strong and rich", 3.80, R.drawable.coffee_2),
        Product(2, "Latte", "Smooth and creamy", 4.50, R.drawable.coffee_3),
        Product(3, "Cappuccino", "With chocolate", 4.20, R.drawable.coffee_1),
        )
    )
    }
    Scaffold(
        topBar = { FavoritesScreenTopAppBar() },
        bottomBar = { MyBottomNavBar(navController = navController,"Favourites") }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ){
            item {
                favouritesItems.forEach {product->
                    FavouriteItemCard(
                        product,
                        onRemove= { favouritesItems=favouritesItems-product}
                    )
                }
            }
        }
    }
}