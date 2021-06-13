package com.haroldadmin.spacexkmp.dragons

import com.haroldadmin.spacexkmp.Http
import io.ktor.client.*
import io.ktor.client.request.*

public class DragonRoutes(
    private val client: HttpClient = Http.client,
    private val url: String = "${Http.baseUrl}/dragons"
) {
    public suspend fun getAll(): List<Dragon> {
        return client.get(url)
    }

    public suspend fun getOne(id: String): Dragon {
        val url = "$url/$id"
        return client.get(url)
    }
}