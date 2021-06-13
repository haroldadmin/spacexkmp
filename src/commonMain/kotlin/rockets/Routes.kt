package com.haroldadmin.spacexkmp.rockets

import com.haroldadmin.spacexkmp.Http
import io.ktor.client.*
import io.ktor.client.request.*

public class RocketsRoutes(
    private val client: HttpClient = Http.client,
    private val url: String = "${Http.baseUrl}/rockets"
) {
    public suspend fun getOne(id: String): Rocket {
        val url = "$url/$id"
        return client.get(url)
    }

    public suspend fun getAll(): List<Rocket> {
        return client.get(url)
    }
}