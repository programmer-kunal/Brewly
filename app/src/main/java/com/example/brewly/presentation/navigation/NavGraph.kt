package com.example.brewly.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.brewly.presentation.screens.cartscreen.CartScreen
import com.example.brewly.presentation.screens.detailsscreen.DetailsScreen
import com.example.brewly.presentation.screens.favouritesscreen.FavouritesScreen
import com.example.brewly.presentation.screens.homescreen.HomeScreen
import com.example.brewly.presentation.screens.profilescreen.ProfileScreen
import com.example.mycoffeeapp.screens.welcomescreen.WelcomeScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.WelcomeScreen
    ) {

        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController)
        }

        composable<Routes.HomeScreen> {
            HomeScreen(navController)
        }
        composable<Routes.DetailsScreen> { backStackEntry ->
            val args = backStackEntry.toRoute<Routes.DetailsScreen>()
            DetailsScreen(productId=args.productId,navController)
        }
        composable<Routes.CartScreen> {
            CartScreen(navController)
        }
        composable<Routes.FavouritesScreen> {
            FavouritesScreen(navController)
        }
        composable<Routes.ProfileScreen> {
            ProfileScreen(navController)
        }



    }
}