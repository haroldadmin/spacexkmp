package com.haroldadmin.spacexkmp.landingpad

import com.haroldadmin.spacexkmp.Http
import io.ktor.client.*
import io.ktor.client.request.*

public class LandingPadRoutes(
    private val client: HttpClient = Http.client,
    private val url: String = "${Http.baseUrl}/landpads"
) {
    public suspend fun getOne(id: String): LandingPad {
        val url = "$url/$id"
        return client.get(url)
    }

    public suspend fun getAll(): List<LandingPad> {
        return client.get(url)
    }
}