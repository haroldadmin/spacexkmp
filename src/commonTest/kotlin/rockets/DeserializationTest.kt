package com.haroldadmin.spacexkmp.rockets

import com.haroldadmin.spacexkmp.common.Length
import com.haroldadmin.spacexkmp.common.Mass
import com.haroldadmin.spacexkmp.common.Thrust
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class DeserializationTest {
    @Test
    fun `it should deserialize one rocket correctly`() {
        val json = FakeRocketResponse
        val expected = Rocket(
            height = Length(
                meters = 70.0,
                feet = 229.6,
            ),
            diameter = Length(
                meters = 12.2,
                feet = 39.9,
            ),
            mass = Mass(
                kg = 1420788.0,
                lb = 3125735.0,
            ),
            firstStage = FirstStage(
                thrustSeaLevel = Thrust(
                    kN = 22819.0,
                    lbf = 5130000.0,
                ),
                thrustVacuum = Thrust(
                    kN = 24681.0,
                    lbf = 5548500.0,
                ),
                reusable = true,
                engines = 27,
                fuelAmountTons = 1155.0,
                burnTimeSec = 162.0,
            ),
            secondStage = SecondStage(
                thrust = Thrust(kN = 934.0, lbf = 210000.0),
                payloads = SecondStagePayloads(
                    compositeFairing = CompositeFairing(
                        height = Length(meters = 13.1, feet = 43.0),
                        diameter = Length(meters = 5.2, feet = 17.1),
                    ),
                    option1 = "dragon",
                ),
                reusable = false,
                engines = 1,
                fuelAmountTons = 90.0,
                burnTimeSec = 397.0,
            ),
            engines = Engines(
                isp = ISP(
                    seaLevel = 288.0,
                    vacuum = 312.0,
                ),
                thrustSeaLevel = Thrust(
                    kN = 845.0,
                    lbf = 190000.0,
                ),
                thrustVacuum = Thrust(
                    kN = 914.0,
                    lbf = 205500.0,
                ),
                number = 27,
                type = "merlin",
                version = "1D+",
                layout = "octaweb",
                engineLossMax = 6,
                propellantOne = "liquid oxygen",
                propellantTwo = "RP-1 kerosene",
                thrustToWeight = 180.1,
            ),
            landingLegs = LandingLegs(
                number = 12,
                material = "carbon fiber",
            ),
            payloadWeights = listOf(
                PayloadWeight(
                    id = "leo",
                    name = "Low Earth Orbit",
                    kg = 63800.0,
                    lb = 140660.0
                ),
                PayloadWeight(
                    id = "gto",
                    name = "Geosynchronous Transfer Orbit",
                    kg = 26700.0,
                    lb = 58860.0
                ),
                PayloadWeight(
                    id = "mars",
                    name = "Mars Orbit",
                    kg = 16800.0,
                    lb = 37040.0
                ),
                PayloadWeight(
                    id = "pluto",
                    name = "Pluto Orbit",
                    kg = 3500.0,
                    lb = 7720.0,
                ),
            ),
            flickrImages = listOf(
                "https://farm5.staticflickr.com/4599/38583829295_581f34dd84_b.jpg",
                "https://farm5.staticflickr.com/4645/38583830575_3f0f7215e6_b.jpg",
                "https://farm5.staticflickr.com/4696/40126460511_b15bf84c85_b.jpg",
                "https://farm5.staticflickr.com/4711/40126461411_aabc643fd8_b.jpg"
            ),
            name = "Falcon Heavy",
            type = "rocket",
            active = true,
            stages = 2,
            boosters = 2,
            costPerLaunch = 90000000.0,
            successRatePercentage = 100.0,
            firstFlight = "2018-02-06",
            country = "United States",
            company = "SpaceX",
            wikipedia = "https://en.wikipedia.org/wiki/Falcon_Heavy",
            description = "With the ability to lift into orbit over 54 metric tons (119,000 lb)--a mass equivalent to a 737 jetliner loaded with passengers, crew, luggage and fuel--Falcon Heavy can lift more than twice the payload of the next closest operational vehicle, the Delta IV Heavy, at one-third the cost.",
            id = "5e9d0d95eda69974db09d1ed"
        )
        val decoded = Json.decodeFromString(Rocket.serializer(), json)
        assertEquals(expected, decoded)
    }
}