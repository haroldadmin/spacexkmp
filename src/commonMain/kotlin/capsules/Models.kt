package com.haroldadmin.spacexkmp.capsules

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

public enum class CapsuleStatus(public val status: String) {
    Unknown("unknown"),
    Active("active"),
    Retired("retired"),
    Destroyed("destroyed"),
}

public enum class DragonType(public val type: String) {
    Dragon1("Dragon 1.0"),
    Dragon11("Dragon 1.1"),
    Dragon2("Dragon 2.0"),
}

@Serializable()
public data class Capsule(
    val id: String,
    val serial: String,
    @Serializable(with = CapsuleStatusSerializer::class)
    val status: CapsuleStatus,
    @Serializable(with = DragonTypeSerializer::class)
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
