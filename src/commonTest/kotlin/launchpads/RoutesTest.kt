package com.haroldadmin.spacexkmp.launchpads

import com.haroldadmin.spacexkmp.SuccessHandler
import com.haroldadmin.spacexkmp.createMockClient
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.Test
import kotlin.test.assertEquals

class RoutesTest {
    @Test
    fun `it should fetch one launchpad correctly`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeLaunchpadResponse))
        val routes = LaunchpadRoutes(client)
        val expected = Json.decodeFromString(Launchpad.serializer(), FakeLaunchpadResponse)
        assertEquals(expected, routes.getOne("<mock-id>"))
    }

    @Test
    fun `it should fetch all launchpads correctly`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeLaunchpadsResponse))
        val routes = LaunchpadRoutes(client)
        val expected = Json.decodeFromString(serializer<List<Launchpad>>(), FakeLaunchpadsResponse)
        assertEquals(expected, routes.getAll())
    }
}