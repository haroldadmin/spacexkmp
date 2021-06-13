package com.haroldadmin.spacexkmp.roadster

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class DeserializationTest {
    @Test
    fun `it should deserialize roadster info correctly`() {
        val json = FakeRoadsterInfoResponse
        val expected = Roadster(
            flickrImages = listOf(
                "https://farm5.staticflickr.com/4615/40143096241_11128929df_b.jpg",
                "https://farm5.staticflickr.com/4702/40110298232_91b32d0cc0_b.jpg",
                "https://farm5.staticflickr.com/4676/40110297852_5e794b3258_b.jpg",
                "https://farm5.staticflickr.com/4745/40110304192_6e3e9a7a1b_b.jpg"
            ),
            name = "Elon Musk's Tesla Roadster",
            launchDateUtc = "2018-02-06T20:45:00.000Z",
            launchDateUnix = 1517949900,
            launchMassKg = 1350.0,
            launchMassLbs = 2976.0,
            noradId = 43205,
            epochJd = 2459014.345891204,
            orbitType = "heliocentric",
            apoapsisAu = 1.663950009802517,
            periapsisAu = 0.9859657216725529,
            semiMajorAxisAu = 196.2991348009594,
            eccentricity = 0.2558512635239784,
            inclination = 1.077499248052439,
            longitude = 317.0839961949045,
            periapsisArg = 177.5240278992875,
            periodDays = 557.059427465354,
            speedKph = 72209.97792,
            speedMph = 44869.18619012833,
            earthDistanceKm = 220606726.83228922,
            earthDistanceMi = 137078622.45850638,
            marsDistanceKm = 89348334.47067611,
            marsDistanceMi = 55518463.93837848,
            wikipedia = "https://en.wikipedia.org/wiki/Elon_Musk%27s_Tesla_Roadster",
            video = "https://youtu.be/wbSwFU6tY1c",
            details = "Elon Musk's Tesla Roadster is an electric sports car that served as the dummy payload for the February 2018 Falcon Heavy test flight and is now an artificial satellite of the Sun. Starman, a mannequin dressed in a spacesuit, occupies the driver's seat. The car and rocket are products of Tesla and SpaceX. This 2008-model Roadster was previously used by Musk for commuting, and is the only consumer car sent into space.",
            id = "5eb75f0842fea42237d7f3f4"
        )
        val decoded = Json.decodeFromString(Roadster.serializer(), json)
        assertEquals(expected, decoded)
    }
}