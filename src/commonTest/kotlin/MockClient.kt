package com.haroldadmin.spacexkmp

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.http.*

internal fun createMockClient(handler: MockRequestHandler): HttpClient {
    return HttpClient(MockEngine) {
        install(JsonFeature)
        install(HttpPlainText)
        engine { addHandler(handler) }
    }
}

val ServerErrorHandler: MockRequestHandler = {
    val headers = headersOf("Content-Type", "text/plain")
    respond("Server Error", HttpStatusCode.InternalServerError, headers)
}

val BadRequestHandler: MockRequestHandler = {
    val headers = headersOf("Content-Type", "text/plain")
    respond("Bad Request", HttpStatusCode.BadRequest, headers)
}

fun SuccessHandler(jsonBody: String): MockRequestHandler {
    return {
        val headers = headersOf("Content-Type", "application/json")
        respond(jsonBody, HttpStatusCode.OK, headers)
    }
}