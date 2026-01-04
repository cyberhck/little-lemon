package com.example.littlelemon.navigation

interface Destination {
    val route: String
}

object Onboarding : Destination {
    override val route: String = "Onboarding"
}
object Home: Destination {
    override val route: String = "Home"
}

object Greeting: Destination {
    override val route: String = "Greeting"
}

object Profile: Destination {
    override val route: String = "Profile"
}
