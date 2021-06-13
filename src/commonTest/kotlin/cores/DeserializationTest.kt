package com.haroldadmin.spacexkmp.cores

import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.Test
import kotlin.test.assertEquals

class DeserializationTest {
    @Test
    fun `it should decode core correctly`() {
        val json = FakeCoreResponse
        val expected = Core(
            block = 5,
            reuseCount = 3,
            rtlsAttempts = 1,
            rtlsLandings = 1,
            asdsAttempts = 3,
            asdsLandings = 3,
            lastUpdate = "Landed on OCISLY as of Jan 29, 2020. ",
            launches = listOf(
                "5eb87d2bffd86e000604b375",
                "5eb87d31ffd86e000604b379",
                "5eb87d3fffd86e000604b382",
                "5eb87d44ffd86e000604b386",
            ),
            serial = "B1051",
            status = CoreStatus.active,
            id = "5e9e28a6f35918c0803b265c"
        )
        val decoded = Json.decodeFromString(Core.serializer(), json)
        assertEquals(expected, decoded)
    }

    fun `it should decode list of cores correctly`() {
        val json = FakeCoresResponse
        val decoded = Json.decodeFromString<List<Core>>(serializer(), json)
        assertEquals(decoded.size, 1)
    }
}