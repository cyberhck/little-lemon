package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun ProfileActivity(
    serializedProfile: String,
    onLogout: () -> Unit
) {
    val (firstName, lastName, email) = serializedProfile.split("|")
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Logo",
                alignment = Alignment.Center,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 40.dp)
        ) {
            Text(text = "Personal Information", style = MaterialTheme.typography.headlineLarge)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp)
        ) {
            OutlinedTextField(
                value = firstName,
                label = { Text(text = "First Name") },
                readOnly = true,
                onValueChange = {  },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp)
        ) {
            OutlinedTextField(
                value = lastName,
                label = { Text(text = "Last Name") },
                readOnly = true,
                onValueChange = {  },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp)
        ) {
            OutlinedTextField(
                value = email,
                label = { Text(text = "Email") },
                readOnly = true,
                onValueChange = { },
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = {
                    onLogout()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.tertiary
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Log out")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileActivityPreview() {
    LittleLemonTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.padding(it)) {
                ProfileActivity("first_name|last_name|email") {  ->
                    {


                    }
                }
            }
        }
    }
}