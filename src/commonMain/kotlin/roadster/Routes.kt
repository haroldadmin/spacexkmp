package com.haroldadmin.spacexkmp.roadster

import com.haroldadmin.spacexkmp.Http
import io.ktor.client.*
import io.ktor.client.request.*

public class RoadsterRoutes(
    private val client: HttpClient = Http.client,
    private val url: String = "${Http.baseUrl}/roadster"
) {
    public suspend fun get(): Roadster {
        return client.get(url)
    }
}