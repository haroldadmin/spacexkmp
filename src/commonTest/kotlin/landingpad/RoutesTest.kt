package com.haroldadmin.spacexkmp.landingpad

import com.haroldadmin.spacexkmp.SuccessHandler
import com.haroldadmin.spacexkmp.createMockClient
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.Test
import kotlin.test.assertEquals

class RoutesTest {
    @Test
    fun `it should get one landing pad correctly`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeLandingPadResponse))
        val routes = LandingPadRoutes(client)
        val expected = Json.decodeFromString(LandingPad.serializer(), FakeLandingPadResponse)
        assertEquals(expected, routes.getOne("<mock-id>"))
    }

    @Test
    fun `it should get all landing pads correctly`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeLandingPadsResponse))
        val routes = LandingPadRoutes(client)
        val expected = Json.decodeFromString(serializer<List<LandingPad>>(), FakeLandingPadsResponse)
        assertEquals(expected, routes.getAll())
    }
}