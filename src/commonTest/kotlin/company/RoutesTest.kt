package com.haroldadmin.spacexkmp.company

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
    fun `it should return company info when server responds successfully`() = runBlocking {
        val client = createMockClient(SuccessHandler(FakeCompanyInfoResponse))
        val routes = CompanyInfoRoutes(client)
        val companyInfo = routes.get()
        val expected = Json.decodeFromString(CompanyInfo.serializer(), FakeCompanyInfoResponse)
        assertEquals(expected, companyInfo)
    }

    @Test
    fun `it should return ClientRequestException for 400 responses`() = runBlocking<Unit> {
        val client = createMockClient(BadRequestHandler)
        val routes = CompanyInfoRoutes(client)
        assertFailsWith<ClientRequestException> {
            routes.get()
        }
    }

    @Test
    @Throws(ServerResponseException::class)
    fun `it should return ServerResponseException for 500 responses`() = runBlocking<Unit> {
        val client = createMockClient(ServerErrorHandler)
        val routes = CompanyInfoRoutes(client)
        assertFailsWith<ServerResponseException> {
            routes.get()
        }
    }
}