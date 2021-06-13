package com.haroldadmin.spacexkmp.roadster

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Roadster(
    val id: String,
    val name: String?,
    @SerialName("launch_date_utc")
    val launchDateUtc: String?,
    @SerialName("launch_date_unix")
    val launchDateUnix: Long?,
    @SerialName("launch_mass_kg")
    val launchMassKg: Double?,
    @SerialName("launch_mass_lbs")
    val launchMassLbs: Double?,
    @SerialName("norad_id")
    val noradId: Long?,
    @SerialName("epoch_jd")
    val epochJd: Double?,
    @SerialName("orbit_type")
    val orbitType: String?,
    @SerialName("apoapsis_au")
    val apoapsisAu: Double?,
    @SerialName("periapsis_au")
    val periapsisAu: Double?,
    @SerialName("semi_major_axis_au")
    val semiMajorAxisAu: Double?,
    val eccentricity: Double?,
    val inclination: Double?,
    val longitude: Double?,
    @SerialName("periapsis_arg")
    val periapsisArg: Double?,
    @SerialName("period_days")
    val periodDays: Double?,
    @SerialName("speed_kph")
    val speedKph: Double?,
    @SerialName("speed_mph")
    val speedMph: Double?,
    @SerialName("earth_distance_km")
    val earthDistanceKm: Double?,
    @SerialName("earth_distance_mi")
    val earthDistanceMi: Double?,
    @SerialName("mars_distance_km")
    val marsDistanceKm: Double?,
    @SerialName("mars_distance_mi")
    val marsDistanceMi: Double?,
    @SerialName("flickr_images")
    val flickrImages: List<String>?,
    val wikipedia: String?,
    val video: String?,
    val details: String?,
)
