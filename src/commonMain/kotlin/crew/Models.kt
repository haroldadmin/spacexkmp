package com.haroldadmin.spacexkmp.crew

import kotlinx.serialization.Serializable

public enum class CrewStatus {
    active, inactive, retired, unknown
}

@Serializable
public data class Crew(
    val name: String?,
    val status: CrewStatus,
    val agency: String?,
    val image: String?,
    val wikipedia: String?,
    val launches: List<String>
)
