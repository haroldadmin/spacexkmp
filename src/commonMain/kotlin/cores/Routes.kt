package com.haroldadmin.spacexkmp.cores

import com.haroldadmin.spacexkmp.Http
import io.ktor.client.*
import io.ktor.client.request.*

public class CoresRoutes(
    private val client: HttpClient = Http.client,
    private val url: String = "${Http.baseUrl}/cores"
) {
    public suspend fun getAll(): List<Core> {
        return client.get(url)
    }

    public suspend fun getOne(id: String): Core {
        val url = "$url/$id"
        return client.get(url)
    }
}