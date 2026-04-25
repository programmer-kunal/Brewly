package com.example.brewly.presentation.screens.detailsscreen

import androidx.compose.foundation.clickable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.navigation.NavController
import com.example.brewly.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreenTopAppBar(navController: NavController) {

    TopAppBar(

        title = {
            Text(
                text = "Details",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        },

        actions = {
            Icon(
                painter = painterResource(id = R.drawable.regular_outline_heart),
                contentDescription = "Add to Favourites",
                modifier = Modifier.padding(end = 12.dp)
            )
        },

        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.regular_outline_arrow_left),
                contentDescription = "Back Button",
                modifier = Modifier.padding(start = 12.dp).clickable { navController.navigateUp() }
            )
        }
    )
}