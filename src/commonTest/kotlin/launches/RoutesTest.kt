package com.haroldadmin.spacexkmp.launches

import com.haroldadmin.spacexkmp.SuccessHandler
import com.haroldadmin.spacexkmp.createMockClient
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.Test
import kotlin.test.assertEquals

class RoutesTest {
    @Test
    fun `it should fetch one launch correctly`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeLaunchResponse))
        val routes = LaunchRoutes(client)
        val expected = Json.decodeFromString(Launch.serializer(), FakeLaunchResponse)
        assertEquals(expected, routes.getOne("<mock-id>"))
    }

    @Test
    fun `it should fetch all launches correctly`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeLaunchesResponse))
        val routes = LaunchRoutes(client)
        val expected = Json.decodeFromString(serializer<List<Launch>>(), FakeLaunchesResponse)
        assertEquals(expected, routes.getAll())
    }
}