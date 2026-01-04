package com.example.littlelemon

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.network.MenuItem
import com.example.littlelemon.ui.theme.LittleLemonTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MenuCard(item: MenuItem) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(item.title, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(5.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.weight(0.7f)) {
                Row {
                    Text(item.description)
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row {
                    Text(text = "$${item.price}", fontWeight = FontWeight.Bold)
                }
            }
            Row(Modifier.weight(0.3f)) {
                GlideImage(
                    model = item.image,
                    contentDescription = item.title,
                    contentScale = ContentScale.FillWidth,
                )
            }
        }
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.tertiaryContainer)
                .height(1.dp)
        )
    }
}

@Preview
@Composable
fun MenuCardPreview() {
    LittleLemonTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.padding(it)) {
                MenuCard(
                    MenuItem(
                        id = 1,
                        title = "Greek Salad",
                        description = "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.",
                        price = "10",
                        image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/greekSalad.jpg?raw=true",
                        category = "starters"
                    )
                )
            }
        }
    }

}

