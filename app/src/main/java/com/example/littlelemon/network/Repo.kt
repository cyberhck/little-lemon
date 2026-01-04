package com.example.littlelemon.network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json

object Repo {
    public suspend fun fetch(): List<MenuItem> {
        val client = HttpClient(Android){
            install(ContentNegotiation) {
                json(contentType = ContentType("text", "plain"))
            }
        }
        val response: Menu = client
            .get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
            .body()

        return response.menu
    }
}
