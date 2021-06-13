package com.haroldadmin.spacexkmp.launches

import com.haroldadmin.spacexkmp.Http
import io.ktor.client.*
import io.ktor.client.request.*

public class LaunchRoutes(
    private val client: HttpClient = Http.client,
    private val url: String = "${Http.baseUrl}/launches"
) {
    public suspend fun getOne(id: String): Launch {
        val url = "$url/$id"
        return client.get(url)
    }

    public suspend fun getAll(): List<Launch> {
        return client.get(url)
    }

    public suspend fun getPast(): List<Launch> {
        val url = "$url/past"
        return client.get(url)
    }

    public suspend fun getUpcoming(): List<Launch> {
        val url = "$url/upcoming"
        return client.get(url)
    }

    public suspend fun getLatest(): Launch {
        val url = "$url/latest"
        return client.get(url)
    }

    public suspend fun getNext(): Launch {
        val url = "$url/next"
        return client.get(url)
    }
}