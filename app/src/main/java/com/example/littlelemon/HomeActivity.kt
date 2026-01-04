package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.network.MenuItem
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun HomeActivity(items: List<MenuItem>) {
    var searchPhrase by rememberSaveable { mutableStateOf("") }
    var categoryFilter by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Topbar(painterResource(R.drawable.profile))
        }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Column {
                Text(
                    text = "Little Lemon",
                    color = MaterialTheme.colorScheme.inversePrimary,
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = "Chicago",
                    color = MaterialTheme.colorScheme.background,
                    style = MaterialTheme.typography.displaySmall
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            Row(modifier = Modifier.height(IntrinsicSize.Min)) {
                Text(
                    text = "We are a family owned Mediterranean restaurant, focused on traditional recipes served with a modern twist.",
                    color = MaterialTheme.colorScheme.background,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(end = 4.dp)
                )
                Image(
                    painter = painterResource(R.drawable.hero_image),
                    contentDescription = "hero image",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(12.dp))
                        .wrapContentHeight()
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    value = searchPhrase,
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                    },
                    singleLine = true,
                    placeholder = { Text("Enter Search Phrase") },
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {
                        searchPhrase = it
                    }
                )
            }
        }
        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp)) {
            Text(
                text = "ORDER FOR DELIVERY!",
                style = MaterialTheme.typography.headlineLarge,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items.map {
                    it.category
                }.distinct().map {
                    Button(
                        onClick = {
                            categoryFilter = if (categoryFilter == it) "" else it
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = MaterialTheme.colorScheme.primary,
                            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        ),
                        enabled = categoryFilter != it
                    ) {
                        Text(it.capitalize(), fontWeight = FontWeight.Bold)
                    }
                }
            }
            Column {
                Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
                Spacer(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.tertiaryContainer).height(1.dp))
                Text("hello world")
            }

        }
    }
}

@Preview
@Composable
fun HomeActivityPreview() {
    LittleLemonTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.padding(it)) {
                HomeActivity(
                    listOf(
                        MenuItem(
                            id = 1,
                            title = "Greek Salad",
                            description = "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.",
                            price = "10",
                            image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/greekSalad.jpg?raw=true",
                            category = "starters"
                        ),
                        MenuItem(
                            id = 2,
                            title = "Lemon Desert",
                            description = "Traditional homemade Italian Lemon Ricotta Cake.",
                            price = "10",
                            image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/lemonDessert%202.jpg?raw=true",
                            category = "desserts"
                        ),
                        MenuItem(
                            id = 3,
                            title = "Grilled Fish",
                            description = "Our Bruschetta is made from grilled bread that has been smeared with garlic and seasoned with salt and olive oil.",
                            price = "10",
                            image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/grilledFish.jpg?raw=true",
                            category = "mains"
                        ),
                        MenuItem(
                            id = 4,
                            title = "Pasta",
                            description = "Penne with fried aubergines, cherry tomatoes, tomato sauce, fresh chilli, garlic, basil & salted ricotta cheese.",
                            price = "10",
                            image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/pasta.jpg?raw=true",
                            category = "mains"
                        ),
                        MenuItem(
                            id = 5,
                            title = "Bruschetta",
                            description = "Oven-baked bruschetta stuffed with tomatos and herbs.",
                            price = "10",
                            image = "https://github.com/Meta-Mobile-Developer-PC/Working-With-Data-API/blob/main/images/bruschetta.jpg?raw=true",
                            category = "starters"
                        )
                    )
                )
            }
        }
    }
}
