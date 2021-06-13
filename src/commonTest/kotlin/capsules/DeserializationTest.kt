package com.haroldadmin.spacexkmp.capsules

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class DeserializationTest {
    @Test
    fun `it should decode Capsule correctly`() {
        val json = FakeCapsuleResponse
        val expected = Capsule(
            id = "5e9e2c5bf35918ed873b2664",
            type = DragonType.Dragon1,
            status = CapsuleStatus.Retired,
            serial = "C101",
            launches = listOf("5eb87cdeffd86e000604b330"),
            lastUpdate = "Reentered after three weeks in orbit",
            landLandings = 0,
            waterLandings = 1,
            reuseCount = 1,
        )
        val decoded = Json.decodeFromString(Capsule.serializer(), json)
        assertEquals(expected, decoded)
    }
}