package com.haroldadmin.spacexkmp.dragons

import com.haroldadmin.spacexkmp.common.Length
import com.haroldadmin.spacexkmp.common.Mass
import com.haroldadmin.spacexkmp.common.Thrust
import com.haroldadmin.spacexkmp.common.Volume
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class HeatShield(
    val material: String,
    @SerialName("size_meters")
    val sizeMeters: Double,
    @SerialName("temp_degrees")
    val tempDegrees: Double?,
    @SerialName("dev_partner")
    val devPartner: String,
)

@Serializable
public data class Thruster(
    val type: String?,
    val amount: Int?,
    val pods: Int?,
    @SerialName("fuel_1")
    val fuelOne: String?,
    @SerialName("fuel_2")
    val fuelTwo: String?,
    val isp: Int?,
    val thrust: Thrust?
)

@Serializable
public data class PressurizedCapsule(
    @SerialName("payload_volume")
    val payloadVolume: Volume?
)

@Serializable
public data class Trunk(
    @SerialName("trunk_volume")
    val trunkVolume: Volume?,
    val cargo: Cargo,
)

@Serializable
public data class Cargo(
    @SerialName("solar_array")
    val solarArray: Int?,
    @SerialName("unpressurized_cargo")
    val unpressurizedCargo: Boolean?
)

@Serializable
public data class Dragon(
    val id: String,
    val name: String,
    val type: String,
    val active: Boolean,
    @SerialName("crew_capacity")
    val crewCapacity: Int,
    @SerialName("sidewall_angle_deg")
    val sidewallAngleDeg: Double,
    @SerialName("orbit_duration_yr")
    val orbitDurationYr: Double,
    @SerialName("dry_mass_kg")
    val dryMassKg: Double,
    @SerialName("dry_mass_lb")
    val dryMassLb: Double,
    @SerialName("first_flight")
    val firstFlight: String?,
    @SerialName("heat_shield")
    val heatShield: HeatShield,
    val thrusters: List<Thruster>?,
    @SerialName("launch_payload_mass")
    val launchPayloadMass: Mass?,
    @SerialName("launch_payload_vol")
    val launchPayloadVol: Volume?,
    @SerialName("return_payload_mass")
    val returnPayloadMass: Mass?,
    @SerialName("return_payload_vol")
    val returnPayloadVol: Volume?,
    @SerialName("pressurized_capsule")
    val pressurizedCapsule: PressurizedCapsule,
    val trunk: Trunk,
    @SerialName("height_w_trunk")
    val heightWithTrunk: Length?,
    val diameter: Length?,
    @SerialName("flickr_images")
    val flickrImages: List<String>?,
    val wikipedia: String?,
    val description: String?,
)
