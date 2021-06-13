package com.haroldadmin.spacexkmp.launchpads

import com.haroldadmin.spacexkmp.Http
import io.ktor.client.*
import io.ktor.client.request.*

public class LaunchpadRoutes(
    private val client: HttpClient = Http.client,
    private val url: String = "${Http.baseUrl}/launchpads"
) {
    public suspend fun getOne(id: String): Launchpad {
        val url = "$url/$id"
        return client.get(url)
    }

    public suspend fun getAll(): List<Launchpad> {
        return client.get(url)
    }
}