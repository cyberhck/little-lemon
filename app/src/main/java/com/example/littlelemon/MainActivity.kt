package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.navigation.Home
import com.example.littlelemon.navigation.Onboarding
import com.example.littlelemon.ui.theme.LittleLemonTheme
import androidx.core.content.edit
import com.example.littlelemon.navigation.Greeting
import com.example.littlelemon.navigation.Profile

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val sharedPreferences = getSharedPreferences("little_lemon", MODE_PRIVATE)
        val profile = sharedPreferences.getString("profile", null)
        val initialRoute = if (profile == null) {
            Home.route
        }
        else {
            Onboarding.route
        }
        setContent {
            LittleLemonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = initialRoute) {
                        composable(Onboarding.route) {
                            OnboardingActivity { firstName, lastName, email ->
                                sharedPreferences.edit(commit = true) {
                                    putString(
                                        "profile",
                                        "$firstName|$lastName|$email"
                                    )
                                }
                                navController.navigate(Home.route)
                            }
                        }
                        composable(Profile.route) {
                            ProfileActivity(profile ?: "dummy|dummy|dummy@example.com") {
                                sharedPreferences.edit(commit = true) { clear() }
                            }
                        }
                        composable(Home.route) {
                            HomeActivity {
                                navController.navigate(Profile.route)
                            }
                        }
                        composable(Greeting.route) {
                            GreetingActivity(name="Android", modifier = Modifier.padding(innerPadding))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingActivity(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LittleLemonTheme {
        GreetingActivity("Android")
    }
}