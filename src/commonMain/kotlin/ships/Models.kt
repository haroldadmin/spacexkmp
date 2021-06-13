package com.haroldadmin.spacexkmp.ships

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Ship(
    val id: String,
    val name: String,
    @SerialName("legacy_id")
    val legacyId: String?,
    val model: String?,
    val type: String?,
    val roles: List<String>?,
    val active: Boolean,
    val imo: Int?,
    val mmsi: Int?,
    val abs: Int?,
    val `class`: Int?,
    @SerialName("mass_kg")
    val massKg: Double?,
    @SerialName("mass_lbs")
    val massLbs: Double?,
    @SerialName("year_built")
    val yearBuilt: Int?,
    @SerialName("home_port")
    val homePort: String?,
    val status: String?,
    @SerialName("speed_kn")
    val speedKn: String?,
    @SerialName("course_deg")
    val courseDeg: Double?,
    val latitude: Double?,
    val longitude: Double?,
    @SerialName("last_ais_update")
    val lastAisUpdate: String?,
    val link: String?,
    val image: String?,
    val launches: List<String>?
)
