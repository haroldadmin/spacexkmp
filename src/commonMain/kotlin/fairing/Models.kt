package com.haroldadmin.spacexkmp.fairing

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

public enum class FairingStatus {
    active, inactive, unknown, expended, lost, retired
}

@Serializable
public data class Fairing(
    val serial: String,
    val version: String?,
    val status: FairingStatus,
    @SerialName("reuse_count")
    val reuseCount: Int,
    @SerialName("net_landing_attempts")
    val netLandingAttempts: Int,
    @SerialName("net_landing")
    val netLanding: Int,
    @SerialName("water_landing_attempts")
    val waterLandingAttempts: Int,
    @SerialName("water_landing")
    val waterLanding: Int,
    @SerialName("last_update")
    val lastUpdate: String?,
    val launches: List<String>?
)
