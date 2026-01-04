package com.example.littlelemon.network

import kotlinx.serialization.Serializable

@Serializable
data class MenuItem(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val image: String,
    val category: String,
)

@Serializable
data class Menu(val menu: List<MenuItem>)
