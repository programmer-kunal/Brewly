package com.example.brewly.presentation.screens.homescreen

import androidx.compose.foundation.Image
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.brewly.presentation.ui_components.MyBottomNavBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.brewly.R
import com.example.brewly.domain.model.Product


@Composable
fun HomeScreen(navController: NavController) {
    val location = "Planet Mars, Milkyway "
    Scaffold(
        bottomBar = { MyBottomNavBar(navController,"Home") }
    ) { innerPadding ->
            // Top Gradient Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f / 3f)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF303030),
                                Color(0xFF1F1F1F),
                                Color(0xFF121212)
                            )
                        )
                    )
            )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .padding(innerPadding)
                ) {



                    // Displaying Products
                    val products = listOf(
                        Product(1, "Espresso", "Strong and rich", 3.80, R.drawable.coffee_2),
                        Product(2, "Latte", "Smooth and creamy", 4.50, R.drawable.coffee_3),
                        Product(3, "Cappuccino", "With chocolate", 4.20, R.drawable.coffee_1),
                        Product(4, "Mocha", "With cocoa flavor", 4.70, R.drawable.coffee_4),
                        Product(5, "Macchiato", "Bold and milky", 4.60, R.drawable.coffee_5),
                        Product(6, "Flat White", "Velvety smooth", 4.40, R.drawable.coffee_6),
                        Product(7, "Iced Mocha", "Refreshing and rich", 4.70, R.drawable.coffee_4)
                    )

                 ProductsGrid(products=products,navController=navController){
                     Text(
                         text = "Location",
                         color = Color.Gray,
                         fontSize = 14.sp
                     )

                     Spacer(modifier = Modifier.height(4.dp))

                     Row(
                         verticalAlignment = Alignment.CenterVertically
                     ) {

                         Text(
                             text = location,
                             color = Color.White,
                             fontWeight = FontWeight.SemiBold,
                             fontSize = 16.sp
                         )

                         Icon(
                             imageVector = Icons.Default.KeyboardArrowDown,
                             contentDescription = "Change Location",
                             tint = Color.White
                         )
                     }

                     Spacer(modifier = Modifier.height(30.dp))
                     MySearchBar()
                     Spacer(modifier = Modifier.height(40.dp))

                     Image(
                         painter = painterResource(id = R.drawable.banner_1),
                         contentDescription = "Home Banner",
                     )
                     Spacer(modifier = Modifier.height(16.dp))

                     HomeScreenCategories()
                 }
                }
    }
}







