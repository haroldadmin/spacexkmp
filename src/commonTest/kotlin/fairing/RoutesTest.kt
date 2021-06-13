package com.haroldadmin.spacexkmp.fairing

import com.haroldadmin.spacexkmp.SuccessHandler
import com.haroldadmin.spacexkmp.createMockClient
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.Test
import kotlin.test.assertEquals

class RoutesTest {
    @Test
    fun `it should retrieve one fairing correctly`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeFairingResponse))
        val routes = FairingRoutes(client)
        val expected = Json.decodeFromString(Fairing.serializer(), FakeFairingResponse)
        assertEquals(expected, routes.getOne("<mock-id>"))
    }

    @Test
    fun `it should retrieve all fairings correctly`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeFairingsResponse))
        val routes = FairingRoutes(client)
        val expected = Json.decodeFromString(serializer<List<Fairing>>(), FakeFairingsResponse)
        assertEquals(expected, routes.getAll())
    }
}