package com.haroldadmin.spacexkmp.payloads

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class DeserializationTest {
    @Test
    fun `it should deserialize a payload correctly`() {
        val json = FakePayloadResponse
        val expected = Payload(
            dragon = PayloadDragon(
                capsule = null,
                massReturnedKg = null,
                massReturnedLbs = null,
                flightTimeSec = null,
                manifest = null,
                waterLanding = null,
                landLanding = null,
            ),
            name = "Tintin A & B",
            type = "Satellite",
            reused = false,
            launch = "5eb87d14ffd86e000604b361",
            customers = listOf("SpaceX"),
            noradIds = listOf(43216, 43217),
            nationalities = listOf("United States"),
            manufacturers = listOf("SpaceX"),
            massKg = 800.0,
            massLbs = 1763.7,
            orbit = "SSO",
            referenceSystem = "geocentric",
            regime = "low-earth",
            longitude = null,
            semiMajorAxisKm = 6737.42,
            eccentricity = 0.0012995,
            periapsisKm = 350.53,
            apoapsisKm = 368.04,
            inclinationDeg = 97.4444,
            periodMin = 91.727,
            lifespanYears = 1.0,
            epoch = "2020-06-13T13:46:31.000Z",
            meanMotion = 15.69864906,
            raan = 176.6734,
            argOfPericenter = 174.2326,
            meanAnomaly = 185.9087,
            id = "5eb0e4c6b6c3bb0006eeb21e"
        )
        val decoded = Json.decodeFromString(Payload.serializer(), json)
        assertEquals(expected, decoded)
    }
}