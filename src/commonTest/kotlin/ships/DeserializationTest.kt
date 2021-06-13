package com.haroldadmin.spacexkmp.ships

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class DeserializationTest {
    @Test
    fun `it should deserialize a ship correctly`() {
        val json = FakeShipResponse
        val expected = Ship(
            legacyId = "GOPURSUIT",
            model = null,
            type = "Cargo",
            roles = listOf(
                "Support Ship",
                "Fairing Recovery"
            ),
            imo = 9458884,
            mmsi = 367191410,
            abs = 1201189,
            `class` = 7174230,
            massKg = 502999.0,
            massLbs = 1108925.0,
            yearBuilt = 2007,
            homePort = "Port Canaveral",
            status = "",
            speedKn = null,
            courseDeg = null,
            latitude = null,
            longitude = null,
            lastAisUpdate = null,
            link = "https://www.marinetraffic.com/en/ais/details/ships/shipid:439594/mmsi:367191410/imo:9458884/vessel:GO_PURSUIT",
            image = "https://i.imgur.com/5w1ZWre.jpg",
            launches = listOf(
                "5eb87d18ffd86e000604b365",
                "5eb87d19ffd86e000604b366",
                "5eb87d1bffd86e000604b368",
                "5eb87d1effd86e000604b36a"
            ),
            name = "GO Pursuit",
            active = false,
            id = "5ea6ed2e080df4000697c90a"
        )
        val decoded = Json.decodeFromString(Ship.serializer(), json)
        assertEquals(expected, decoded)
    }
}