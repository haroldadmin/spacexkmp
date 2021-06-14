package com.haroldadmin.spacexkmp.launchpads

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class DeserializationTest {
    @Test
    fun `it should deserialize a launchpad correctly`() {
        val json = FakeLaunchpadResponse
        val expected = Launchpad(
            name = "VAFB SLC 4E",
            fullName = "Vandenberg Air Force Base Space Launch Complex 4E",
            locality = "Vandenberg Air Force Base",
            region = "California",
            timezone = "America/Los_Angeles",
            latitude = 34.632093,
            longitude = -120.610829,
            launchAttempts = 15,
            launchSuccesses = 15,
            rockets = listOf("5e9d0d95eda69973a809d1ec"),
            launches = listOf(
                "5eb87ce1ffd86e000604b334",
                "5eb87cf0ffd86e000604b343",
                "5eb87cfdffd86e000604b34c",
                "5eb87d05ffd86e000604b354",
                "5eb87d08ffd86e000604b357",
                "5eb87d0affd86e000604b359",
                "5eb87d0fffd86e000604b35d",
                "5eb87d14ffd86e000604b361",
                "5eb87d16ffd86e000604b363",
                "5eb87d1affd86e000604b367",
                "5eb87d1fffd86e000604b36b",
                "5eb87d23ffd86e000604b36e",
                "5eb87d25ffd86e000604b370",
                "5eb87d28ffd86e000604b373",
                "5eb87d31ffd86e000604b379"
            ),
            status = LaunchpadStatus.active,
            id = "5e9e4502f509092b78566f87",
            details = "SpaceX's primary west coast launch pad for polar orbits and sun-synchronous orbits, primarily used for Iridium NEXT and scientific satellite launches. The pad was used for the debut of Falcon 9 v1.1 in the rocket's first ever non-dragon mission, CASSIOPE, in September 2013. It is SpaceX's only remaining pad with the old-style transporter/erector, which reclines prior to launch instead of using a throwback procedure. It is also capable of launching Falcon Heavy (although some pad modifications would be needed, but no west coast Falcon Heavy missions are currently planned)."
        )
        val decoded = Json.decodeFromString(Launchpad.serializer(), json)
        assertEquals(expected, decoded)
    }
}