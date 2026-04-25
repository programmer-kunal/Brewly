package com.example.brewly.presentation.ui_components
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.brewly.R
import com.example.brewly.presentation.navigation.Routes
import com.example.brewly.presentation.theme.LightBrown


@Composable
fun MyBottomNavBar(navController: NavController,routes: String) {
    // Bottom Nav Items
    val navItems = listOf(
        NavItem("Home", R.drawable.regular_outline_home, Routes.HomeScreen),
        NavItem("Cart", R.drawable.regular_outline_bag,Routes.CartScreen),
        NavItem("Favourites", R.drawable.regular_outline_heart,Routes.FavouritesScreen),
        NavItem("Profile", R.drawable.outline_account_circle_24,Routes.ProfileScreen)
    )
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.height(100.dp)
    ) {

        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) },
                modifier = Modifier.size(30.dp),
                //Handling Bottom Bar Navigation
                onClick={
                    navController.navigate(item.routes){
                        popUpTo(navController.graph.startDestinationId){
                            saveState=true
                        }
                        launchSingleTop=true
                        restoreState=true
                    }
                },
                selected=item.title==routes,
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = LightBrown,
                    selectedTextColor = LightBrown,
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.DarkGray,
                    indicatorColor = LightBrown.copy(alpha = 0.03f)
                )
            )
        }
    }
}


// Data Class
data class NavItem(
    val title: String,
    val icon: Int,
    val routes: Routes
)