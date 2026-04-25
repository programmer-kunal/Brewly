package com.example.brewly.presentation.screens.detailsscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brewly.presentation.theme.IvoryWhite
import com.example.brewly.presentation.theme.LightBrown
import com.example.brewly.presentation.ui_components.AppMessageDialog

@Composable
fun DetailsScreenBottomBar() {
    var showCartDialog by remember { mutableStateOf(false) }



    BottomAppBar(
        containerColor = Color.Transparent
    ) {

        Row(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {

            Column {

                Text(
                    text = "Price",
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "$4.53",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(modifier = Modifier.width(40.dp))

            Button(
                onClick = { showCartDialog = true },
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBrown,
                    contentColor = IvoryWhite
                )
            ) {
                Text(
                    text = "Add to cart",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            AppMessageDialog(
                show = showCartDialog,
                title = "Added To Cart",
                message = "Item added to cart",
                onDismiss = {showCartDialog = false}
            )
        }
    }
}