package com.haroldadmin.spacexkmp.capsules

import com.haroldadmin.spacexkmp.BadRequestHandler
import com.haroldadmin.spacexkmp.ServerErrorHandler
import com.haroldadmin.spacexkmp.SuccessHandler
import com.haroldadmin.spacexkmp.createMockClient
import io.ktor.client.features.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RoutesTest {
    @Test
    fun `it should get all capsules when server responds successfully`() = runBlocking {
        val mockClient = createMockClient(SuccessHandler(FakeCapsulesResponse))
        val capsules = CapsuleRoutes(mockClient)
        val all = capsules.getAll()
        assertEquals(1, all.size)
    }

    @Test
    fun `it should get one capsule when server responds successfully`() = runBlocking {
        val mockClient = createMockClient(SuccessHandler(FakeCapsuleResponse))
        val capsules = CapsuleRoutes(mockClient)
        val capsule = capsules.getOne("<mock-id>")
        val expected = Json.decodeFromString(Capsule.serializer(), FakeCapsuleResponse)
        assertEquals(expected, capsule)
    }

    @Test
    fun `it should throw client request exception on 400 errors`() = runBlocking<Unit> {
        val mockClient = createMockClient(BadRequestHandler)
        val capsules = CapsuleRoutes(mockClient)
        assertFailsWith<ClientRequestException> {
            capsules.getAll()
        }
    }

    @Test
    fun `it should throw server response exception on 500 errors`() = runBlocking<Unit> {
        val mockClient = createMockClient(ServerErrorHandler)
        val capsules = CapsuleRoutes(mockClient)
        assertFailsWith<ServerResponseException> {
            capsules.getAll()
        }
    }
}