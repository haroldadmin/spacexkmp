package com.haroldadmin.spacexkmp.ships

import com.haroldadmin.spacexkmp.Http
import io.ktor.client.*
import io.ktor.client.request.*

public class ShipRoutes(
    private val client: HttpClient = Http.client,
    private val url: String = "${Http.baseUrl}/ships"
) {
    public suspend fun getOne(id: String): Ship {
        val url = "$url/$id"
        return client.get(url)
    }

    public suspend fun getAll(): List<Ship> {
        return client.get(url)
    }
}