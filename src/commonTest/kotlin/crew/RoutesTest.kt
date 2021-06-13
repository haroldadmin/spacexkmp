package com.haroldadmin.spacexkmp.crew

import com.haroldadmin.spacexkmp.BadRequestHandler
import com.haroldadmin.spacexkmp.ServerErrorHandler
import com.haroldadmin.spacexkmp.SuccessHandler
import com.haroldadmin.spacexkmp.createMockClient
import io.ktor.client.features.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RoutesTest {
    @Test
    fun `it should get one crew when server responds successfully`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeOneCrewResponse))
        val routes = CrewRoutes(client)
        val expected = Json.decodeFromString(Crew.serializer(), FakeOneCrewResponse)
        val crew = routes.getOne("<mock-id>")
        assertEquals(expected, crew)
    }

    @Test
    fun `it should get all crew members when server responds successfully`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeAllCrewResponse))
        val routes = CrewRoutes(client)
        val expected = Json.decodeFromString(serializer<List<Crew>>(), FakeAllCrewResponse)
        val allCrew = routes.getAll()
        assertEquals(expected, allCrew)
    }

    @Test
    fun `it should throw ClientRequestException on 400 errors`() = runBlocking<Unit> {
        val client = createMockClient(BadRequestHandler)
        val routes = CrewRoutes(client)
        assertFailsWith<ClientRequestException> { routes.getAll() }
    }

    @Test
    fun `it should throw ServerResponseException on 500 errors`() = runBlocking<Unit> {
        val client = createMockClient(ServerErrorHandler)
        val routes = CrewRoutes(client)
        assertFailsWith<ServerResponseException> { routes.getAll() }
    }
}