package com.haroldadmin.spacexkmp.dragons

import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.Test
import kotlin.test.assertEquals

class DeserializationTest {
    @Test
    fun `it should deserialize one dragon correctly`() {
        val json = FakeDragonResponse
        val decoded = Json.decodeFromString(Dragon.serializer(), json)
        assertEquals("5e9d058759b1ff74a7ad5f8f", decoded.id)
        assertEquals("Dragon 1", decoded.name)
    }

    @Test
    fun `it should deserialize list of dragons correctly`() {
        val json = FakeAllDragonsResponse
        val decoded = Json.decodeFromString(serializer<List<Dragon>>(), json)
        assertEquals(1, decoded.size)
    }
}