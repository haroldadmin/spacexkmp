package com.haroldadmin.spacexkmp.company

import com.haroldadmin.spacexkmp.Http
import io.ktor.client.*
import io.ktor.client.request.*

public class CompanyInfoRoutes(
    private val client: HttpClient = Http.client,
    private val url: String = "${Http.baseUrl}/company"
) {
    public suspend fun get(): CompanyInfo {
        return client.get(url)
    }
}