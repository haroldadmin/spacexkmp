package com.haroldadmin.spacexkmp.launchpads

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class LaunchpadStatus {
    active,
    inactive,
    unknown,
    retired,
    lost,

    @SerialName("under construction")
    underConstruction
}

@Serializable
public data class Launchpad(
    val id: String,
    val name: String?,
    @SerialName("full_name")
    val fullName: String?,
    val status: LaunchpadStatus,
    val locality: String?,
    val region: String?,
    val timezone: String?,
    val latitude: Double?,
    val longitude: Double?,
    @SerialName("launch_attempts")
    val launchAttempts: Int,
    @SerialName("launch_successes")
    val launchSuccesses: Int,
    val rockets: List<String>?,
    val launches: List<String>?
)
