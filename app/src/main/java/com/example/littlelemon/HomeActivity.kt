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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.littlelemon.network.Repo
import com.example.littlelemon.ui.theme.LittleLemonTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun HomeActivity(onProfileIconClick: (() -> Unit)?) {
    var menuItems by remember { mutableStateOf<List<MenuItem>>(emptyList()) }
    LaunchedEffect(Unit) {
        menuItems = withContext(Dispatchers.IO) {
            Repo.fetch()
        }
    }
    var searchPhrase by rememberSaveable { mutableStateOf("") }
    var categoryFilter by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Topbar(painterResource(R.drawable.profile), onProfileIconClick = onProfileIconClick)
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
                menuItems.map {
                    it.category
                }.distinct().map {
                    Button(
                        onClick = {
                            categoryFilter = if (categoryFilter == it) "" else it
                        },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = if (categoryFilter != it) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.tertiaryContainer,
                            containerColor = if (categoryFilter != it) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.tertiary,
                        ),
                    ) {
                        Text(it.capitalize(), fontWeight = FontWeight.Bold)
                    }
                }
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.tertiaryContainer)
                .height(1.dp))
            Spacer(modifier = Modifier.fillMaxWidth().height(10.dp))
            LazyColumn {
                items(filter(menuItems, searchPhrase, categoryFilter)) { item ->
                    MenuCard(item)
                }
            }
        }
    }
}

fun filter(items: List<MenuItem>, search: String, category: String): List<MenuItem> {
    return  items.filter {
        if (search == "") {
            return@filter true
        }
        return@filter it.description.contains(search, ignoreCase = true) || it.title.contains(search, ignoreCase = true)
    }.filter{
        if (category == "") {
            return@filter true
        }
        return@filter it.category == category
    }
}

@Preview
@Composable
fun HomeActivityPreview() {
    LittleLemonTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.padding(it)) {
                HomeActivity(null)
            }
        }
    }
}
