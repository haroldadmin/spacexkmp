package com.haroldadmin.spacexkmp.payloads

import com.haroldadmin.spacexkmp.Http
import io.ktor.client.*
import io.ktor.client.request.*

public class PayloadRoutes(
    private val client: HttpClient = Http.client,
    private val url: String = "${Http.baseUrl}/payloads",
) {
    public suspend fun getOne(id: String): Payload {
        val url = "$url/$id"
        return client.get(url)
    }

    public suspend fun getAll(): List<Payload> {
        return client.get(url)
    }
}