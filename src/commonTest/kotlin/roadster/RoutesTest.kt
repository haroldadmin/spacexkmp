package com.haroldadmin.spacexkmp.roadster

import com.haroldadmin.spacexkmp.SuccessHandler
import com.haroldadmin.spacexkmp.createMockClient
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class RoutesTest {
    @Test
    fun `it should fetch roadster info successfully`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeRoadsterInfoResponse))
        val routes = RoadsterRoutes(client)
        val expected = Json.decodeFromString(Roadster.serializer(), FakeRoadsterInfoResponse)
        assertEquals(expected, routes.get())
    }
}