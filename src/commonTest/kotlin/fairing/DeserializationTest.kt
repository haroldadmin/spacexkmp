package com.haroldadmin.spacexkmp.fairing

import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.Test
import kotlin.test.assertEquals

class DeserializationTest {
    @Test
    fun `it should deserialize one fairing correctly`() {
        val json = FakeFairingResponse
        val expected = Fairing(
            serial = "ff13b75ee72046ea8b00e9f4ac242f0b",
            version = "2.1",
            status = FairingStatus.active,
            reuseCount = 3,
            netLandingAttempts = 2,
            netLanding = 1,
            waterLandingAttempts = 1,
            waterLanding = 1,
            lastUpdate = "2020-12-20T21:01:14.606Z",
            launches = listOf(
                "e7ba84e6294145a1bec0b684a6ca9aa6",
                "9daa1cebfedc41199e9ef5747d17d5c4",
                "9120aff3571e4af18dba1021dac4dfdd"
            )
        )

        val decoded = Json.decodeFromString(Fairing.serializer(), json)
        assertEquals(expected, decoded)
    }

    @Test
    fun `it should deserialize list of fairings correctly`() {
        val json = FakeFairingsResponse
        val decoded = Json.decodeFromString(serializer<List<Fairing>>(), json)
        assertEquals(1, decoded.size)
    }
}