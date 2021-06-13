package com.haroldadmin.spacexkmp.landingpad

import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.Test
import kotlin.test.assertEquals

class DeserializationTest {
    @Test
    fun `it should deserialize a landing pad correctly`() {
        val json = FakeLandingPadResponse
        val expected = LandingPad(
            name = "LZ-2",
            fullName = "Landing Zone 2",
            status = LandingPadStatus.active,
            type = "RTLS",
            locality = "Cape Canaveral",
            region = "Florida",
            latitude = 28.485833,
            longitude = -80.544444,
            landingAttempts = 3,
            landingSuccesses = 3,
            wikipedia = "https://en.wikipedia.org/wiki/Landing_Zones_1_and_2",
            details = "SpaceX's first east coast landing pad is Landing Zone 1, where the historic first Falcon 9 landing occurred in December 2015. LC-13 was originally used as a launch pad for early Atlas missiles and rockets from Lockheed Martin. LC-1 was later expanded to include Landing Zone 2 for side booster RTLS Falcon Heavy missions, and it was first used in February 2018 for that purpose.",
            launches = listOf(
                "5eb87d13ffd86e000604b360",
                "5eb87d2dffd86e000604b376",
                "5eb87d35ffd86e000604b37a"
            ),
            id = "5e9e3032383ecb90a834e7c8",
        )
        val decoded = Json.decodeFromString(LandingPad.serializer(), json)
        assertEquals(expected, decoded)
    }

    @Test
    fun `it should deserialize list of landing pads correctly`() {
        val json = FakeLandingPadsResponse
        val decoded = Json.decodeFromString(serializer<List<LandingPad>>(), json)
        assertEquals(1, decoded.size)
    }
}