package com.haroldadmin.spacexkmp.capsules

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

public enum class CapsuleStatus {
    unknown,
    active,
    retired,
    destroyed,
}

@Serializable
public enum class DragonType {
    @SerialName("Dragon 1.0")
    Dragon1,
    @SerialName("Dragon 1.1")
    Dragon1_1,
    @SerialName("Dragon 2.0")
    Dragon2,
}

@Serializable()
public data class Capsule(
    val id: String,
    val serial: String,
    val status: CapsuleStatus,
    val type: DragonType,
    @SerialName("reuse_count")
    val reuseCount: Int,
    @SerialName("water_landings")
    val waterLandings: Int,
    @SerialName("land_landings")
    val landLandings: Int,
    @SerialName("last_update")
    val lastUpdate: String?,
    val launches: List<String>?,
)
