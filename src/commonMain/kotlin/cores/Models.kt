package com.haroldadmin.spacexkmp.cores

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

public enum class CoreStatus {
    active, inactive, unknown, expended, lost, retired
}

@Serializable
public data class Core(
    val id: String,
    val serial: String,
    val block: Int?,
    val status: CoreStatus,
    @SerialName("reuse_count")
    val reuseCount: Int,
    @SerialName("rtls_attempts")
    val rtlsAttempts: Int,
    @SerialName("rtls_landings")
    val rtlsLandings: Int,
    @SerialName("asds_attempts")
    val asdsAttempts: Int,
    @SerialName("asds_landings")
    val asdsLandings: Int,
    @SerialName("last_update")
    val lastUpdate: String?,
    val launches: List<String>?
)
