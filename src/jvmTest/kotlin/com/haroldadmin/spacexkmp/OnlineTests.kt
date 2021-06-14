package com.haroldadmin.spacexkmp

import com.haroldadmin.spacexkmp.capsules.CapsuleRoutes
import com.haroldadmin.spacexkmp.company.CompanyInfoRoutes
import com.haroldadmin.spacexkmp.cores.CoresRoutes
import com.haroldadmin.spacexkmp.crew.CrewRoutes
import com.haroldadmin.spacexkmp.dragons.DragonRoutes
import com.haroldadmin.spacexkmp.fairing.FairingRoutes
import com.haroldadmin.spacexkmp.landingpad.LandingPadRoutes
import com.haroldadmin.spacexkmp.launches.LaunchRoutes
import com.haroldadmin.spacexkmp.launchpads.LaunchpadRoutes
import com.haroldadmin.spacexkmp.payloads.PayloadRoutes
import com.haroldadmin.spacexkmp.roadster.RoadsterRoutes
import com.haroldadmin.spacexkmp.rockets.RocketsRoutes
import com.haroldadmin.spacexkmp.ships.ShipRoutes
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.logging.*
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class OnlineTests {
    @Test
    fun `Online Test for all routes`() = runBlocking<Unit> {
        val client = HttpClient(CIO) {
            install(Logging) {
                level = LogLevel.INFO
            }
            install(JsonFeature)
            install(HttpPlainText)
        }

        val deferreds = listOf(
            async { CapsuleRoutes(client).getAll() },
            async { CompanyInfoRoutes(client).get() },
            async { CoresRoutes(client).getAll() },
            async { CrewRoutes(client).getAll() },
            async { DragonRoutes(client).getAll() },
            async { FairingRoutes(client).getAll() },
            async { LandingPadRoutes(client).getAll() },
            async { LaunchRoutes(client).getAll() },
            async { LaunchpadRoutes(client).getAll() },
            async { PayloadRoutes(client).getAll() },
            async { RoadsterRoutes(client).get() },
            async { RocketsRoutes(client).getAll() },
            async { ShipRoutes(client).getAll() },
        )

        deferreds.awaitAll()
    }
}