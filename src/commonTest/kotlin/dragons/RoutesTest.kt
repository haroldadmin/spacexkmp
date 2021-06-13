package com.haroldadmin.spacexkmp.dragons

import com.haroldadmin.spacexkmp.SuccessHandler
import com.haroldadmin.spacexkmp.createMockClient
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.assertEquals

class RoutesTest {
    fun `it should fetch one dragon correctly`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeDragonResponse))
        val routes = DragonRoutes(client)
        val expected = Json.decodeFromString(Dragon.serializer(),FakeDragonResponse)
        assertEquals(expected, routes.getOne("<mock-id>"))
    }

    fun `it should fetch all dragons correctly`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeAllDragonsResponse))
        val routes = DragonRoutes(client)
        assertEquals(1, routes.getAll().size)
    }
}