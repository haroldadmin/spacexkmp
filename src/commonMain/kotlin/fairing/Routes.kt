package com.haroldadmin.spacexkmp.fairing

import com.haroldadmin.spacexkmp.Http
import io.ktor.client.*
import io.ktor.client.request.*

public class FairingRoutes(
    private val client: HttpClient = Http.client,
    private val url: String = "${Http.baseUrl}/fairings"
) {
    public suspend fun getOne(id: String): Fairing {
        val url = "$url/$id"
        return client.get(url)
    }

    public suspend fun getAll(): List<Fairing> {
        return client.get(url)
    }
}