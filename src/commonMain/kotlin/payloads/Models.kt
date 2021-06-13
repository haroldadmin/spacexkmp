package com.haroldadmin.spacexkmp.payloads

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Payload(
    val id: String,
    val name: String?,
    val type: String?,
    val reused: Boolean,
    val launch: String?,
    val customers: List<String>?,
    @SerialName("norad_ids")
    val noradIds: List<Int>?,
    val nationalities: List<String>?,
    val manufacturers: List<String>?,
    @SerialName("mass_kg")
    val massKg: Double?,
    @SerialName("mass_lbs")
    val massLbs: Double?,
    val orbit: String?,
    @SerialName("reference_system")
    val referenceSystem: String?,
    val regime: String?,
    val longitude: Double?,
    @SerialName("semi_major_axis_km")
    val semiMajorAxisKm: Double?,
    val eccentricity: Double?,
    @SerialName("periapsis_km")
    val periapsisKm: Double?,
    @SerialName("apoapsis_km")
    val apoapsisKm: Double?,
    @SerialName("inclination_deg")
    val inclinationDeg: Double?,
    @SerialName("period_min")
    val periodMin: Double?,
    @SerialName("lifespan_years")
    val lifespanYears: Double?,
    val epoch: String?,
    @SerialName("mean_motion")
    val meanMotion: Double?,
    val raan: Double?,
    @SerialName("arg_of_pericenter")
    val argOfPericenter: Double?,
    @SerialName("mean_anomaly")
    val meanAnomaly: Double?,
    val dragon: PayloadDragon?,
)

@Serializable
public data class PayloadDragon(
    val capsule: String?,
    @SerialName("mass_returned_kg")
    val massReturnedKg: Double?,
    @SerialName("mass_returned_lbs")
    val massReturnedLbs: Double?,
    @SerialName("flight_time_sec")
    val flightTimeSec: Double?,
    val manifest: String?,
    @SerialName("water_landing")
    val waterLanding: Boolean?,
    @SerialName("land_landing")
    val landLanding: Boolean?
)