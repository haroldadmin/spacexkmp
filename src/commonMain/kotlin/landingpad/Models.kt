package com.haroldadmin.spacexkmp.landingpad

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

public enum class LandingPadStatus {
    active,
    inactive,
    unknown,
    lost,
    retired,
    @SerialName("under construction")
    underConstruction
}

@Serializable
public data class LandingPad(
    val id: String,
    val name: String?,
    @SerialName("full_name")
    val fullName: String?,
    val status: LandingPadStatus,
    val type: String?,
    val locality: String?,
    val region: String?,
    val latitude: Double?,
    val longitude: Double?,
    @SerialName("landing_attempts")
    val landingAttempts: Int,
    @SerialName("landing_successes")
    val landingSuccesses: Int,
    val wikipedia: String?,
    val details: String?,
    val launches: List<String>?
)
