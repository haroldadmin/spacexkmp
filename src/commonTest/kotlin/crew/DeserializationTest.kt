package com.haroldadmin.spacexkmp.crew

import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.Test
import kotlin.test.assertEquals

class DeserializationTest {
    @Test
    fun `it should deserialize one crew correctly`() {
        val json = FakeOneCrewResponse
        val expected = Crew(
            id = "5ebf1b7323a9a60006e03a7b",
            name = "Douglas Hurley",
            agency = "NASA",
            image = "https://i.imgur.com/ooaayWf.png",
            wikipedia = "https://en.wikipedia.org/wiki/Douglas_G._Hurley",
            launches = listOf("5eb87d46ffd86e000604b388"),
            status = CrewStatus.active,
        )
        val crew = Json.decodeFromString(Crew.serializer(), json)
        assertEquals(expected, crew)
    }

    @Test
    fun `it should deserialize crew list correctly`() {
        val json = FakeAllCrewResponse
        val allCrew = Json.decodeFromString(serializer<List<Crew>>(), json)
        assertEquals(1, allCrew.size)
    }
}