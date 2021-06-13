package com.haroldadmin.spacexkmp.cores

import com.haroldadmin.spacexkmp.SuccessHandler
import com.haroldadmin.spacexkmp.createMockClient
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.Test
import kotlin.test.assertEquals

class RoutesTest {
    @Test
    fun `it should return all cores when server responds successfully`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeCoresResponse))
        val routes = CoresRoutes(client)
        val expected = Json.decodeFromString(serializer<List<Core>>(), FakeCoresResponse)
        val cores = routes.getAll()
        assertEquals(expected, cores)
    }

    @Test
    fun `it should return one core when server responds successfully`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeCoreResponse))
        val routes = CoresRoutes(client)
        val expected = Json.decodeFromString(Core.serializer(), FakeCoreResponse)
        val core = routes.getOne("<mock-id>")
        assertEquals(expected, core)
    }
}