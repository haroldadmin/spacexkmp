package com.haroldadmin.spacexkmp.company

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CompanyInfo(
    val id: String?,
    val name: String?,
    val founder: String?,
    val founded: Int?,
    val employees: Int?,
    val vehicles: Int?,
    @SerialName("launch_sites")
    val launchSites: Int?,
    @SerialName("test_sites")
    val testSites: Int?,
    val ceo: String?,
    val cto: String?,
    val coo: String?,
    @SerialName("cto_propulsion")
    val ctoPropulsion: String?,
    val valuation: Double?,
    val headquarters: Headquarters?,
    val links: CompanyLinks?,
    val summary: String?,
)

@Serializable
public data class Headquarters(
    val address: String?,
    val city: String?,
    val state: String?,
)

@Serializable
public data class CompanyLinks(
    val website: String?,
    val flickr: String?,
    val twitter: String?,
    @SerialName("elon_twitter")
    val elonTwitter: String?,
)
