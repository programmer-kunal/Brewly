package com.example.brewly.presentation.screens.detailsscreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.brewly.R
import com.example.brewly.domain.model.Product

@Composable
fun DetailsScreen (productId: Int,navController: NavController){
    val products = listOf(
        Product(1, "Espresso", "Strong and rich", 3.80, R.drawable.coffee_2),
        Product(2, "Latte", "Smooth and creamy", 4.50, R.drawable.coffee_3),
        Product(3, "Cappuccino", "With chocolate", 4.20, R.drawable.coffee_1),
        Product(4, "Mocha", "With cocoa flavor", 4.70, R.drawable.coffee_4),
        Product(5, "Macchiato", "Bold and milky", 4.60, R.drawable.coffee_5),
        Product(6, "Flat White", "Velvety smooth", 4.40, R.drawable.coffee_6),
        Product(7, "Iced Mocha", "Refreshing and rich", 4.70, R.drawable.coffee_4)
    )
    val  selectedProduct=products.find{it.id==productId}
    if (selectedProduct==null){
        Text(text = "Product not found",color= Color.Red)
        return
    }


    Scaffold(
        topBar = { DetailsScreenTopAppBar(navController) },
        bottomBar = { DetailsScreenBottomBar() }
    ) { innerPadding ->

        LazyColumn {
            item {
                ProductDetailsContent(
                    selectedProduct,
                    innerPadding
              )
            }
        }


    }

}