package com.example.brewly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.brewly.presentation.navigation.NavGraph
import com.example.brewly.presentation.screens.cartscreen.CartScreen
import com.example.brewly.presentation.screens.detailsscreen.DetailsScreen
import com.example.brewly.presentation.screens.favouritesscreen.FavouritesScreen
import com.example.brewly.presentation.screens.homescreen.HomeScreen
import com.example.brewly.presentation.theme.BrewlyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BrewlyTheme {
                NavGraph()
                }
            }
        }
    }


