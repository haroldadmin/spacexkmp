package com.haroldadmin.spacexkmp

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*

internal object Http {
    val client: HttpClient = HttpClient(CIO) {
        install(JsonFeature)
        install(HttpPlainText)
    }
    val baseUrl: String = "https://api.spacexdata.com/v4"
}
