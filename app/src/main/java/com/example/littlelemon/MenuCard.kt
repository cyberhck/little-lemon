package com.example.littlelemon

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.littlelemon.network.MenuItem
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun MenuCard(item: MenuItem) {

}

@Preview
@Composable
fun MenuCardPreview() {
    LittleLemonTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.padding(it)) {
                MenuItem(
                    id = 1,
                    title = "Greek Salad",
                    description = "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.",
                    price = "10",
                    image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/greekSalad.jpg?raw=true",
                    category = "starters"
                )
            }
        }
    }

}

