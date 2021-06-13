package com.haroldadmin.spacexkmp.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Thrust(
    val kN: Double?,
    val lbf: Double?
)

@Serializable
public data class Mass(
    val kg: Double?,
    val lb: Double?
)

@Serializable
public data class Volume(
    @SerialName("cubic_meters")
    val cubicMeters: Double?,
    @SerialName("cubic_feet")
    val cubicFeet: Double?
)

@Serializable
public data class Length(
    val meters: Double?,
    val feet: Double?
)