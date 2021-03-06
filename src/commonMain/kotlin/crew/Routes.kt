package com.haroldadmin.spacexkmp.crew

import com.haroldadmin.spacexkmp.Http
import io.ktor.client.*
import io.ktor.client.request.*

public class CrewRoutes(
    private val client: HttpClient = Http.client,
    private val url: String = "${Http.baseUrl}/crew"
) {
    public suspend fun getOne(id: String): Crew {
        val url = "$url/$id"
        return client.get(url)
    }

    public suspend fun getAll(): List<Crew> {
        return client.get(url)
    }
}