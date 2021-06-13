package com.haroldadmin.spacexkmp.capsules

import com.haroldadmin.spacexkmp.Http
import io.ktor.client.*
import io.ktor.client.request.*

public class CapsuleRoutes(
    private val client: HttpClient = Http.client,
    private val url: String = "${Http.baseUrl}/capsules",
) {
    public suspend fun getAll(): List<Capsule> {
        return client.get(url)
    }

    public suspend fun getOne(id: String): Capsule {
        val capsuleUrl = "$url/$id"
        return client.get(capsuleUrl)
    }
}