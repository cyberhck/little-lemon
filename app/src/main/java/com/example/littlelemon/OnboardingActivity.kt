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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun OnboardingActivity(
    onRegister: (firstName: String, lastName: String, email: String) -> Unit
) {
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Topbar(null)
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxWidth()
                .padding(10.dp, 40.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Let's get to know you",
                color = MaterialTheme.colorScheme.background,
                style = MaterialTheme.typography.headlineLarge
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
                onValueChange = { firstName = it },
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
                onValueChange = { lastName = it },
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
                onValueChange = { email = it },
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
                    onRegister(firstName, lastName, email)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.tertiary
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Register")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingActivityPreview() {
    LittleLemonTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.padding(it)) {
                OnboardingActivity { firstName, lastName, email ->
                    {


                    }
                }
            }
        }
    }
}