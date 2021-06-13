package com.haroldadmin.spacexkmp.launches

import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.Test
import kotlin.test.assertEquals

class DeserializationTest {
    @Test
    fun `it should deserialize one launch correctly`() {
        val json = FakeLaunchResponse
        val expected = Launch(
            fairings = null,
            links = LaunchLinks(
                patch = LaunchPatch(
                    small = "https://images2.imgbox.com/53/22/dh0XSLXO_o.png",
                    large = "https://images2.imgbox.com/15/2b/NAcsTEB6_o.png"
                ),
                reddit = RedditLinks(
                    campaign = "https://www.reddit.com/r/spacex/comments/ezn6n0/crs20_launch_campaign_thread",
                    launch = "https://www.reddit.com/r/spacex/comments/fe8pcj/rspacex_crs20_official_launch_discussion_updates/",
                    media = "https://www.reddit.com/r/spacex/comments/fes64p/rspacex_crs20_media_thread_videos_images_gifs/",
                    recovery = null
                ),
                flickr = FlickrLinks(
                    small = emptyList(),
                    original = listOf(
                        "https://live.staticflickr.com/65535/49635401403_96f9c322dc_o.jpg",
                        "https://live.staticflickr.com/65535/49636202657_e81210a3ca_o.jpg",
                        "https://live.staticflickr.com/65535/49636202572_8831c5a917_o.jpg",
                        "https://live.staticflickr.com/65535/49635401423_e0bef3e82f_o.jpg",
                        "https://live.staticflickr.com/65535/49635985086_660be7062f_o.jpg"
                    )
                ),
                presskit = "https://www.spacex.com/sites/spacex/files/crs-20_mission_press_kit.pdf",
                webcast = "https://youtu.be/1MkcWK2PnsU",
                youtubeId = "1MkcWK2PnsU",
                article = "https://spaceflightnow.com/2020/03/07/late-night-launch-of-spacex-cargo-ship-marks-end-of-an-era/",
                wikipedia = "https://en.wikipedia.org/wiki/SpaceX_CRS-20",
            ),
            staticFireDateUtc = "2020-03-01T10:20:00.000Z",
            staticFireDateUnix = 1583058000,
            tdb = false,
            net = false,
            window = 0,
            rocket = "5e9d0d95eda69973a809d1ec",
            success = true,
            failures = emptyList(),
            details = "SpaceX's 20th and final Crew Resupply Mission under the original NASA CRS contract, this mission brings essential supplies to the International Space Station using SpaceX's reusable Dragon spacecraft. It is the last scheduled flight of a Dragon 1 capsule. (CRS-21 and up under the new Commercial Resupply Services 2 contract will use Dragon 2.) The external payload for this mission is the Bartolomeo ISS external payload hosting platform. Falcon 9 and Dragon will launch from SLC-40, Cape Canaveral Air Force Station and the booster will land at LZ-1. The mission will be complete with return and recovery of the Dragon capsule and down cargo.",
            crew = emptyList(),
            ships = emptyList(),
            capsules = listOf("5e9e2c5cf359185d753b266f"),
            payloads = listOf("5eb0e4d0b6c3bb0006eeb253"),
            launchpad = "5e9e4501f509094ba4566f84",
            autoUpdate = true,
            flightNumber = 91,
            name = "CRS-20",
            dateUtc = "2020-03-07T04:50:31.000Z",
            dateUnix = 1583556631,
            dateLocal = "2020-03-06T23:50:31-05:00",
            datePrecision = DatePrecision.hour,
            upcoming = false,
            cores = listOf(
                Core(
                    core = "5e9e28a7f359187afd3b2662",
                    flight = 2,
                    gridfins = true,
                    legs = true,
                    reused = true,
                    landingAttempt = true,
                    landingSuccess = true,
                    landingType = "RTLS",
                    landpad = "5e9e3032383ecb267a34e7c7"
                )
            ),
            id = "5eb87d42ffd86e000604b384"
        )
        val decoded = Json.decodeFromString(Launch.serializer(), json)
        assertEquals(expected, decoded)
    }

    @Test
    fun `it should deserialize list of launches correctly`() {
        val json = FakeLaunchesResponse
        val decoded = Json.decodeFromString(serializer<List<Launch>>(), json)
        assertEquals(1, decoded.size)
    }
}