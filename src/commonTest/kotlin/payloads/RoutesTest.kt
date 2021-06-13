package com.haroldadmin.spacexkmp.payloads

import com.haroldadmin.spacexkmp.SuccessHandler
import com.haroldadmin.spacexkmp.createMockClient
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.Test
import kotlin.test.assertEquals

class RoutesTest {
    @Test
    fun `it should get one payload correctly`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakePayloadResponse))
        val routes = PayloadRoutes(client)
        val expected = Json.decodeFromString(Payload.serializer(), FakePayloadResponse)
        assertEquals(expected, routes.getOne("<mock-id>"))
    }

    @Test
    fun `it should get all payloads correctly`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakePayloadsResponse))
        val routes = PayloadRoutes(client)
        val expected = Json.decodeFromString(serializer<List<Payload>>(), FakePayloadsResponse)
        assertEquals(expected, routes.getAll())
    }
}