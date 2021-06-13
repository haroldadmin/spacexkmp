package com.haroldadmin.spacexkmp.company

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class DeserializationTest {
    @Test
    fun `it should decode company info correctly`() {
        val json = FakeCompanyInfoResponse
        val expected = CompanyInfo(
            headquarters = Headquarters(
                address = "Rocket Road",
                city = "Hawthorne",
                state = "California",
            ),
            links = CompanyLinks(
                website = "https://www.spacex.com/",
                flickr = "https://www.flickr.com/photos/spacex/",
                twitter = "https://twitter.com/SpaceX",
                elonTwitter = "https://twitter.com/elonmusk",
            ),
            name = "SpaceX",
            founder = "Elon Musk",
            founded = 2002,
            employees = 8000,
            vehicles = 3,
            launchSites = 3,
            testSites = 1,
            ceo = "Elon Musk",
            cto = "Elon Musk",
            coo = "Gwynne Shotwell",
            ctoPropulsion = "Tom Mueller",
            valuation = 52000000000.0,
            summary = "SpaceX designs, manufactures and launches advanced rockets and spacecraft. The company was founded in 2002 to revolutionize space technology, with the ultimate goal of enabling people to live on other planets.",
            id = "5eb75edc42fea42237d7f3ed",
        )
        val decoded = Json.decodeFromString(CompanyInfo.serializer(), json)
        assertEquals(expected, decoded)
    }
}